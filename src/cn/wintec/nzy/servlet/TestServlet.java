package cn.wintec.nzy.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.wintec.nzy.util.FileUtils;
import cn.wintec.nzy.util.WriteUtils;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//���ñ��룬��ֹ���Ĵ���
				request.setCharacterEncoding("utf-8");
//				�����ж�����ͨ�������Ǵ��ļ��ϴ��ı�
				if(ServletFileUpload.isMultipartContent(request)){
					receiveMessageFromClient(request, response);
				}
	}
	
	/**
	 * ��ȡ�ͻ��ύ����Ϣ���ӿڱ���2
	 */
	public static int receiveMessageFromClient(HttpServletRequest request,
			HttpServletResponse response) {
		int returnCode = -1;//���󷵻�ֵ

		try {
			if(FileUtils.save2File(request)!=0)
				throw new Exception("...");
			returnCode = 0;
			WriteUtils.write(response, returnCode + "");

		} catch (Exception e) {
			returnCode = -1;
			e.printStackTrace();
			WriteUtils.write(response, e.toString());
		} finally {
		}

		return returnCode;
	}
}
