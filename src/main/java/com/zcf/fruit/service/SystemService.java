/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.zcf.fruit.service;

import com.zcf.fruit.common.config.Global;
import com.zcf.fruit.common.utils.Servlets;
import com.zcf.fruit.common.utils.StringUtils;
import com.zcf.fruit.dao.mysqlDao.user.RoleDao;
import com.zcf.fruit.dao.mysqlDao.user.UserDao;
import com.zcf.fruit.entity.user.User;
import com.zcf.fruit.util.UserUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class SystemService implements InitializingBean {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
//	@Autowired
//	private MenuDao menuDao;



	//-- User Service --//
	
	/**
	 * 获取用户
	 * @param username
	 * @return
	 */
	public User getUser(String username) {
		return UserUtils.get(username);
	}

	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return
	 */
	public User getUserByUserName(String loginName) {
		return UserUtils.getByLoginName(loginName);
	}

	/**
	 * 更新登录IP和时间
	 * @param user 用户实体类
	 */
	public void updateUserLoginInfo(User user){
		// 保存上次登录信息
		user.setOldLoginIp(user.getLoginIp());
		user.setOldLoginDate(user.getLoginDate());
		// 更新本次登录信息
		user.setLoginIp(StringUtils.getRemoteAddr(Servlets.getRequest()));
		user.setLoginDate(new Date());
		userDao.update(user);
	};

	/**
	 * 获取Key加载信息
	 */
	public static boolean printKeyLoadMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用 "+Global.getConfig("productName")+"  - Powered By http://www.dianxianguo.com\r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
		return true;
	}


	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
