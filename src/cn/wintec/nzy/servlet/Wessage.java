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
		//设置编码，防止中文错乱
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		//随机字符串
		String echostr=request.getParameter("echostr").toString().trim();
				
//				signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
//				timestamp	时间戳
//				nonce	随机数
//				echostr	随机字符串
		//将内容写入PrintWriter里即可
		PrintWriter writer=response.getWriter();
		writer.write(echostr);
		writer.flush();//刷新
		writer.close();//关闭
				
				
				
	}

}
