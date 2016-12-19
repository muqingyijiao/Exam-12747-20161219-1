package cn.yijiao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/sakila";
	private String user = "root";
	private String password = "root";
	private Connection conn;

	public Connection getConnection() {

		try {
			// 加载驱动
			Class.forName(driver);
			// 得到数据库连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
	//数据库连接测试代码
//	public static void main(String[] args) {
//		System.out.println(new JDBCUtil().getConnection());
//	}

}
