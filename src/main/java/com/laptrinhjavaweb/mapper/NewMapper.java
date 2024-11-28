package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	public NewModel mapRow(ResultSet rs) {
		NewModel news = new NewModel();
		try {
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			return news;
		} catch (SQLException e) {
			return null;
		}
	}

}
