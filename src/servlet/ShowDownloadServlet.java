package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.FileBean;
import service.FileService;

/**
 * Servlet implementation class ShowDownloadServlet
 */
@WebServlet("/ShowDownloadServlet")
public class ShowDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//查询数据库，得到要下载的信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileBean filebean = new FileBean();
		//调用service层读取数据库数据
		FileService service = new FileService();
		try {
			List<FileBean> rs = service.readAll();
			request.setAttribute("rs", rs);
			//获得请求转发器并转发
			request.getRequestDispatcher("/Download.jsp").forward(request, response);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//封装到Javabean中
		//通过beanutils封装到集合中
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
