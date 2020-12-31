package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewService {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel Save(NewModel newModel);
	NewModel Update(NewModel updateNew);
	void delete(long[] ids);
	List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
	int getTotalItem();
}
