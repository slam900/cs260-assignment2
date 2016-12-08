package edu.uwec.cs.olsonsd_hessledd3607.migration;

import java.io.*;
import java.util.*;

public class Main {
	private static List<Integer> states;
	private static List<County> counties;

	public static void main(String[] args) throws FileNotFoundException, NumberFormatException {
		states = new ArrayList<Integer>();
		counties = new ArrayList<County>();
		// Used to connect to database
		String URL = "jdbc:oracle:thin:@dario.cs.uwec.edu:1521:csdev";
		String username = "olsonsd";
		String pass = "TJJ7Q8UY";
		DAO dao = new DAO(URL, username, pass);

		File file = new File("data.txt");
//		File file = new File("data2.txt");
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
		input.close();

		// Check states list
		// for (int i = 0; i < states.size(); ++i)
		// System.out.println(states.get(i));

		
		for (int i = 0; i < list.size(); ++i) {
//		for (int i = 0; i < 200; ++i) {
			// System.out.println(Arrays.toString(list.get(i)));
			insertEntry(list.get(i), dao);
			
			// Loading bar
			if (i % 100 == 0)
				System.out.println(i);
		}
		// Is auto-commit on?
//		dao.commit();
	}

	public static void insertEntry(String[] entry, DAO dao) {
		Integer state = Integer.valueOf(entry[4]);
		if (!states.contains(state)) {
			states.add(state);
			dao.insertWYState(entry);
		}
		//System.out.println(entry[6]);
		//System.out.println(entry[6].length());
		
		County county;
		if (!entry[6].isEmpty())
			county = new County(Integer.valueOf(entry[6]), state);
		else {
			county = new County(0, state);
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
