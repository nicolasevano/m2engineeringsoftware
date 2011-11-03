package solitaire.controler;

import solitaire.view.IPSabot;

/**
 * 
 * @author nicolas
 *
 */

public interface ICSabot extends IControlCarteRetournable{
	
	/**
	 * setReserve operation
	 * allow to setReserve operation
	 */
	public void setReserve();

	/**
	 * getPresentation operation
	 * @return IPsabot presentation
	 */
	public IPSabot getPresentation();

	/**
	 * c2p_debutDnD operation called a the begin of dra and drop
	 * @param cc ICCarte cart control
	 */
	public void c2p_debutDnD(ICCarte cc);
	
	/**
	 * getCachees operation
	 * @return ICTasDeCartes hided stack
	 */
	public ICTasDeCartes getCachees();
	
	/**
	 * setCachees operation
	 * @param cachees ICTasDeCartes override hided stack
	 */
	public void setCachees( ICTasDeCartes cachees );
	
	/**
	 * setVisible operation
	 * @param visibles ICTasDeCartes override visible stack
	 */
	public void setVisibles( ICTasDeCartes visibles );
	
	/**
	 * getVisibles operation
	 * @return ICTasDeCartes visible stack
	 */
	public ICTasDeCartes getVisibles();
}