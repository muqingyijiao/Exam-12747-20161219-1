package cn.yijiao.customer.dao.dao;

import java.sql.Connection;
import java.util.List;

import cn.yijiao.customer.entity.Customer;

public interface CustomerDao {

	public List<Customer> findByName(Connection conn,String customerName);

}
