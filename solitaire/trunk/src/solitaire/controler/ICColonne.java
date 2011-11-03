package solitaire.controler;

import solitaire.view.impl.PColonne;
/**
 * ICColonne interface
 * @author nicolas
 *
 */
public interface ICColonne {

	/**
	 * retournerCarte operation
	 * return a cart
	 */
	public abstract void retournerCarte();

	/**
	 * activeRetourneCarte
	 * allow to return a cart
	 */
	public abstract void activeRetourneCarte();

	/**
	 * getPresentation operation
	 * @return PColonne presentation of column
	 */
	public abstract PColonne getPresentation();
	
	/**
	 * getCachees operation
	 * @return return hided stack of column
	 */
	public ICTasDeCartes getCachees();
	
	/**
	 * setCachees operation
	 * @param ICTasDeCartes cachees override current hided stack  
	 */
	public void setCachees( ICTasDeCartes cachees );
	
	/**
	 * setVisibles operation
	 * @param ICTasDeCartes visibles override current visible stack on a column 
	 */
	public void setVisibles( ICTasDeCartes visibles );
	
	/**
	 * getVisibles operation
	 * @return ICTasDeCartes current visible stack
	 */
	public ICTasDeCartes getVisibles();
	
}