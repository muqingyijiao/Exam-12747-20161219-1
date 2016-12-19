package cn.yijiao.customer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yijiao.customer.service.CustomerService;

public class CustomerLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5660094138197954492L;

	private CustomerService customerService = new CustomerService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String customerName = req.getParameter("customerName");

		if (customerName!="") {
			boolean flag = customerService.checkCustomer(customerName);
			//System.out.println(flag+"flag");
			if (flag) {
				req.getSession().setAttribute("loginFlag", "success_login");
				req.getRequestDispatcher("/customer/success.jsp").forward(req, resp);
			} else {
				req.getSession().setAttribute("loginFlag", "error_login");
				req.setAttribute("msg", "您输入的用户名不存在");
				req.getRequestDispatcher("/customer/error.jsp").forward(req, resp);
			}
		} else {
			req.getSession().setAttribute("loginFlag", "error_login");
			req.setAttribute("msg", "用户名为空");
			//System.out.println("空的用户名");
			req.getRequestDispatcher("/customer/error.jsp").forward(req, resp);
		}
		//System.out.println(customerName);
	}
}
