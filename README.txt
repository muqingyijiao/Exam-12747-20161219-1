数据库用户名：root
数据库用户密码：root

数据库配置信息在"dbconfig.properties"中，"dbconfig.properties"在src目录下，
在JDBCUtil中加载配置文件，得到数据库信息，连接数据库
运行流程：
（1）：首先页面加载index.jsp（点击用户登录）页面，
               从index.jsp（http://localhost/Exam-12747-20161219-1/index.jsp）页面到登录界面，
               或者直接访问如下链接：
      http://localhost/Exam-12747-20161219-1/customer/login.jsp
               在登录界面用户名框中输入用户名，如果用户名存在，
               跳转到success.jsp页面，否则跳转到error.jsp页面
 （2）：首先页面加载index.jsp（http://localhost/Exam-12747-20161219-1/index.jsp）页面
           （点击film列表显示），
 	    跳转到film列表页面，在这个页面可以对film进行增删改查