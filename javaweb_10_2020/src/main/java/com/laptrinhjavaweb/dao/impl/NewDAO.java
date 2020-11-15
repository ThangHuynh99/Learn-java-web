package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO{
	public String con = "com.mysql.jdbc.Driver";

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
	public List<NewModel> findByCategoryId(Long categoryId) {
		List<NewModel> results = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		// open connection
		Connection conn = getConnection();
		if (conn != null) {
			try {
				statement = conn.prepareStatement(sql);
				statement.setLong(1, categoryId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					NewModel news = new NewModel();
					news.setId(resultSet.getLong("id"));
					news.setTitle(resultSet.getString("code"));
					results.add(news);
				}
				return results;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
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
				}catch(SQLException e) {
					return null;
				}
			}
		}
		return null;
	}

}
