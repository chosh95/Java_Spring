package kr.co.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.beans.UserBean;
import kr.co.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	public boolean checkUserIdExist(String user_id) {
		String user_name = userDao.checkUserIdExist(user_id);
		if(user_name==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}
	
	public void getLoginUserInfo(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_id());
			loginUserBean.setUserLogin(true);
		}
	}
}
