package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.ICommentDAO;
import com.laptrinhjavaweb.dao.impl.CategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.ICommentService;

public class CommentService implements ICommentService{
	@Inject
	private ICommentDAO iComment;
	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			iComment.delete(id);
		}
	}
	
}
