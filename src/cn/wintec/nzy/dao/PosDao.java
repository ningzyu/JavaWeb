package cn.wintec.nzy.dao;

import java.util.List;

import cn.wintec.nzy.model.Pos;
import cn.wintec.nzy.model.Pos.PosItem;
import cn.wintec.nzy.model.Pos.PosTypes;

public interface PosDao {
	List<PosTypes> getPos();//���ط����б���
	PosTypes getType(int id);
	List<PosItem> getItems();//����ȫ�����ͼ���
	List<PosItem> getItems(int id);//����type id���ػ��ͼ���
	PosItem getItem(int itemid);
}
