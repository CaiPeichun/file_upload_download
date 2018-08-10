package service;

import java.sql.SQLException;
import java.util.List;

import Dao.FileDao;
import bean.FileBean;

public class FileService {

	public void save(FileBean fileBean) throws SQLException {
		new FileDao().save(fileBean);
	}

	public List<FileBean> readAll() throws SQLException {
		
		return new FileDao().readAll();
	
	}

	public FileBean readById(String id) throws SQLException {
		
		return new FileDao().readById(id);
	}

	

}
