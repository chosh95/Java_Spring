package kr.co.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.UserBean;
import kr.co.mapper.UserMapper;

@Repository
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public String checkUserIdExist(String user_id) {
		return userMapper.checkUserIdExist(user_id);
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userMapper.addUserInfo(joinUserBean);
	}
	
	public UserBean getLoginUserInfo(UserBean tempLoginUserBean) {
		return userMapper.getLoginUserInfo(tempLoginUserBean);
	}
}
