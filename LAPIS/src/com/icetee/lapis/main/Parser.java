package com.icetee.lapis.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Parser {
	public static HashMap<String, TokenType> defaults = new HashMap<String, TokenType>();
	
	public Parser() {
		defaults.put("and", TokenType.COMBINATOR);
		defaults.put(",", TokenType.COMBINATOR);
		defaults.put(".", TokenType.COMBINATOR);
		defaults.put(";", TokenType.COMBINATOR);
		defaults.put("!", TokenType.COMBINATOR);
	}
	
	public String parse(String sentence, ActionList actions) {
		ArrayList<Token> tokens = new ArrayList<Token>();
		sentence = sentence.replaceAll(",", " ,").replaceAll(".", " . ").replaceAll("!", " !").replaceAll(";", " ;").replaceAll("?", " ?");
		
		StringTokenizer tokenizer = new StringTokenizer(sentence);
		String token;
		
		while(tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();
			
			Action a = actions.getActionForKeyword(token);
			Token t = null;
			
			if(a != null) {
				t.setType(TokenType.ACTION);
			} else {
				t = new Token(TokenType.UNDEF, token);
			}
			
			tokens.add(t);
			System.out.println(t);
		}
		
		return "hell yes - " + sentence;
	}
}
