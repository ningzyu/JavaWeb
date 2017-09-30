package cn.wintec.nzy.dao;

import java.util.List;

import cn.wintec.nzy.model.SkillWord.Word;
import cn.wintec.nzy.model.SkillWord.WordType;

public interface SkillWordDao {
	List<WordType> getWordTypes();//返回分类列表集合
	List<Word> getWords(int id);//根据type id返回机型集合
}
