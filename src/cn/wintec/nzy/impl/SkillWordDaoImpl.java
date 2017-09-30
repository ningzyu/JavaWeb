package cn.wintec.nzy.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wintec.nzy.dao.BaseDao;
import cn.wintec.nzy.dao.SkillWordDao;
import cn.wintec.nzy.model.SkillWord.Word;
import cn.wintec.nzy.model.SkillWord.WordType;

public class SkillWordDaoImpl  extends BaseDao implements SkillWordDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	@Override
	public List<WordType> getWordTypes() {
		List<WordType> list=new ArrayList<WordType>();
		conn=this.getConn();//获得链接
		String sql="select * from skill_type";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();//存放sql数据
			while(rs.next()){
				WordType wtypes=new WordType();//实例化实体类
				wtypes.setId(rs.getInt("id"));
				wtypes.setName(rs.getString("name"));
				list.add(wtypes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return list;
	}
	@Override
	public List<Word> getWords(int id) {
		List<Word> list=new ArrayList<Word>();
		conn=this.getConn();
		String sql="select * from skill_word where typeid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Word item=new Word();
				item.setId(rs.getInt("id"));
				item.setTypeid(rs.getInt("typeid"));
				item.setName(rs.getString("name"));
				item.setFilename(rs.getString("filename"));
				item.setUploaddata(rs.getString("uploaddata"));
				item.setDownloads(rs.getString("downloads"));
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.getClose(rs, pstmt, conn);
		}
		return list;
	}

}
