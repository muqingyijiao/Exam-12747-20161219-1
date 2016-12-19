package cn.yijiao.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yijiao.customer.dao.dao.CustomerDao;
import cn.yijiao.customer.entity.Customer;

public class CustomerImpl implements CustomerDao {

	@Override
	public List<Customer> findByName(Connection conn, String customerName) {

		String sql = "select *from customer where first_name=?";
		PreparedStatement ps;
		List<Customer> list = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, customerName);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<>();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(rs.getInt("customer_id"));
				customer.setStore_id(rs.getInt("store_id"));
				customer.setFirst_name(rs.getString("first_name"));
				customer.setLast_name(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setAddress_id(rs.getInt("address_id"));
				customer.setActive(rs.getInt("active"));
				customer.setCreate_date(rs.getDate("create_date"));
				customer.setLast_update(rs.getDate("last_update"));
				list.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
//测试代码
//	public static void main(String[] args) {
//		Connection conn = new JDBCUtil().getConnection();
//		System.out.println(new CustomerImpl().findByName(conn, "MARY"));
//	}

}
