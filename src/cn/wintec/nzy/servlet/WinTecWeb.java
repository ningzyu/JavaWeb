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
		//���ñ��룬��ֹ���Ĵ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
//		Thread.currentThread().sleep(60000);//����   
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
		//������д��PrintWriter�Ｔ��
		PrintWriter writer=response.getWriter();
		writer.write(result);
		writer.flush();//ˢ��
		writer.close();//�ر�
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
