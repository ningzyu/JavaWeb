package cn.wintec.nzy.dao;

import java.util.List;

import cn.wintec.nzy.model.Info;

public interface InfoDao {
	List<String> getMesIds(String openid);//根据openid返回用户所有信息
					//更改状态(已读未读)
	List<Info> getMesItems(int mesid);//根据Id获取信息列表
//	int getNotMes(int mesid);//未读条数
//	int newInfo(Info info);
	
}
