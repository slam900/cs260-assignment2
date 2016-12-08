package edu.uwec.cs.olsonsd_hessledd3607.migration;

import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<Integer> states;
	private static ArrayList<Integer> counties;

	public static void main(String[] args) throws FileNotFoundException, NumberFormatException {
		states = new ArrayList<Integer>();
		counties = new ArrayList<Integer>();
		// Used to connect to database
		String URL = "jdbc:oracle:thin:@dario.cs.uwec.edu:1521:csdev";
		String username = "olsonsd";
		String pass = "TJJ7Q8UY";
		DAO dao = new DAO(URL, username, pass);

		File file = new File("data.txt");
		Scanner input = new Scanner(file);
		ArrayList<String[]> list = new ArrayList<String[]>();

		// Parse File
		input.nextLine();
		while (input.hasNextLine()) {
			String line = input.nextLine();
			line = line.replaceAll("'", "''");
			String[] entry = line.split("\\|", 20);
			list.add(entry);
		}

		// Check states list
		// for (int i = 0; i < states.size(); ++i)
		// System.out.println(states.get(i));

		
		for (int i = 0; i < list.size(); ++i) {
			// System.out.println(Arrays.toString(list.get(i)));
			insertEntry(list.get(i), dao);
			if (i % 100 == 0)
				System.out.println(i);
		}

	}

	public static void insertEntry(String[] entry, DAO dao) {
		Integer state = Integer.valueOf(entry[4]);
		if (!states.contains(state)) {
			states.add(state);
			dao.insertWYState(entry);
		}
		//System.out.println(entry[6]);
		//System.out.println(entry[6].length());
		
		Integer county;
		if (!entry[6].isEmpty())
			county = Integer.valueOf(entry[6]);
		else {
			county = new Integer(0);
			entry[6] = "0";
		}
		
		if (!counties.contains(county)) {
			counties.add(county);
			dao.insertWYCounty(entry);
		}
		dao.insertWYPrimary(entry);
		dao.insertWYSource(entry);
		dao.insertWYLocation(entry);
		dao.insertWYFeature(entry);
	}

}
