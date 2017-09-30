package cn.wintec.nzy.dao;

import java.util.List;

import cn.wintec.nzy.model.Pos;
import cn.wintec.nzy.model.Pos.PosItem;
import cn.wintec.nzy.model.Pos.PosTypes;

public interface PosDao {
	List<PosTypes> getPos();//返回分类列表集合
	PosTypes getType(int id);
	List<PosItem> getItems();//返回全部机型集合
	List<PosItem> getItems(int id);//根据type id返回机型集合
	PosItem getItem(int itemid);
}
