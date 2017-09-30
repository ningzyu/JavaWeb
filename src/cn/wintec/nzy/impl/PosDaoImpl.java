package cn.wintec.nzy.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wintec.nzy.dao.BaseDao;
import cn.wintec.nzy.dao.PosDao;
import cn.wintec.nzy.model.Pos;
import cn.wintec.nzy.model.Pos.PosItem;
import cn.wintec.nzy.model.Pos.PosTypes;
import cn.wintec.nzy.model.SystemModel;

public class PosDaoImpl extends BaseDao implements PosDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	

	@Override
	public List<PosTypes> getPos() {
		List<PosTypes> list=new ArrayList<PosTypes>();
		conn=this.getConn();//获得链接
		String sql="select * from postypes";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();//存放sql数据
			while(rs.next()){
				PosTypes ptypes=new PosTypes();//实例化实体类
				ptypes.setId(rs.getInt("id"));
				ptypes.setTitle(rs.getString("title"));
				ptypes.setIcon(rs.getString("icon"));
//				ptypes.setItems(getItems(rs.getInt("id")));
				list.add(ptypes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return list;
	}
	@Override
	public PosTypes getType(int id) {
		PosTypes ptypes=new PosTypes();
		conn=this.getConn();//获得链接
		String sql="select * from postypes where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();//存放sql数据
			if(rs.next()){
				ptypes.setId(rs.getInt("id"));
				ptypes.setTitle(rs.getString("title"));
				ptypes.setIcon(rs.getString("icon"));
				ptypes.setItems(getItems(id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return ptypes;
	}

	@Override
	public List<PosItem> getItems() {
		List<PosItem> list=new ArrayList<PosItem>();
		conn=this.getConn();
		String sql="select * from positem";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				PosItem item=new PosItem();
				item.setId(rs.getInt("id"));
				item.setTypeid(rs.getInt("typeid"));
				item.setName(rs.getString("name"));
				String img=SystemModel.URL+rs.getString("image");
				item.setImage(img);
				item.setBanners(new String []{img,img});
				item.setSynopsis(rs.getString("synopsis"));
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<PosItem> getItems(int id) {
		List<PosItem> list=new ArrayList<PosItem>();
		conn=this.getConn();
		String sql="select * from positem where typeid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				PosItem item=new PosItem();
				item.setId(rs.getInt("id"));
				item.setTypeid(rs.getInt("typeid"));
				item.setName(rs.getString("name"));
				String img=SystemModel.URL+rs.getString("image");
				item.setImage(img);
				item.setBanners(new String []{img,img});
				item.setSynopsis(rs.getString("synopsis"));//简介
				item.setTraits(rs.getString("traits").split(" - "));//产品特点
				item.setParalist(rs.getString("params").split(" - "));
				item.setVideo(rs.getString("imgs"));
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return list;
	}
	@Override
	public PosItem getItem(int itemid) {
		PosItem item=null;
		conn=this.getConn();
		String sql="select * from positem where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, itemid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				item=new PosItem();
				item.setId(rs.getInt("id"));
				item.setTypeid(rs.getInt("typeid"));
				item.setName(rs.getString("name"));
				String img=SystemModel.URL+rs.getString("image");
				item.setImage(img);
				item.setBanners(new String []{img,img});
				item.setSynopsis(rs.getString("synopsis"));//简介
				item.setTraits(rs.getString("traits").split(" - "));//产品特点
				item.setParalist(rs.getString("params").split(" - "));
				item.setVideo(rs.getString("imgs"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return item;
	}
	
	
}
