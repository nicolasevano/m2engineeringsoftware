package com.sodifrance.jsf;


import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.model.SelectItem;

public class CalculBean {
	
	public CalculBean(){
		
		this.operationStrategies = new TreeMap<String,IStrategieOperation>();
		StrategieAddition addStrat = new StrategieAddition();
		addStrat.setInvoker( this );
		this.operationStrategies.put( "+", addStrat );
		StrategieSoustraction soustracStrat = new StrategieSoustraction();
		soustracStrat.setInvoker( this );
		this.operationStrategies.put( "-", soustracStrat );
		StrategieMultiplication mulStrat = new StrategieMultiplication();
		mulStrat.setInvoker( this );
		this.operationStrategies.put( "*", mulStrat );
		this.operandes = new Operandes();
		Operande operande1 = new Operande();
		operande1.setNumero( 1 );
		Operande operande2 = new Operande();
		operande2.setNumero( 2 );
		this.operandes.getListOp().add( operande1 );
		this.operandes.getListOp().add( operande2 );
		this.nbOperande = 2;
		this.possibleNbOperande = new SelectItem[6];
		for( int i = 0; i < this.possibleNbOperande.length; i++ )
			this.possibleNbOperande[i] = new SelectItem(i + 2);
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
	
	public ArrayList<String> getHistorique() {
		return historique;
	}

	public void setHistorique(ArrayList<String> historique) {
		this.historique = historique;
	}
	
	public String computeOperation(){
		//use strategie pattern to compute operation
		System.out.println( "compute operation with operation = " + operation );
		operationStrategies.get( this.operation + "" ).computeOperation();
		return "OK";
	}
		
	public int getNbOperande() {
		return nbOperande;
	}

	public void setNbOperande(int nbOperande) {
		Operande operande = null; 
		if( nbOperande > this.nbOperande ) for( int i = 0; i < ( nbOperande - this.nbOperande ); i++ ){
			operande = new Operande();
			operande.setNumero( this.nbOperande + i + 1 );
			operandes.getListOp().add( operande );
		}
		else if( nbOperande < this.nbOperande ) for ( int i = 0; i < ( this.nbOperande - nbOperande ); i++ ){
			operandes.getListOp().remove( operandes.getListOp().size() - 1 );
		}
		this.nbOperande = nbOperande;
	}
	
	public char getOperation() {
		return operation;
	}

	public void setOperation( char operation ) {
		this.operation = operation;
	}
	
	public boolean isMontrerHistorique() {
	      return this.montrerHistorique;
	}

	public void validerHistorique() {
	      this.montrerHistorique = !this.montrerHistorique;
	}
	
	public Operandes getOperandes() {
		return operandes;
	}
	
	public SelectItem[] getPossibleNbOperande() {
		return possibleNbOperande;
	}

	public void setPossibleNbOperande( SelectItem[] possibleNbOperande ) {
		this.possibleNbOperande = possibleNbOperande;
	}
	
	private SelectItem[] possibleNbOperande;
	
	private char operation = '+';
	
	private int result;
	
	private int nbOperande;
	
	private Operandes operandes;
	
	private String operationExpression;
	
	private Map<String,IStrategieOperation> operationStrategies;
	
	private ArrayList<String> historique = new ArrayList<String>();
	
	private boolean montrerHistorique = false;

}
