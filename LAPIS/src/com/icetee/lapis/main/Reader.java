package com.icetee.lapis.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	private BufferedReader br;
	
	private boolean openReader(String filename) {
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch(IOException io) {
			return false;
		}
		return true;
	}
	
	public ArrayList<String> read(String[] directories) {
		ArrayList<String> actions = new ArrayList<String>();
		for(String dir : directories) {
			if(openReader(Main.basePath + "/" + dir + "/inf.json")) {
				actions.add(readFile());
				close();
			}
		}
		
		return actions;
	}
	
	private void close() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String readFile() {
		try {
			String temp = "";
			String file = "";
			while((temp = br.readLine())!=null) {
				file+=temp + System.lineSeparator();
			}
			return file;
		} catch (IOException e) {
			return null;
		}
	}
}
