package com.sodifrance.jsf;

public class StrategieAddition implements IStrategieOperation {

	@Override
	public void computeOperation() {
		// TODO Auto-generated method stub
		//System.out.println("operation = '" + invoker.getOperation() + "'.");
		if( "+".equals( invoker.getOperation() + "" ) ){
			invoker.setResult( invoker.getOperande1() + invoker.getOperande2() + invoker.getOperande3() );
			invoker.setOperationExpression( invoker.getOperande1() + 
					" + " + 
					invoker.getOperande2() + 
					" + " + 
					invoker.getOperande3() + 
					" = " + 
					invoker.getResult() );
		}
	}
	
	public CalculBean getInvoker() {
		return invoker;
	}

	public void setInvoker( CalculBean invoker ) {
		this.invoker = invoker;
	}
	
	private CalculBean invoker;

}
