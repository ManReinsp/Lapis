package com.icetee.lapis.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class ActionList {
	private ArrayList<Action> actions;
	private HashMap<String, Action> keywords;
	
	public ActionList(ArrayList<String> files) {
		loadActions(files);
		gatherKeywords();
	}
	
	/**
	 * Load the given Strings as JSONObjects, split up the JSONArrays and create Actions 
	 * @param files
	 */
	public void loadActions(ArrayList<String> files) {
		// Initialize the actions Array
		actions = new ArrayList<Action>();
		
		JSONArray json;
		// Loop over all available strings
		for(String file : files) {
			// Parse those to JSONObjects and extract the JSONArray that holds Action informations
			json = new JSONObject(file).getJSONArray("actions");
			// Loop over the new JSONArray
			for(int i = 0; i<json.length(); i++) {
				// Create each respective Action by passing the JSONObject
				actions.add(new Action(json.getJSONObject(i)));
			}
		}
	}
	
	/**
	 * Extract all Keywords from stored Actions and put them into a HashMap in form of (Keyword, Action) 
	 */
	public void gatherKeywords() {
		// Initialize the keywords HashMap
		keywords = new HashMap<String, Action>();
		
		// Loop over all existing Actions
		for(Action a : actions) {
			// Store the keywords for the current action
			ArrayList<String> keywords = a.getKeywords();
			// Loop over all Keywords
			for(String k : keywords) {
				// Check if the keyword isn't already present
				if(!this.keywords.containsKey(k)) {
					// If it is new then enter it
					this.keywords.put(k, a);
				} else {
					// If it is already in use then report collision
					System.out.println("Keyword collision between " + this.keywords.get(k).name + " and " + a.name + "!");
				}
			}
		}
	}
	
	public Action getActionForKeyword(String keyword) {
		return keywords.get("keyword");
	}
}
