package cn.wintec.nzy.dao;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private String sqlname="root";
	private String sqlpwd="jty7559809";
//	private String sqlpwd="root";
	//���ݿ�����
		public Connection getConn(){
			Connection conn=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");//��������
				//��ȡ����
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pos",sqlname,sqlpwd);
			} catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return conn;
		}
		//�ر�
		public void getClose(ResultSet rs,PreparedStatement pstmt,Connection conn){
				try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		}
}
