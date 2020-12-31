package com.laptrinhjavaweb.dao;
import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewDAO  {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long Save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
	int getTotalItem();
}
