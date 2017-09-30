package cn.wintec.nzy.test;

import java.util.ArrayList; 
import java.util.List;

import com.google.gson.Gson;

import cn.wintec.nzy.dao.InfoDao;
import cn.wintec.nzy.dao.SkillWordDao;
import cn.wintec.nzy.impl.InfoDaoImpl;
import cn.wintec.nzy.impl.SkillWordDaoImpl;
import cn.wintec.nzy.model.Info;
import cn.wintec.nzy.model.SkillWord;
import cn.wintec.nzy.model.SkillWord.WordType;

public class SkillWordTest {

	public static void main(String[] args) {
//		Gson gson=new Gson();
//		SkillWord sw=new SkillWord();
//		SkillWordDao swdao=new SkillWordDaoImpl();
//		List<WordType> list=swdao.getWordTypes();
//		for(WordType wt:list){
//			wt.setWords(swdao.getWords(wt.getId()));
//		}
//		sw.setWtypes(list);
//		System.out.println(gson.toJson(sw));
//		String s="asd-asd - bsda-sda - ad-sas - sdas-das";
//		for(String ss:s.split(" - ")){
//			System.out.println(ss);
//		}
		InfoDao infodao=new InfoDaoImpl();
//		infodao.newInfo(setInfos("ogucB0bNuyW99qJCq5DLpC0UQS4A",//KEY
//				"软件工作室",//客户
//				"宁先生",//联系人
//				"18736074474",//手机
//				"18888888888@163.com",//邮箱
//				"山西太原",//地址
//				"山西忻州",//地址
//				"售前咨询",//类型
//				0,//
//				"2017-02-08",//时间
//				"我想咨询一下盖章机",//内容
//				null,//图片数组
//				null,//视频
//				"0"//已读
//				));
	}

//	public static Info setInfos(String openid, String clientName, String name, 
//			String phone, String email, String location,
//			String address, String type,int mestype, String data,
//			String content, String imgs, String video, String isread){
//		List<MesItem>list=new ArrayList<Info.MesItem>();
//		list.add(new Info().new MesItem(1,mestype,data,content,imgs,video,isread));
//		
//		
//		return new Info(openid,clientName,name,phone,email,location,address,type,list);
//	}
}
