package com.laptrinhjavaweb.dao.imlp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // sau khi depen ow file pomm => de load drive voi chuoi nay
			String url = "jdbc:mysql://localhost:3306/newservlet";
			String user = "root";
			String password = "Quoctan290101";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;

		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}

		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i <= parameters.length; i++) {
				int index = i + 1;
				Object parameter = parameters[i];
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
