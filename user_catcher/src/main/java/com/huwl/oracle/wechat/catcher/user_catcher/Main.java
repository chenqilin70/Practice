package com.huwl.oracle.wechat.catcher.user_catcher;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public static CloseableHttpClient httpClient=HttpClients.createDefault();
	public static ObjectMapper objectMapper=new ObjectMapper();
	public static final String USER_LIST_URL="https://mp.weixin.qq.com/misc/appmsgcomment";
	public static final String USER_LIST_HEAD="user_list_head.properties";
	public static final SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final String USER_LIST_PARAM="user_list_param.properties";
	public static final Scanner scan=new Scanner(System.in);
	public static final String COOKIES;
	public static final String TOKEN;
	public static StringBuffer result=new StringBuffer("");
	static{
		System.out.println("请输入cookies：");
		COOKIES=scan.nextLine();
		System.out.println("请输入token：");
		TOKEN=scan.nextLine();
	}
	public static void main(String[] args) {
		System.out.println("请输入您要扫描的起始页：");
		int begin=scan.nextInt();
		System.out.println("请输入您要扫描总页数：");
		int end=scan.nextInt();
		int j=begin+end-1;
		for(int i=begin-1;i<j;i++){
			JsonNode usersRoot=getUsersRoot(i*10);
			for(JsonNode user:usersRoot){
				Comment comment=dealWithUser(user);
				result.append(comment+"\n");
				System.out.println(comment);
			}
		}
		try {
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("result.txt"));
			out.write(result.toString().getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static JsonNode getUsersRoot(int begin) {
		String content=getStr(USER_LIST_URL, USER_LIST_HEAD, USER_LIST_PARAM, new BasicNameValuePair("begin", ""+begin));
		int search_key_index=content.indexOf("search_key");
		String search_key=content.substring(search_key_index, content.indexOf("seajs.use", search_key_index));
		String listUser=search_key.substring(search_key.indexOf("list")+5, search_key.lastIndexOf("};")).trim();
		JsonNode usersRoot=null;
		try {
			usersRoot=objectMapper.readTree(listUser).path("comment");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usersRoot;
	}


	private static Comment dealWithUser(JsonNode user) {
		String nickname=user.path("nick_name").textValue();
		String fakeId=user.path("fake_id").textValue();
		String content=user.path("content").textValue();
		Date postTime=null;
		try {
			postTime=new Date(user.path("post_time").longValue()*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String info=getPostStr("https://mp.weixin.qq.com/cgi-bin/user_tag?action=get_fans_info"
				, "user_info_head.properties"
				, "user_info_param.properties"
				, new BasicNameValuePair("user_openid", fakeId));
		JsonNode infoRoot=null;
		try {
			infoRoot=objectMapper.readTree(info);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String userRemark=infoRoot.path("user_list").path("user_info_list").get(0).path("user_remark").textValue();
		Comment commen=new Comment(nickname, userRemark, content, postTime);
		return commen;
	}


	//根据传入的类和文件获取配置文件中的值组成的List
	public static <T> List<T> getPropertiesList(Class<T> clazz,String file){
		if(clazz!=BasicHeader.class &&   clazz!=BasicNameValuePair.class)
			return null;
		Properties single_music_list=PropertiesUtil.getProperties("src/main/resources/"+file);
		List<T> list=new ArrayList<>();
		Object item=null;
		for(Object key:single_music_list.keySet()){
			if(clazz==BasicHeader.class)
				item=new BasicHeader(key.toString(),single_music_list.get(key).toString());
			else if(clazz==BasicNameValuePair.class)
				item=new BasicNameValuePair(key.toString(),single_music_list.get(key).toString());
			list.add((T)item);
		}
		return list;
	}
	public static String getPostStr(String uri,String headerFile,String paramFile,BasicNameValuePair nameValuePair){
		List<BasicHeader> headers=getPropertiesList(BasicHeader.class, headerFile);
		headers.add(new BasicHeader("Cookie", COOKIES));
		List<BasicNameValuePair> params=getPropertiesList(BasicNameValuePair.class,paramFile );
		params.add(new BasicNameValuePair("token", TOKEN));
		CloseableHttpResponse  response=null;
		try {
			if(nameValuePair!=null)
				params.add(nameValuePair);
			List<NameValuePair> paramsList=new ArrayList<>();
			for(BasicNameValuePair bnvp:params)
				paramsList.add(bnvp);
			Header[] headerArray=new Header[headers.size()];
			for(int i=0;i<headers.size();i++)
				headerArray[i]=headers.get(i);
			
			HttpPost httpPost=new HttpPost(new URIBuilder(uri).build());
			httpPost.setEntity(new UrlEncodedFormEntity(paramsList));
			
			httpPost.setHeaders(headerArray);
			response =httpClient.execute(httpPost);
			HttpEntity entity=response.getEntity();
			if(entity!=null){
				return EntityUtils.toString(entity, "utf-8");
			}else{
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				response.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "";
	}
	public static String getStr(String uri,String headerFile,String paramFile,BasicNameValuePair nameValuePair){
		List<BasicHeader> headers=getPropertiesList(BasicHeader.class, headerFile);
		headers.add(new BasicHeader("Cookie", COOKIES));
		List<BasicNameValuePair> params=getPropertiesList(BasicNameValuePair.class,paramFile );
		params.add(new BasicNameValuePair("token", TOKEN));
		CloseableHttpResponse  response=null;
		try {
			URIBuilder uriBuilder=new URIBuilder(uri);
			
			if(nameValuePair!=null)
				params.add(nameValuePair);
			
			List<NameValuePair> paramsList=new ArrayList<>();
			for(BasicNameValuePair bnvp:params)
				paramsList.add(bnvp);
			Header[] headerArray=new Header[headers.size()];
			for(int i=0;i<headers.size();i++)
				headerArray[i]=headers.get(i);
			
			
			uriBuilder.setParameters(paramsList);
			HttpGet httpGet=new HttpGet(uriBuilder.build());
			
			httpGet.setHeaders(headerArray);
			response =httpClient.execute(httpGet);
			HttpEntity entity=response.getEntity();
			if(entity!=null){
				return EntityUtils.toString(entity, "utf-8");
			}else{
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				response.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "";
	}
}
