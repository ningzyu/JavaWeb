package cn.wintec.nzy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import cn.wintec.nzy.model.Info;
import cn.wintec.nzy.model.ResultBean;
import cn.wintec.nzy.model.SystemModel;
import cn.wintec.nzy.util.FileUtils;
import cn.wintec.nzy.util.WriteUtils;

/**
 * Servlet implementation class WinTecWeb
 */
@WebServlet("/WinTecWeb")
public class WinTecWeb extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码，防止中文错乱
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
//		Thread.currentThread().sleep(60000);//毫秒   
		String result="";
		WxResponse wxres=new WxResponse();
		if(ServletFileUpload.isMultipartContent(request)){
			receiveMessageFromClient(request, response);
		}else{
			String paratype=request.getParameter("paratype").toString().trim();
			switch(paratype){
				case "Skill":
					result=wxres.getSkill();
					break;
				case "Messages":
					result=wxres.getMessage(request);
					break;
				case "Message":
					result=wxres.getMesItem(request);
					break;
				case "submit":
					
					break;
				case "getopenid":
					String code=request.getParameter("code").toString().trim();
					result=SystemModel.getOpenid(code);
					break;
			}
		};
		//将内容写入PrintWriter里即可
		PrintWriter writer=response.getWriter();
		writer.write(result);
		writer.flush();//刷新
		writer.close();//关闭
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
