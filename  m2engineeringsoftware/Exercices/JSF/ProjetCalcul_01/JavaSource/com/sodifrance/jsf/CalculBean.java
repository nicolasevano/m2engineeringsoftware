package com.sodifrance.jsf;

public class CalculBean {
	
	public int getOperande1() {
		return operande1;
	}
	
	public void setOperande1( int operande1 ) {
		this.operande1 = operande1;
	}
	
	public int getOperande2() {
		return operande2;
	}
	
	public void setOperande2( int operande2 ) {
		this.operande2 = operande2;
	}
	
//	public int getResult() {
//		return result;
//	}
//
//	public void setResult( int resutl ) {
//		this.result = resutl;
//	}
	
	/**
	 * in case of action on plus button in jsf presentation.
	 * @return String jsp page name
	 */
	public String plus(){
		//this.result = this.operande1 + this.operande2;
		return "plus";
	}
	
	/**
	 * in case of action on minus button in jsf presentation.
	 * @return String jsp page name
	 */
	public String moin(){
		//this.result = this.operande1 - this.operande2;
		return "moins";
	}
	
	private int operande1 /*= 0*/;
	
	private int operande2 /*= 0*/;
	
	//private int result = 0;

}
