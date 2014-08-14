package com.icetee.lapis.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static final String basePath = "./actions";
	
	public static ActionList al;
	
	public static void main(String[] args) {
		Parser p = new Parser();
		loadActions();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		try {
			System.out.println("Action:");
			while(!(temp = br.readLine()).equals("exit")) {
				System.out.println(p.parse(temp, al));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Run through the actions directory and load every file to parse it into actions
	 */
	public static void loadActions() {
		// Initialize a Reader
		Reader reader = new Reader();
		// Define the root folder
		File root = new File(basePath);
		// Only let folders through
		FilenameFilter filenameFilter = new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		};
		
		ArrayList<String> actions = reader.read(root.list(filenameFilter));
		
		al = new ActionList(actions);
	}
}
