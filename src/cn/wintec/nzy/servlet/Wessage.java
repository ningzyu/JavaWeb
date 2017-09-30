package cn.wintec.nzy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Wessage
 */
@WebServlet("/Wessage")
public class Wessage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ��룬��ֹ���Ĵ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		//����ַ���
		String echostr=request.getParameter("echostr").toString().trim();
				
//				signature	΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce������
//				timestamp	ʱ���
//				nonce	�����
//				echostr	����ַ���
		//������д��PrintWriter�Ｔ��
		PrintWriter writer=response.getWriter();
		writer.write(echostr);
		writer.flush();//ˢ��
		writer.close();//�ر�
				
				
				
	}

}
