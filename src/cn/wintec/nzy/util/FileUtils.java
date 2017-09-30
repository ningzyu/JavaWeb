package cn.wintec.nzy.util;

import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class FileUtils {

	/**
	 * 根据路径和文件夹名称创建文件夹
	 * 
	 * @param path
	 * @param folderName
	 */
	public static void buildFolderInDisc(String path) {
		File file = new File(path);
		file.mkdirs();
	}
	/**
	 * 
	 * @param request
	 * @param path
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static int save2File(HttpServletRequest request){
		String path = "E:\\WintecStorage\\";
		String rootAddr;
		Map<String, String> map = new HashMap<String, String>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String filename;
		try {
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
//			map = getPara(list);
//			if(map!=null){
				rootAddr = path + "nzy" + "\\";
				FileUtils.buildFolderInDisc(rootAddr);
//			}
			
			int i=0;
			for(FileItem item : list){
				if(item.isFormField()){
				} else{
					i++;
//					filename = "Img_" + messageId + "_" + i + ".jpg";
					filename=item.getName();
					File file=new File(rootAddr+filename);
                    OutputStream out = new FileOutputStream(file);
                    InputStream in = item.getInputStream() ;
                    writeFile(out, in);
                    in.close();
                    out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 1;
	}
	
	
	/**
	 * 
	 * @param request
	 * @param path
	 * @return
	 */
	/**@SuppressWarnings("unchecked")
	public static int save2File(HttpServletRequest request){
		int rtnCode = -1;
		int count = 0;
//		String userId = null, comName = null,
		String path = "E:\\WintecStorage\\";
		String rootAddr= null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String filename;
		try {
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
			Map<String, String> map = getPara(list);
			if(map!=null){
//				userId = map.get("userid");
//				comName = map.get("comname");
//				userName = map.get("username");
				rootAddr = path + "userId" + "\\";
					//没有用户记录
					FileUtils.buildFolderInDisc(rootAddr);
					count = 1;
			}
			int i=0;
			for(FileItem item : list){
				if(item.isFormField()){
					
				} else{
					i++;
					filename=item.getName();
//					filename = "PICTURE_" + i + item.getName().substring(item.getName().indexOf("."));
					System.out.println(filename);
					File file=new File(rootAddr+filename);
                    OutputStream out = new FileOutputStream(file);
                    InputStream in = item.getInputStream() ;
                    writeFile(out, in);
                    System.out.println(path);
                    in.close();
                    out.close();
				}
			}
			rtnCode = 0;
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rtnCode;
	}*/

	
	private static Map<String, String> getPara(List<FileItem> list)throws IOException{
		Map<String, String> map = new HashMap<String,String>();
		for(FileItem item : list){
			if(item.isFormField()){
				if("userid".equals(item.getFieldName()))
					map.put("userid", item.getString("utf-8"));
//				if("comname".equals(item.getFieldName()))
//					map.put("comname", item.getString("utf-8"));
//				if("username".equals(item.getFieldName()))
//					map.put("username", item.getString("utf-8"));
//				if("sendtime".equals(item.getFieldName()))
//					map.put("sendtime", item.getString("utf-8"));
//				if("remark".equals(item.getFieldName()))
//					map.put("remark", item.getString("utf-8"));
//				if("tel".equals(item.getFieldName()))
//					map.put("tel", item.getString("utf-8"));
//				if("postype".equals(item.getFieldName()))
//					map.put("postype", item.getString("utf-8"));
//				if("address".equals(item.getFieldName()))
//					map.put("address", item.getString("utf-8"));
			}
		}
		return map;
	}

	public static void writeFile(OutputStream os, InputStream in) throws IOException {
		int length = 0 ;
        byte [] buf = new byte[1024] ;
        while( (length = in.read(buf) ) != -1){
            os.write(buf, 0, length);
        }
        
	}
	

}
