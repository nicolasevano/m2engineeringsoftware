package com.sodifrance.jsf;

public class StrategieSoustraction implements IStrategieOperation {

	@Override
	public void computeOperation() {
		// TODO Auto-generated method stub
		int result;
		StringBuilder historique;
		int counterOperandes = 0;
		if( "-".equals( invoker.getOperation() + "" ) ){
			historique = new StringBuilder();
			result = invoker.getOperandes().getListOp().get( counterOperandes ).getValeur();
			historique.append( result ).append(" - ");
			Operande currentOperande = invoker.getOperandes().getListOp().get( counterOperandes );
			counterOperandes++;
			do{
				currentOperande = invoker.getOperandes().getListOp().get( counterOperandes );
				result -= currentOperande.getValeur();
				historique.append( currentOperande.getValeur() ).append( ( ( invoker.getOperandes().getListOp().size() - 1 ) > counterOperandes )? " - " : " = " );
				counterOperandes++;
			} while ( ( invoker.getOperandes().getListOp().size() > counterOperandes ) );
			invoker.setResult( result );
			historique.append( result );
			invoker.setOperationExpression( historique.toString() );
			invoker.getHistorique().add( historique.toString() );
		}
	}
	
	public CalculBean getInvoker() {
		return invoker;
	}

	public void setInvoker(CalculBean invoker) {
		this.invoker = invoker;
	}
	
	private CalculBean invoker;

}
