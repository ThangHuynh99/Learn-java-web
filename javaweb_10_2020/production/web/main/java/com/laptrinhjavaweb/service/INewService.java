package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewService {
	NewModel findOne(long id);
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel Save(NewModel newModel);
	NewModel Update(NewModel updateNew);
	void delete(long[] ids);
	//List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
