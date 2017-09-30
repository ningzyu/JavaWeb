package cn.wintec.nzy.impl;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wintec.nzy.dao.BaseDao;
import cn.wintec.nzy.dao.InfoDao;
import cn.wintec.nzy.model.Info;

public class InfoDaoImpl  extends BaseDao implements InfoDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	@Override
	public List<String> getMesIds(String openid) {
		List<String> list=new ArrayList<String>();
		conn=this.getConn();
		String sql="select * from mesitem where openid=? and mestype=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, openid);
			pstmt.setInt(2, 0);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(rs.getInt("newid")+"");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return list;
	}
	
	@Override
	public List<Info> getMesItems(int newId) {
		List<Info> list=new ArrayList<Info>();
		conn=this.getConn();
		String sql="select * from mesitem where newId=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, newId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Info info=new Info();
				info.setId(rs.getInt("id"));
				info.setNewId(rs.getInt("newId"));
				info.setMestype(rs.getInt("mestype"));
				info.setOpenid(rs.getString("openid"));
				info.setType(rs.getString("type"));
				info.setData(rs.getString("mdata"));
				info.setContent(rs.getString("content"));
				info.setImgs(rs.getString("imgs").split("-"));
				info.setVideo(rs.getString("video"));
				info.setIsread(rs.getString("isread"));
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return list;
	}
	
//	@Override
//	public int newInfo(Info info) {
//			int i=0;
//			String para="openid,clientName,name,phone,email,location,address,type";
//			conn=this.getConn();//获得连接
//			String sql="insert into messages("+para+") values(?,?,?,?,?,?,?,?)";//sql语句
//			try {
//				pstmt=conn.prepareStatement(sql);//
//				pstmt.setString(1,info.getOpenid());
//				pstmt.setString(2,info.getClientName());
//				pstmt.setString(3,info.getName());
//				pstmt.setString(4,info.getPhone());
//				pstmt.setString(5,info.getEmail());
//				pstmt.setString(6,info.getLocation());
//				pstmt.setString(7,info.getAddress());
//				pstmt.setString(8,info.getType());
//				i=pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally{
//				this.getClose(rs, pstmt, conn);
//			}
//			return i;
//		
//	}
	
}
