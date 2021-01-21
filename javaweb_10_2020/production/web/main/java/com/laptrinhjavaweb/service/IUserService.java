package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface IUserService {
	UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status);
}
