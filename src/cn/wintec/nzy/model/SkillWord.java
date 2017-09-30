package cn.wintec.nzy.model;

import java.util.List;

public class SkillWord {
	private String result;//请求结果
    private List<WordType> wtypes;//分类项集合
    private List<WordType> wtypes2;//分类项集合
    
    
    public List<WordType> getWtypes2() {
		return wtypes2;
	}

	public void setWtypes2(List<WordType> wtypes2) {
		this.wtypes2 = wtypes2;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<WordType> getWtypes() {
		return wtypes;
	}

	public void setWtypes(List<WordType> wtypes) {
		this.wtypes = wtypes;
	}

	public static class WordType{
    	private int id;
    	private String name;
    	private List<Word> words;//分类项集合
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Word> getWords() {
			return words;
		}
		public void setWords(List<Word> words) {
			this.words = words;
		}
    	
    	
    	
    }
    
	public static class Word{
		private int id;
		private int typeid;
	    private String name;
	    private String filename;
	    private String uploaddata;
	    private String downloads;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getTypeid() {
			return typeid;
		}
		public void setTypeid(int typeid) {
			this.typeid = typeid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		public String getUploaddata() {
			return uploaddata;
		}
		public void setUploaddata(String uploaddata) {
			this.uploaddata = uploaddata;
		}
		public String getDownloads() {
			return downloads;
		}
		public void setDownloads(String downloads) {
			this.downloads = downloads;
		}
	    	
	}
    
    
}
