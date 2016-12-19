package cn.yijiao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;

	public Connection getConnection() {
		Properties prop = new Properties();

		try {

			InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	// 数据库连接测试代码
	public static void main(String[] args) {
		System.out.println(new JDBCUtil().getConnection());
	}

}
