import java.util.*;
public class Test{
public static void main(String[] args){
Date d1=new Date();
	for(int i=0;i<5000;i++){
	System.out.println(1111);
}
Date d2=new Date();
System.out.println(("java循环5000次用时：")+(d2.getTime()-d1.getTime()));
}
}