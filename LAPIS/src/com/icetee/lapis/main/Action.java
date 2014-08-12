package com.icetee.lapis.main;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Action {
	public String name;
	private String execute;
	private ArrayList<String> keywords;
	
	public Action(JSONObject action) {
		keywords = new ArrayList<String>();
		parse(action);
	}
	
	private void parse(JSONObject action) {
		name = action.getString("name");
		execute = action.getString("execute");
		JSONArray keywordsjson = action.getJSONArray("keywords");
		for(int i = 0; i<keywordsjson.length(); i++) {
			keywords.add(keywordsjson.getString(i));
		}
		
	}
	
	public void execute() {
		//TODO Implement
	}
	
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	public ArrayList<String>[] getParameter() {
		//TODO Implement
		return null;
	}
}
