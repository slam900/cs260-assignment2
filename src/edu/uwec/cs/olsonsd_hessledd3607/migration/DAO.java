package edu.uwec.cs.olsonsd_hessledd3607.migration;

import java.sql.*;

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

	public void insertWYState(String[] s) {
		String query = "INSERT INTO WY_STATE VALUES (" + s[4] + ", " + "'" + s[3] + "'" + ")";
	//	System.out.println(query);
		try {
			Statement statement = connection.createStatement();
			int results = statement.executeUpdate(query);

	//		System.out.println(results);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWYCounty(String[] s) {
		String query = "INSERT INTO WY_COUNTY VALUES (" + s[6] + ", '" + s[5] + "', " +s[4] + ")";
	//	System.out.println(query);
		try {
			Statement statement = connection.createStatement();
			int results = statement.executeUpdate(query);

		//	System.out.println(results);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWYPrimary(String[] s) {
		String query = "INSERT INTO WY_PRIMARY VALUES (PRIMARY_SEQ.NEXTVAL, '" + s[7] + "', '" + s[8] + "', '" +s[9] + "', '" + s[10] + "')";
	//	System.out.println(query);
		try {
			Statement statement = connection.createStatement();
			int results = statement.executeUpdate(query);

	//		System.out.println(results);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWYSource(String[] s) {
		String query = "INSERT INTO WY_SOURCE VALUES (SOURCE_SEQ.NEXTVAL, '" + s[11] + "', '" + s[12] + "', '" +s[13] + "', '" + s[14] + "')";
	//	System.out.println(query);
		try {
			Statement statement = connection.createStatement();
			int results = statement.executeUpdate(query);

	//		System.out.println(results);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWYLocation(String[] s) {
		String query = "INSERT INTO WY_LOCATION VALUES (LOCATION_SEQ.NEXTVAL, " + s[6] +", PRIMARY_SEQ.CURRVAL, SOURCE_SEQ.CURRVAL, " +s[15] + ", " + s[16] + ")";
	//	System.out.println(query);
		try {
			Statement statement = connection.createStatement();
			int results = statement.executeUpdate(query);

	//		System.out.println(results);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWYFeature(String[] s) {
		String query = "INSERT INTO WY_FEATURE VALUES (" + s[0] + ", '" + s[1] +"', '" + s[2] + "', LOCATION_SEQ.CURRVAL, '" + s[17] + "', '" +s[18] + "', '" + s[19] + "')";
	//	System.out.println(query);
		try {
			Statement statement = connection.createStatement();
			int results = statement.executeUpdate(query);

	//		System.out.println(results);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
