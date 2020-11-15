package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class AbstractDAO<T> implements GenericDAO<T> {

	public String con = "com.mysql.jdbc.Driver";

	// ham tao connection voi sql.
	public Connection getConnection() {
		try {
			Class.forName(con);
			String url = "jdbc:mysql://localhost:3306/newservlet10month2020";
			String userName = "root";
			String passWord = "172304";
			return DriverManager.getConnection(url, userName, passWord);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			// set parameter()
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}

}