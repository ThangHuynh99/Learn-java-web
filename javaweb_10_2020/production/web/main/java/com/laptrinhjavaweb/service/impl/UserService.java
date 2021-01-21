package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;
import javax.inject.Inject;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dao.impl.UserDAO;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO iuser;
	@Override
	public UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status) {
		return iuser.findByUserNameAndPassWordAndStatus(userName, passWord, status);
	}
	
}
