package edu.uwec.cs.olsonsd_hessledd3607.migration;

import java.sql.*;

public class DAO {
	private static Connection connection;

	public DAO(String URL, String user, String pass) {
		connection = null;
		
		try {
			connection = DriverManager.getConnection(URL, user, pass);
//			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void commit() {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		String query =
				"INSERT INTO WY_LOCATION VALUES ("
				+ "LOCATION_SEQ.NEXTVAL"
				+ ", " + s[6]
				+ ", " + s[4]
				+ ", PRIMARY_SEQ.CURRVAL"
				+ ", SOURCE_SEQ.CURRVAL"
				+ ", " + s[15]
				+ ", " + s[16]
				+ ")";
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
		String query = "INSERT INTO WY_FEATURE VALUES (" + s[0] + ", '" + s[1] +"', '" + s[2] + "', LOCATION_SEQ.CURRVAL, '" + s[17] + "', '" + convertDate(s[18]) + "', '" + convertDate(s[19]) + "')";
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
	
	private String convertDate(String date) {
		String newDate = "";
		if (!date.isEmpty()) {
			String[] tokens = date.split("/");
			int monthNum = Integer.valueOf(tokens[0]);
			String day = tokens[1];
			String year = tokens[2];
			
			String month;
			switch (monthNum) {
				case 1:
					month = "JAN";
					break;
				case 2:
					month = "FEB";
					break;
				case 3:
					month = "MAR";
					break;
				case 4:
					month = "APR";
					break;
				case 5:
					month = "MAY";
					break;
				case 6:
					month = "JUN";
					break;
				case 7:
					month = "JUL";
					break;
				case 8:
					month = "AUG";
					break;
				case 9:
					month = "SEP";
					break;
				case 10:
					month = "OCT";
					break;
				case 11:
					month = "NOV";
					break;
				case 12:
					month = "DEC";
					break;
				default:
					month = "Invalid month";
					break;
			}
			newDate = day + "-" + month + "-" + year;
		}
		return newDate;
	}
}
