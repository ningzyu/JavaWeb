package cn.wintec.nzy.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class WriteUtils {

	public static void write(HttpServletResponse response, String rtnMsg){
		try {
			PrintWriter writer = response.getWriter();
			writer.write(rtnMsg);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
