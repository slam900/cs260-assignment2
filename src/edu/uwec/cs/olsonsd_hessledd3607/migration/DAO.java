package edu.uwec.cs.olsonsd_hessledd3607.migration;

import java.sql.*;
import java.util.*;

public class DAO {
	private static Connection connection;

	public DAO(String URL, String user, String pass) {
		connection = null;

		try {
			connection = DriverManager.getConnection(URL, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public List<Author> getAuthorData() {
//		List<Author> authors = new ArrayList<Author>();
//
//		// Eliminate authors with no books
//		String query = "SELECT * FROM henry_author a\n"
//				+ "WHERE author_num IN (\n"
//				+ "SELECT author_num FROM henry_wrote)\n"
//				+ "ORDER BY author_last";
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet results = statement.executeQuery(query);
//
//			while (results.next()) {
//				int authorNumber = results.getInt("author_num");
//				String lastName = results.getString("author_last");
//				String firstName = results.getString("author_first");
//				authors.add(new Author(authorNumber, lastName, firstName));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return authors;
//	}


}
