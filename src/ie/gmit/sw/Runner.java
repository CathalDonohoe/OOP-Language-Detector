package ie.gmit.sw;

import java.io.File;
import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Runner {
	private static Scanner console = new Scanner(System.in);

	private static String wili;
	private static String query;
	
	
	public static void main(String[] args) throws Throwable {

		Menu menu = new Menu();
		setWili();
		setQuery();
		menu.displayMenu();
		
		Parser p = new Parser(getWili(), 3);

		Database db = new Database();
		p.setDb(db);
		Thread t = new Thread(p);
		t.start();
		t.join();

		db.resize(300);
		
		p.analyseQuery(getQuery());
	}

	//set/get wili file.
	public static void setWili(){
		String input = "";
		boolean fileReal = false;
		
		System.out.println("_____________________________Wili__________________________");
		
		while (!fileReal) {
			System.out.println("please enter wili file name(please include the (.txt)\n");
			input = console.next();
			if (new File(input).isFile()) { // checks if file exists
				fileReal = true;
			} else {
				System.out.println("thats not a file try again");
			}
		}
		wili = input;
		Runner.wili=wili;
	}
	
	public static String getWili() {
		return wili;
	}
	

	//set/get query file.
	public static void setQuery() {
		String input = "";
		boolean fileReal = false;
		
		System.out.println("______________________________Query________________________");
		
		
		while (!fileReal) {
			System.out.println("please enter query file name(please include the (.txt)\n");
			input = console.next();
			if (new File(input).isFile()) { // checks if file exists
				fileReal = true;
			} else {
				System.out.println("thats not a file try again");
			}
		}
		query = input;
		Runner.query = query;
	}
	
	public static String getQuery() {
		return query;
	}
}