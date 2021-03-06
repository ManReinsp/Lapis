package com.icetee.lapis.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Action {
	// The name of the action in form PACKAGE - ACTION
	public String name;
	// A command line command that gets executed when this action is picked
	private String execute;
	// All keywords this action listens to
	private ArrayList<String> keywords;
	// All appropriate sets of parameters to be used in this action
	ArrayList<ArrayList<String>> parameters; 
	
	/**
	 * Each Action gets initialized with its respective JSONObject that was taken from a <code>inf.json</code> file and holds all necessary information
	 * 
	 * @param action
	 */
	public Action(JSONObject action) {
		parse(action);
	}
	
	private void parse(JSONObject action) {
		// Initialize the keywords available for this Action 
		keywords = new ArrayList<String>();

		// Assign the name and execution code for this Action 
		name = action.getString("name");
		execute = action.getString("execute");
		
		// Pull off the keywords from the JSONObject and store them in a JSONArray
		JSONArray keywordsjson = action.getJSONArray("keywords");
		
		// Loop over the keywords
		for(int i = 0; i<keywordsjson.length(); i++) {
			// Add each keyword into the ArrayList
			keywords.add(keywordsjson.getString(i));
		}
		
		// Initialize the parameters available for this Action
		parameters = new ArrayList<ArrayList<String>>();
		// Try to load the JSONArray
		try {
			// Store the parameters as JSONArray
			JSONArray parametersjson = action.getJSONArray("parameters");
			
			// Loop over the previously created array
			for(int i = 0; i<parametersjson.length(); i++) {
				// Initialize a temporary ArrayList
				ArrayList<String> temp = new ArrayList<String>();
				// Fetch all possibilities for parameter i
				JSONArray parameterjson = parametersjson.getJSONArray(i);
				
				// Loop over all possibilities
				for(int j = 0; j<parameterjson.length(); j++) {
					// Write those into the temporary array
					temp.add(parameterjson.getString(j));
				}
				
				// Add the array to the parameter storage
				parameters.add(temp);
			}
			// If no parameters are available just skip the assignment
		} catch(JSONException e) {}
	}
	
	/**
	 * Return the stored command
	 * @return
	 */
	public String execute() {
		return execute;
	}
	
	/**
	 * Return the stored keywords
	 * @return
	 */
	public ArrayList<String> getKeywords() {
		return keywords;
	}

	/**
	 * Return the stored parameters
	 * @return
	 */
	public ArrayList<ArrayList<String>> getParameter() {
		return parameters;
	}
}
