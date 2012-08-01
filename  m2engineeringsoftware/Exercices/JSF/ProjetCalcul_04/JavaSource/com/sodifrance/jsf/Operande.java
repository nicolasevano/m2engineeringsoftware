package com.sodifrance.jsf;

public class Operande {
	
	public int getValeur() {
		return valeur;
	}

	public void setValeur( int valeur ) {
		this.valeur = valeur;
	}
	
//	public Operande getNext() {
//		return next;
//	}
//
//	public void setNext( Operande next ) {
//		this.next = next;
//	}
//	
//	public void addOperande( Operande toAdd ){
//		if( next == null ) next = toAdd;
//		else next.addOperande( toAdd );
//	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
//	public void removeOperande(){
//		
//		Operande child = getBeforeLastOne( null );
//		child.setNext( null );
//		
//	}
//	
//	public Operande getBeforeLastOne( Operande begin ){
//		
//		Operande result = null;
//		if( begin == null ) begin = this;
//		if( begin.getNext().getNext() != null )result = getBeforeLastOne( begin.getNext() );
//		else result = begin;
//		return result;
//		
//	}
	
	private int valeur;
	
	private int numero;

//	private Operande next;
	
}