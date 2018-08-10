package servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import bean.FileBean;
import service.FileService;
import sun.misc.BASE64Encoder;
import utils.FileUploadUtils;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��ȡid
		String id = request.getParameter("id");
		//����service���õ�resource����
		FileService service = new FileService();
		try {
			FileBean fileBean = service.readById(id);
			
			File file = new File(fileBean.getSavepath(), fileBean.getUuidname());
			if(file.exists()) {
				String filename = fileBean.getRealname();
				String mimeType = this.getServletContext().getMimeType(filename);
				response.setContentType(mimeType);//������������
				String agent = request.getHeader("user-agent");
				if (agent.contains("MSIE")) {
					// IE�����
					filename = URLEncoder.encode(filename, "utf-8");

				} else if (agent.contains("Firefox")) {
					// ��������
					BASE64Encoder base64Encoder = new BASE64Encoder();
					filename = "=?utf-8?B?"
							+ base64Encoder.encode(filename.getBytes("utf-8"))
							+ "?=";
				} else {
					// ���������
					filename = URLEncoder.encode(filename, "utf-8");
				}
				//������Զ�����ض���ֱ�Ӵ�
				response.setHeader("content-disposition", "attachment;filename=" + filename);
				byte[] bs =FileUtils.readFileToByteArray(file);
				response.getOutputStream().write(bs);
				
			}
			else {
				throw new RuntimeException("��Դ�ѹ���");
			}
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
