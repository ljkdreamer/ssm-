package com.util;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MyUtil {
	/**
	 * ���ʱ���ַ���
	 */
	public static String getStringID(){
		String id=null;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		id=sdf.format(date);
		return id;
	}
	/**
	 * ��ֹ�ļ�����
	 */
	public static String getRandom() {
		int n = (int)(Math.random()*100000000);
		return n + "";
	}
	/**
	 * ����ļ�����չ��
	 */
	public static String getFileExtendsName(String filenname) {
		int lastPointIndex = filenname.lastIndexOf(".");
		String extendsName = filenname.substring(lastPointIndex);
		return extendsName;
	}
	/**
	 * ���ر���ʱ�����ļ����ַ�����ת������
	 */
	public static String toUTF8String(String str){
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		for(int i = 0; i < len; i++){
			//ȡ���ַ��е�ÿ���ַ�
			char c = str.charAt(i);
			//Unicode��ֵ��0-255֮�䣬��������
			if(c >= 0 && c <= 255){
				sb.append(c);
			}else{//ת��UTF-8����
				byte b[];
				try {
					b = Character.toString(c).getBytes("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					b = null;
				}
				//ת��Ϊ%HH���ַ�����ʽ
				for(int j = 0; j < b.length; j ++){
					int k = b[j];
					if(k < 0){
						k &= 255;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

}
