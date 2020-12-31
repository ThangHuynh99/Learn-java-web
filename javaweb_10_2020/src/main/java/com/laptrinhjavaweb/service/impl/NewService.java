package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
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

	
	@Override
	public NewModel Save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDao.Save(newModel);
//		System.out.println(newId);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel Update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			newDao.delete(id);
		}
	}

	@Override
	public NewModel findOne(Long id) {
		return newDao.findOne(id);
	}

	@Override
	public List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy) {
		// TODO Auto-generated method stub
		return newDao.findAll(offset, limit, sortName, sortBy);
	}

	@Override
	public int getTotalItem() {
		
		return newDao.getTotalItem();
	}

	
	

}
