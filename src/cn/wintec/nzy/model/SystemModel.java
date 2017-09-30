package cn.wintec.nzy.model;


import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import cn.wintec.nzy.util.HttpRequestUtil;

public class SystemModel {
//	public static String URL="http://192.168.12.67:8888/";
	public static String URL="http://www.xixihaha.xin/";
	//΢��С�����������ַ
	public static  String wxurl="https://api.weixin.qq.com/sns/jscode2session";
	//С����APPID
//	public static String APPID="wx55c378f8dd068514";//����
	public static String APPID="wxa0850bac2300cffe";//wintec
	//С������Կ
//	public static String AppSecert="451feb52bb72e6547abc7a7b72b016dc";
	public static String AppSecert="db5ecf0a12e8ea06ca41c390e3554a87";
	
	//��������
	public static String getOpenid(String code){
		String jsons=HttpRequestUtil.HttpGet(wxurl, "appid="+APPID+
        		 "&secret="+AppSecert+
			     "&js_code="+code+
			     "&grant_type=authorization_code");
		String openid="";
		JsonParser parse =new JsonParser();  //����json������
		try {
            JsonObject json = (JsonObject) parse.parse(jsons);
			  //����jsonObject����
//            System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //��json����תΪΪint�͵�����
            openid=json.get("openid").getAsString();
            System.out.println("openid:"+openid);     //��json����תΪΪString�͵�����
			} catch (JsonIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return openid;
	}
			
		
		
}
