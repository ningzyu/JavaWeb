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
				//设置编码，防止中文错乱
				request.setCharacterEncoding("utf-8");
//				用于判断是普通表单，还是带文件上传的表单
				if(ServletFileUpload.isMultipartContent(request)){
					receiveMessageFromClient(request, response);
				}
	}
	
	/**
	 * 获取客户提交的信息，接口编码2
	 */
	public static int receiveMessageFromClient(HttpServletRequest request,
			HttpServletResponse response) {
		int returnCode = -1;//请求返回值

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
