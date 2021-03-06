package com.huwl.oracle.wechat.catcher.user_catcher;

import java.util.Date;

public class Comment {
	private String nickName;
	private String remark;
	private String content;
	private Date postTime;
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	@Override
	public String toString() {
		return nickName + "\t" +remark+ "\t" +content + "\t" + postTime.toLocaleString() ;
	}
	public Comment(String nickName, String remark, String content,
			Date postTime) {
		super();
		this.nickName = nickName;
		this.remark = remark;
		this.content = content;
		this.postTime = postTime;
	}
	public Comment() {}
	
}
