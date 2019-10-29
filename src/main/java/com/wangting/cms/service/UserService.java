package com.wangting.cms.service;

import com.github.pagehelper.PageInfo;
import com.wangting.cms.entity.User;

public interface UserService {

	/**
	 * 判断用户名是否已经被占用
	 * @param username
	 * @return
	 */
	boolean checkExist(String username);
/**
 * 注册用户
 * @param user
 * @return
 */
	int register(User user);
/**
 * 登录
 * @param user
 * @return
 */
	User login(User user);
	
	/**
	 * 用户管理//用户管理 禁用和解封
	 * @param page
	 * @param locked
	 * @return
	 */
	PageInfo<User> list(Integer page, int locked);
	
	/**
	 * 修改禁止该用户
	 * @param id
	 * @param locked
	 * @return
	 */
	int update(Integer id ,String locked);
	
	/**
	 * 个人主要上传头像
	 * @param user
	 * @return
	 */
	int addHead_picture(User user);
	
	
}
