package com.sodifrance.jsf;

public class BienvenueBean {
	
	public void action(){
		output = input;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	
	private String input;
	private String output;
}
