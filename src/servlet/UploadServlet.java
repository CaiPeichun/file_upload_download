package servlet;

import java.awt.ItemSelectable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.mchange.v2.beans.BeansUtils;

import bean.FileBean;
import service.FileService;
import sun.nio.ch.IOUtil;
import sun.print.resources.serviceui_pt_BR;
import utils.FileUploadUtils;

/**
 * 1.����ļ��ϴ�����ز���
 * 2.���ļ��ϴ�����Ϣ�洢��db��
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = new HashMap<String,String[]>();
		//		1.����һ��DiskFileItemFactory
		DiskFileItemFactory factory = new DiskFileItemFactory();
//		2.����ServletFileUpload��	
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
//		3.���������ϴ�����
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fileItem : items) {
				if(fileItem.isFormField()) {
						map.put("description", new String[] {fileItem.getString("utf-8")});
					}
				else {
					 String filename = fileItem.getName();
					 filename = FileUploadUtils.getRealName(filename);//��ȡ�ļ�����ʵ�ļ���
					 map.put("realname",new String[] { filename });
					 
					 String uuidname = FileUploadUtils.getUUIDFileName(filename);
					 map.put("uuidname", new String[] { uuidname });//��ȡ����װ����ļ���
					 
					 String randompath = FileUploadUtils.getRandomDirectory(filename);
					 String uploadpath = request.getServletContext().getRealPath("/WEB-INF/upload");
					 File parentFile = new File(uploadpath, randompath);
					 if(!parentFile.exists())
						 parentFile.mkdirs();//�����ļ������Ŀ¼
					 map.put("savepath", new String[] {uploadpath+randompath});//��װ�ϴ��ļ��ı���·��
					 
					 //�ϴ��ļ�
					 IOUtils.copy(fileItem.getInputStream(), new FileOutputStream(new File(parentFile, uuidname)));
					 fileItem.delete();
				}
			}
			// �����ݷ�װ��javaBean
			 FileBean fileBean = new FileBean();
			 BeanUtils.populate(fileBean, map);
			 
			// ����service��ɱ������ݵ�db��
			 FileService service = new FileService();
			 service.save(fileBean);
			 
			 response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
