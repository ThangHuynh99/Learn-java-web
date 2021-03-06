package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.impl.CategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
//	private ICategoryDAO categoryDao;
//	
//	public CategoryService() {
//		categoryDao = new CategoryDAO();
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel findOne(long id) {
		return categoryDao.findOne(id);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		// TODO Auto-generated method stub
		return categoryDao.findOneByCode(code);
	}

}
