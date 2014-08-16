package com.icetee.lapis.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.json.JSONException;
import org.json.JSONObject;

import com.icetee.lapis.main.Action;

public class ActionTest {
	Action fullTestData, noParameterTestData;
	ArrayList<String> expectedKeywordsFull;
	ArrayList<ArrayList<String>> expectedParameterFull;

	@Before
	public void setUp() throws Exception {
		fullTestData = new Action(new JSONObject("{"
			+ "'name': 'Test Action',"
			+ "'execute': 'exec testAction.ex',"
			+ "'keywords': ["
			+ "	'key',"
			+ "	'word'"
			+ "],"
			+ "'parameters': ["
			+ "	["
			+ "		'set',"
			+ "		'unset'"
			+ "	],"
			+ "	["
			+ "		'[0-9]*',"
			+ "		'[a-z]*',"
			+ "		'[A-Z]*'"
			+ "	]"
			+ "]"
		+ "}"));
		
		expectedKeywordsFull = new ArrayList<String>();
		expectedKeywordsFull.add("key");
		expectedKeywordsFull.add("word");

		expectedParameterFull = new ArrayList<ArrayList<String>>();

		ArrayList<String> temp = new ArrayList<String>();
		temp.add("set");
		temp.add("unset");
		expectedParameterFull.add(temp);
		
		temp = new ArrayList<String>();
		temp.add("[0-9]*");
		temp.add("[a-z]*");
		temp.add("[A-Z]*");
		expectedParameterFull.add(temp);
		
		noParameterTestData = new Action(new JSONObject("{"
				+ "'name': 'Test Action',"
				+ "'execute': 'exec testAction.ex',"
				+ "'keywords': ["
				+ "	'key',"
				+ "	'word'"
				+ "]"
				+ "}"));
	}

	@Test
	public void testFullData() {
		assertEquals("Test Action", fullTestData.name);
		assertEquals("exec testAction.ex", fullTestData.execute());
		assertEquals(expectedKeywordsFull, fullTestData.getKeywords());
		assertEquals(expectedParameterFull, fullTestData.getParameter());
	}

	@Test
	public void testNoParamData() {
		assertEquals("Test Action", noParameterTestData.name);
		assertEquals("exec testAction.ex", noParameterTestData.execute());
		assertEquals(expectedKeywordsFull, noParameterTestData.getKeywords());
		assertEquals(new ArrayList<ArrayList<String>>(), noParameterTestData.getParameter());
	}
	
	@Test
	public void testFailingData() {
		boolean success = true;
		try {
			new Action(new JSONObject("{"
					+ "'execute': 'exec testAction.ex',"
					+ "'keywords': ["
					+ "	'key',"
					+ "	'word'"
					+ "]"
					+ "}"));
		} catch(JSONException e) {
			success = false;
		}
		if(success)fail("Missing Name doesn't throw an error!");
		
		success = true;
		try {
			new Action(new JSONObject("{"
					+ "'name': 'Test Action',"
					+ "'keywords': ["
					+ "	'key',"
					+ "	'word'"
					+ "]"
					+ "}"));
		} catch(JSONException e) {
			success = false;
		}
		if(success)fail("Missing Execution doesn't throw an error!");
		
		success = true;
		try {
			new Action(new JSONObject("{"
					+ "'name': 'Test Action',"
					+ "'execute': 'exec testAction.ex',"
					+ "}"));
		} catch(JSONException e) {
			success = false;
		}
		if(success)fail("Missing Keywords doesn't throw an error!");
	}
}
