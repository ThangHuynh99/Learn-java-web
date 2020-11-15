package com.laptrinhjavaweb.service.impl;

import java.util.List;
import javax.inject.Inject;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.dao.INewDAO;

public class NewService implements INewService{
	@Inject
	private INewDAO newDao;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newDao.findByCategoryId(categoryId);
	}

}
