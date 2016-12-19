package cn.yijiao.customer.dao.factory;

import cn.yijiao.customer.dao.dao.CustomerDao;
import cn.yijiao.customer.dao.impl.CustomerImpl;

public class CustomerDaoFactory {

	public CustomerDao getCustomerDao() {
		return new CustomerImpl();
	}
}
