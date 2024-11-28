package com.laptrinhjavaweb.dao.imlp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
 
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
	
		String sql = "SELECT *FROM NEWS WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

}
