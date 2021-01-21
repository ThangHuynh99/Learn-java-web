package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.dao.impl.AbstractDAO;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status) {
		StringBuilder sql = new StringBuilder("Select *from user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" where username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, passWord, status);
		return  users.isEmpty() ? null : users.get(0) ;
	}
	
}