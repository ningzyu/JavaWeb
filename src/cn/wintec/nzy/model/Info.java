package cn.wintec.nzy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ������Ϣʵ��
 * @author NZY
 *
 */
public class Info {
	private int id;//��ϢID
	private int newId;//��Ӧ�½���ϢID
	private int mestype;//0Ϊ�½���Ϣ��1Ϊ������Ϣ��2Ϊ׷��
	private int notread;//δ����Ϣ����
	private String openid;//�û�ΨһKEY	oAD4P0c1RvmfyfKBnt-DUFSlhErs
	private String type;//������Ϣ���� type	��ǰ��ѯ���ۺ��ޡ���Ʒ��ء��������
	private String data;//ʱ���
	private String content;//��������
	private List<String> imgs;//ͼƬ����
	private String video;//��Ƶ
	private String isread;//�Ѷ�δ��
	
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
