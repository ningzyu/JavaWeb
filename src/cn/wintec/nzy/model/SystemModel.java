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
	//微信小程序服务器地址
	public static  String wxurl="https://api.weixin.qq.com/sns/jscode2session";
	//小程序APPID
//	public static String APPID="wx55c378f8dd068514";//心情
	public static String APPID="wxa0850bac2300cffe";//wintec
	//小程序密钥
//	public static String AppSecert="451feb52bb72e6547abc7a7b72b016dc";
	public static String AppSecert="db5ecf0a12e8ea06ca41c390e3554a87";
	
	//网络请求
	public static String getOpenid(String code){
		String jsons=HttpRequestUtil.HttpGet(wxurl, "appid="+APPID+
        		 "&secret="+AppSecert+
			     "&js_code="+code+
			     "&grant_type=authorization_code");
		String openid="";
		JsonParser parse =new JsonParser();  //创建json解析器
		try {
            JsonObject json = (JsonObject) parse.parse(jsons);
			  //创建jsonObject对象
//            System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //将json数据转为为int型的数据
            openid=json.get("openid").getAsString();
            System.out.println("openid:"+openid);     //将json数据转为为String型的数据
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
