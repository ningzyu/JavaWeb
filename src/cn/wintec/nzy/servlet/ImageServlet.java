package cn.wintec.nzy.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  //���ñ���
        //��ô����ļ���Ŀ����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        String str = request.getSession().getServletContext().getRealPath("");
        //��ȡ�ļ���Ҫ�ϴ�����·��
      
        String path = request.getRealPath("/upload");
        String pathStr=null;
        System.err.println("�ϴ���ͼƬ·��:"+path);
        //���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
        //������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
        /**
         * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ�
         * ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ��
         * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
         */
        factory.setRepository(new File(path));
        //���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
        factory.setSizeThreshold(1024*1024) ;
        //��ˮƽ��API�ļ��ϴ�����
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //�����ϴ�����ļ�
            @SuppressWarnings("unchecked")
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
            for(FileItem item : list){
                //��ȡ������������
                String name = item.getFieldName();
                
                System.out.println("name��"+name);
                System.out.println("item��"+item);
                //�����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
                if(item.isFormField()){
                    //��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
                  //  String value = item.getString() ;
                  //  System.out.println("value��"+value);
                  //  request.setAttribute(name, value);
                }else {
                    /**
                     * ������������Ҫ��ȡ �ϴ��ļ�������
                     */
                    //��ȡ·����
                	System.out.println("item.getFieldName()��"+item.getFieldName());
                	
                    String value = item.getName() ;
                    System.out.println("item.getName()��"+item.getName());
                    System.out.println("value��"+value);
                    //���������һ����б��
                   // int start = value.lastIndexOf("");
                   // System.out.println("start��"+start);
                    //��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�
                  //  String filename = value.substring(start+1);
                    String filename= value;
                    System.out.println("filename----->"+filename);
                  //  request.setAttribute(name, filename);
                    //����д��������
                    //���׳����쳣 ��exception ��׽
                    //item.write( new File(path,filename) );//�������ṩ��
                    //�ֶ�д��
                    str+="/upload/"+filename;
                    //pathStr="/upload/"+filename;
                    System.out.println("�ļ��洢��·��:"+str);
                    pathStr=filename;
                    //String str1 ="tmp_70979751o6zAJs6mLmoeDa-H7Xhuv9Yk_2ZQ65081861efc16cf6732feef68075b0c3.png";
                    File file=new File(str);
                    OutputStream out = new FileOutputStream(file);
                    InputStream in = item.getInputStream() ;
                    int length = 0 ;
                    byte [] buf = new byte[1024] ;
                    System.out.println("��ȡ�ϴ��ļ����ܹ���������"+item.getSize());
                    // in.read(buf) ÿ�ζ��������ݴ����   buf ������
                    while( (length = in.read(buf) ) != -1){
                        //��   buf ������ ȡ������ д�� ���������������
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
        }
        PrintWriter printWriter=response.getWriter();
       // printWriter.print("{"path":""+pathStr+""}");
        System.out.println("pathStr----->"+pathStr);
        printWriter.write(pathStr);
        printWriter.print(pathStr);
        printWriter.flush();
        printWriter.close();
    }
}