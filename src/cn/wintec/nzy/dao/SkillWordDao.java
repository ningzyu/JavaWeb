package cn.wintec.nzy.dao;

import java.util.List;

import cn.wintec.nzy.model.SkillWord.Word;
import cn.wintec.nzy.model.SkillWord.WordType;

public interface SkillWordDao {
	List<WordType> getWordTypes();//���ط����б���
	List<Word> getWords(int id);//����type id���ػ��ͼ���
}
