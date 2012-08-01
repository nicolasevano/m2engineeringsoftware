package com.sodifrance.jsf;

import java.util.Map;
import java.util.TreeMap;

public class CalculBean {
	
	public CalculBean(){
		
		operationStrategies = new TreeMap<String,IStrategieOperation>();
		StrategieAddition addStrat = new StrategieAddition();
		addStrat.setInvoker( this );
		operationStrategies.put( "+", addStrat );
		StrategieSoustraction soustracStrat = new StrategieSoustraction();
		soustracStrat.setInvoker( this );
		operationStrategies.put( "-", soustracStrat );
		StrategieMultiplication mulStrat = new StrategieMultiplication();
		mulStrat.setInvoker( this );
		operationStrategies.put( "*", mulStrat );
		
	}
	
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
	
	public int getOperande3() {
		return operande3;
	}

	public void setOperande3( int operande3 ) {
		this.operande3 = operande3;
	}
	
	public int getResult() {
		return result;
	}

	public void setResult( int resutl ) {
		this.result = resutl;
	}
	
	public String getOperationExpression() {
		return operationExpression;
	}

	public void setOperationExpression(String operationExpression) {
		this.operationExpression = operationExpression;
	}
	
	public String computeOperation(){
		//use strategie pattern to compute operation
		System.out.println( "compute operation with operation = " + operation );
		operationStrategies.get( this.operation + "" ).computeOperation();
		return "OK";
	}
	
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
	
	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}
	
	private int operande1;
	
	private int operande2;
	
	private int operande3;
	
	private char operation = '+';
	
	private int result;
	
	private String operationExpression;
	
	private Map<String,IStrategieOperation> operationStrategies;

}
