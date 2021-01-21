package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
//	public String con = "com.mysql.jdbc.Driver";
//
//	public Connection getConnection() {
//		try {
//			Class.forName(con);
//			String url = "jdbc:mysql://localhost:3306/newservlet10month2020";
//			String userName = "root";
//			String passWord = "172304";
//			return DriverManager.getConnection(url, userName, passWord);
//		} catch (ClassNotFoundException | SQLException e) {
//			return null;
//		}
//	}
//
//	@Override
//	public List<CategoryModel> findAll() {
//		List<CategoryModel> results = new ArrayList<>();
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		String sql = "SELECT * FROM category";
//		// open connection
//		Connection conn = getConnection();
//		if (conn != null) {
//			try {
//				statement = conn.prepareStatement(sql);
//				resultSet = statement.executeQuery();
//				while (resultSet.next()) {
//					CategoryModel category = new CategoryModel();
//					category.setId(resultSet.getLong("id"));
//					category.setCode(resultSet.getString("code"));
//					category.setName(resultSet.getString("name"));
//					results.add(category);
//				}
//				return results;
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				try {
//				if (conn != null) {
//					conn.close();
//				}
//
//				if (statement != null) {
//					statement.close();
//				}
//
//				if (resultSet != null) {
//					resultSet.close();
//				}
//				}catch(SQLException e) {
//					return null;
//				}
//			}
//		}
//		return null;
//	}

	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public CategoryModel findOne(long id) {
		String sql = "Select * from category where id = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}
	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "Select * from category where code = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), code);
		return category.isEmpty() ? null : category.get(0);
	}
}
