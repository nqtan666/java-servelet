package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {

	@Inject 
	private INewDAO newDao;
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return this.newDao.findByCategoryId(categoryId);
	}

}
