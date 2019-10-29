package com.wangting.cms.service.Impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangting.cms.dao.UserMapper;
import com.wangting.cms.entity.User;
import com.wangting.cms.service.UserService;
import com.wangting.utils.Md5Utils;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */

	//判断用户名是否已经被占用
	@Override
	public boolean checkExist(String username) {
		// TODO Auto-generated method stub
		return null!=userMapper.findByName(username);
	}
// 用户注册 
	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		User existUser =	userMapper.findByName( user.getUsername());
		if(existUser!=null) {
			return -1;// 用户已经存在
		}
		user.setPassword(Md5Utils.md5(user.getPassword(),user.getUsername()));
	
		return userMapper.add(user);
	}
// 用户登录
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		// 获取密码密文
		String pwdStr = Md5Utils.md5(user.getPassword(),user.getUsername());
		//根据用户名称查找用户
		User loginUser =  userMapper.findByName(user.getUsername());
		//System.out.println("Service------loginUser-----"+loginUser);
		//判断数据库中密码密文与与计算所得的密文是否相同
		if(loginUser!=null && pwdStr.equals(loginUser.getPassword())) {
			//登录成功
			return loginUser;
		}
		//登录失败
		return null;
	}
	
	// 查询用户管理 禁用和解封
		@Override
		public PageInfo<User> list(Integer page,int locked) {
			// TODO Auto-generated method stub
			System.out.println(" ============ page is " + page);
			PageHelper.startPage(page, 10);
			return new PageInfo<User>(userMapper.list(locked));
		}
		
		//修改用户管理禁用 和解封
		@Override
		public int update(Integer id ,String locked) {
			// TODO Auto-generated method stub
			return userMapper.update(id ,locked);
		}
		
		/**
		 * 添加个人头像
		 */
		@Override
		public int addHead_picture(User user) {
			// TODO Auto-generated method stub
			return userMapper.addHead_picture(user);
		}
			
	
	

}
