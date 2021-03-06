package com.huwl.oracle.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class TestMain {
	public static void main(String[] args) throws Exception{
		InputStream inputStream=new FileInputStream("src/1.txt");
        byte[] resultByte=new byte[0];
        byte[] buffer=new byte[1024];
        int len=-1;
        while((len=inputStream.read(buffer))!=-1){
        	int oldLen=resultByte.length;
            resultByte=Arrays.copyOf(resultByte,oldLen+len);
            System.arraycopy(buffer,0,resultByte,oldLen,len);
        }
        String result=new String(resultByte);
        System.out.println(result);
	}

}
