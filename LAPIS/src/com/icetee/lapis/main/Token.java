package com.icetee.lapis.main;

public class Token {
	private TokenType type;
	private String content;
	
	public Token(TokenType type, String content) {
		setType(type);
		this.content = content; 
	}
	
	public void setType(TokenType type) {
		this.type = type;
	}
	
	public TokenType getType() {
		return type;
	}
	
	public String getContent() {
		return content;
	}
	
	public String toString() {
		return "(" + getType() + ", " + getContent() + ")";
	}
}
