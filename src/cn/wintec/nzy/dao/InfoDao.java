package cn.wintec.nzy.dao;

import java.util.List;

import cn.wintec.nzy.model.Info;

public interface InfoDao {
	List<String> getMesIds(String openid);//����openid�����û�������Ϣ
					//����״̬(�Ѷ�δ��)
	List<Info> getMesItems(int mesid);//����Id��ȡ��Ϣ�б�
//	int getNotMes(int mesid);//δ������
//	int newInfo(Info info);
	
}
