
package com.laptrinhjavaweb.dao;

import java.util.List;
import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO  {
	List<CategoryModel> findAll();
	CategoryModel findOne(long id);
	//co the de kieu long khi chi can lay id
	CategoryModel findOneByCode(String code);
}
