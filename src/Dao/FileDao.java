package Dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.FileBean;
import utils.DataSourse;


public class FileDao {

	public void save(FileBean fileBean) throws SQLException {
		String sql = "insert into resources values(null,?,?,?,null,?)";
		QueryRunner runner = new QueryRunner(DataSourse.getDataSourse());
		runner.update(sql, fileBean.getUuidname(),fileBean.getRealname(),fileBean.getSavepath(),fileBean.getDescription());
	}

	public List<FileBean> readAll() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourse.getDataSourse());
		return runner.query("select * from resources", new BeanListHandler<>(FileBean.class));
		
	}

	public FileBean readById(String id) throws SQLException {
		
		QueryRunner runner = new QueryRunner(DataSourse.getDataSourse());
		return runner.query("select * from resources where id=?", new BeanHandler<FileBean>(FileBean.class),id);
	}

	

}
