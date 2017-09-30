package cn.wintec.nzy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 反馈信息实体
 * @author NZY
 *
 */
public class Info {
	private int id;//信息ID
	private int newId;//对应新建信息ID
	private int mestype;//0为新建信息，1为反馈信息，2为追加
	private int notread;//未读消息长度
	private String openid;//用户唯一KEY	oAD4P0c1RvmfyfKBnt-DUFSlhErs
	private String type;//反馈信息类型 type	售前咨询、售后报修、产品相关、质量相关
	private String data;//时间戳
	private String content;//反馈内容
	private List<String> imgs;//图片集合
	private String video;//视频
	private String isread;//已读未读
	
	public Info() {
		super();
	}
	public Info(int id, int newId, int mestype, int notread, String openid, String type, String data, String content,
			List<String> imgs, String video, String isread) {
		super();
		this.id = id;
		this.newId = newId;
		this.mestype = mestype;
		this.notread = notread;
		this.openid = openid;
		this.type = type;
		this.data = data;
		this.content = content;
		this.imgs = imgs;
		this.video = video;
		this.isread = isread;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNewId() {
		return newId;
	}
	public void setNewId(int newId) {
		this.newId = newId;
	}
	public int getMestype() {
		return mestype;
	}
	public void setMestype(int mestype) {
		this.mestype = mestype;
	}
	public int getNotread() {
		return notread;
	}
	public void setNotread(int notread) {
		this.notread = notread;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(String[]  imgs) {
		List<String> list=new ArrayList<String>();
		for(String s:imgs){
			list.add(s);
		}
		this.imgs = list;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	
}	
