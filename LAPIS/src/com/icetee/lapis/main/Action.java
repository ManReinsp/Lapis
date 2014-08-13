package com.icetee.lapis.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Action {
	public String name;
	private String execute;
	private ArrayList<String> keywords;
	ArrayList<ArrayList<String>> group; 
	
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

		group = new ArrayList<ArrayList<String>>();
		try {
			JSONArray parametersjson = action.getJSONArray("parameters");
			
			for(int i = 0; i<parametersjson.length(); i++) {
				ArrayList<String> temp = new ArrayList<String>();
				JSONArray parameterjson = parametersjson.getJSONArray(i);
				
				for(int j = 0; j<parameterjson.length(); j++) {
					temp.add(parameterjson.getString(j));
				}
				
				group.add(temp);
			}
			
			for(ArrayList<String> s : group) {
				for(String t : s) {
					System.out.println(t);
				}
			}
		} catch(JSONException e) {}
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
