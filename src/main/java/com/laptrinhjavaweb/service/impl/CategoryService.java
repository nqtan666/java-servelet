package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.imlp.CategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService{

	// neu khong dung beans.xlm vaf weld-servlet
//	private ICategoryDAO  categoryDao;
//	public CategoryService() {
//		this.categoryDao = new CategoryDAO() ;
//	}
//elsez
	@Inject
	private ICategoryDAO  categoryDao;
	
	@Override
	public List<CategoryModel> finAll() {
		return this.categoryDao.finAll();
	}

}







