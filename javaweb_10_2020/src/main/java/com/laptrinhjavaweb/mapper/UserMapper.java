package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setPassWord(resultSet.getString("password"));
			user.setFullName(resultSet.getString("fullname"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleId(resultSet.getLong("roleid"));
			user.setCreatedDate(resultSet.getTimestamp("createddate"));
			user.setCreatedBy(resultSet.getString("createdby"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.println(e);
			}
			if (resultSet.getTimestamp("modifieddate") != null) {
				user.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				user.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
}
