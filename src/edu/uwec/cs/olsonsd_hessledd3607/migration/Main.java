package edu.uwec.cs.olsonsd_hessledd3607.migration;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// Used to connect to database
		String URL = "jdbc:oracle:thin:@dario.cs.uwec.edu:1521:csdev";
		String username = "OLSONSD";
		String pass = "TJJ7Q8UY";
		DAO dao = new DAO(URL, username, pass);
		
		File file = new File("data.txt");
		Scanner input = new Scanner(file);
		
		//Parse File
		
		while (input.hasNextLine()){
			int currentIndex = 0;
			String line = input.nextLine();
			System.out.print(line.substring(currentIndex, line.indexOf('|')));
			
			currentIndex = line.indexOf('|') + 1;
			
			System.out.print(line.substring(currentIndex, line.indexOf('|')));
			System.out.println();
			
		}
		

	}

}
