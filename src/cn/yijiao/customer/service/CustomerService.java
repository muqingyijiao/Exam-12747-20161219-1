package cn.yijiao.customer.service;

import java.sql.Connection;
import java.util.List;

import cn.yijiao.customer.dao.factory.CustomerDaoFactory;
import cn.yijiao.customer.entity.Customer;
import cn.yijiao.utils.JDBCUtil;

public class CustomerService {

	public boolean checkCustomer(String customerName) {

		Connection conn = new JDBCUtil().getConnection();
		boolean flag = true;

		List<Customer> list = new CustomerDaoFactory().getCustomerDao().findByName(conn, customerName);
		//System.out.println("lsit==="+list);
		if (list==null || list.size()==0) {
			flag = false;
		}
		return flag;
	}
}
