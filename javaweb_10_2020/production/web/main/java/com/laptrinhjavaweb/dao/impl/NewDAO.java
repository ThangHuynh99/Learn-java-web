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
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.sun.xml.internal.ws.util.StringUtils;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
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
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public List<NewModel> findByCategoryId(Long categoryId) {
//		List<NewModel> results = new ArrayList<>();
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		String sql = "SELECT * FROM news WHERE categoryid = ?";
//		// open connection
//		Connection conn = getConnection();
//		if (conn != null) {
//			try {
//				statement = conn.prepareStatement(sql);
//				statement.setLong(1, categoryId);
//				resultSet = statement.executeQuery();
//				while (resultSet.next()) {
//					NewModel news = new NewModel();
//					news.setId(resultSet.getLong("id"));
//					news.setTitle(resultSet.getString("code"));
//					results.add(news);
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
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);

	}

//	@Override
//	public Long Save(NewModel newModel) {
//		ResultSet resultSet = null;
//		PreparedStatement statement = null;
//		Long id = null;
//		Connection conn = null;
//		try {
//			String sql = "INSERT INTO news (title, content, categoryid) VALUES(?, ?, ?)";
//			conn = getConnection();
//			conn.setAutoCommit(false);
//			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			statement.setString(1, newModel.getTitle());
//			statement.setString(2, newModel.getContent());
//			statement.setLong(3, newModel.getCategoryID());
//			statement.executeUpdate();
//			resultSet = statement.getGeneratedKeys();
//			if(resultSet.next()) {
//				id = resultSet.getLong(1);
//			}
//			conn.commit();
//			return id;
//		} catch (SQLException e) {	
//			if(conn != null) {
//				try {
//					conn.rollback();
//				}catch(SQLException el) {
//					el.printStackTrace(); 
//				}
//			}
//			return null;
//		}
//		finally {
//			try {
//			if (conn != null) {
//				conn.close();
//			}
//
//			if (statement != null) {
//				statement.close();
//			}
//
//			if (resultSet != null) {
//				resultSet.close();
//			}
//			}catch(SQLException e) {
//				return null;
//			}
//		}
//	}

	@Override
	public Long Save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO");
		sql.append(" news (title, thumbnail, shortdescription, content, categoryid, ");
		sql.append("createddate, createdby) VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getThumbnail(), newModel.getShortDescription(),
				newModel.getContent(), newModel.getCategoryID(), newModel.getCreatedDate(), newModel.getCreatedBy(),
				newModel.getId());
	}

	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?, ");
		sql.append("shortdescription = ?, content = ?, categoryid = ?, ");
		sql.append("createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryID(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
	}

	// createddate = ?, createdby = ?
	// updateNew.getCreatedDate(), updateNew.getCreatedBy(),
	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		//vi ham query dung chung cho findAll nen dat List<NewModel> r get vi tri thu 0 (dau tien)
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news where id = ?";
		delete(sql, id);
	}

	
	// offset dung de phan trang, noi bat dau row.
//	public List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy) {
//		StringBuilder sql = new StringBuilder("SELECT * from news");
//		if (sortName != null && sortBy != null) {
//			sql.append(" ORDER BY " + sortName + " " + sortBy + "");
//		}
//		if (offset != null && limit != null) {
//			// String sql = "SELECT * from news LIMIT ?, ?";
//			sql.append(" LIMIT ?, ?");
//			return query(sql.toString(), new NewMapper(), offset, limit);
//		} else {
//			return query(sql.toString(), new NewMapper());
//		}
//	}
	
	//ham moi
	@Override
	public List<NewModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		// co the dung StringUtils.isNotBlank cua apache commons lang
		if (pageble.getSorter().getSortName() != null && pageble.getSorter().getSortBy() != null ) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+ pageble.getOffset() + ", "+pageble.getLimit()+"");
		}
		return query(sql.toString(), new NewMapper());
	}

	
	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}
}
