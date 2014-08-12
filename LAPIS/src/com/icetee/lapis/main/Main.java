package com.icetee.lapis.main;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class Main {
	public static final String basePath = "./actions";
	
	public static ActionList al;
	
	public static void main(String[] args) {
		loadActions();
	}
	
	public static void loadActions() {
		Reader reader = new Reader();
		File root = new File(basePath);
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
