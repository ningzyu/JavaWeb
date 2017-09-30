package cn.wintec.nzy.servlet;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.wintec.nzy.dao.InfoDao;
import cn.wintec.nzy.dao.SkillWordDao;
import cn.wintec.nzy.impl.InfoDaoImpl;
import cn.wintec.nzy.impl.SkillWordDaoImpl;
import cn.wintec.nzy.model.Info;
import cn.wintec.nzy.model.SkillWord;
import cn.wintec.nzy.model.SkillWord.WordType;

public class WxResponse {
	public String getSkill(){
		Gson gson=new Gson();
		SkillWord sw=new SkillWord();
		SkillWordDao swdao=new SkillWordDaoImpl();	
		List<WordType> list=swdao.getWordTypes();
		for(WordType wt:list){
			wt.setWords(swdao.getWords(wt.getId()));
		}
		sw.setWtypes(list);
		sw.setWtypes2(list);
		return gson.toJson(sw);
	}
	private String openid;
	private InfoDao infodao;
	public  String getMesItem(HttpServletRequest request){
		infodao=new InfoDaoImpl();
		String newid=request.getParameter("newid").toString().trim();
		System.out.println("用户请求数据："+newid);
		List<Info> list=infodao.getMesItems(Integer.parseInt(newid));
		return new Gson().toJson(list);
	}
	public  String getMessage(HttpServletRequest request){
		infodao=new InfoDaoImpl();
		try{
			openid=request.getParameter("openid").toString().trim();
			System.out.println("用户请求数据："+openid);
		}catch(NullPointerException e){
			openid="";
		}
		System.out.println("用户请求数据："+openid);
		List<String> list=infodao.getMesIds(openid);
		if(list.size()==0){
			return "";
		}
		List<List<Info>> infos=new ArrayList<List<Info>>();
		for(String mesid:list){
			infos.add(infodao.getMesItems(Integer.parseInt(mesid)));
		}
		System.out.println(new Gson().toJson(infos));
		return new Gson().toJson(infos);
	}
	
	
	
}
