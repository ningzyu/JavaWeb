package cn.wintec.nzy.servlet;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.wintec.nzy.dao.PosDao;
import cn.wintec.nzy.impl.PosDaoImpl;
import cn.wintec.nzy.model.Pos;
import cn.wintec.nzy.model.ResultBean;

/**http://192.168.12.67:8888/WinTec/PosServlet
 * Servlet implementation class PosServlet
 * 
 * Message?openid=oAD4P0c1RvmfyfKBnt-DUFSlhErs
 */
@WebServlet("/PosServlet")
public class PosServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码，防止中文错乱
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String typeid=null;
		String itemid=null;
		try{
			typeid=request.getParameter("typeid").toString().trim();
		}catch(NullPointerException e){
			typeid="";
		}
		try{
			itemid=request.getParameter("itemid").toString().trim();
			}catch(NullPointerException e){
				itemid="";
			}
		Gson gson=new Gson();
		Pos pos=new Pos();
		PosDao posdao=new PosDaoImpl();	
		PrintWriter writer=response.getWriter();
//		resultBean.setResult("success");					
//		resultBean.setResult("fail");
		if(typeid.equals("")&&itemid.equals("")){
			pos.setResult("success");
			pos.setPtypes(posdao.getPos());
			writer.write(gson.toJson(pos));
		}else if(!typeid.equals("")){
			writer.write(gson.toJson(posdao.getType(Integer.parseInt(typeid))));
//			writer.write("查询全部");
//			writer.write(gson.toJson(posdao.getItems()));
		}else if(!itemid.equals("")){
			writer.write(gson.toJson(posdao.getItem(Integer.parseInt(itemid))));
		}
		writer.flush();//刷新
		writer.close();//关闭
		
	}

}
