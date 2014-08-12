package com.icetee.lapis.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class ActionList {
	private ArrayList<Action> actions;
	private HashMap<String, Action> keywords;
	
	public ActionList(ArrayList<String> files) {
		actions = new ArrayList<Action>();
		
		JSONArray json;
		for(String file : files) {
			json = new JSONObject(file).getJSONArray("actions");
			for(int i = 0; i<json.length(); i++) {
				actions.add(new Action(json.getJSONObject(i)));
			}
		}
	}
}
