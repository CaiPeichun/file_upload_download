package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourse {

	private static ComboPooledDataSource dbSource = new ComboPooledDataSource();
	
	public static Connection getConnection() throws SQLException {
		System.out.println("连接成功");
		return dbSource.getConnection();
		
	}
	
	public static DataSource getDataSourse() {
		return dbSource;
	}
}
