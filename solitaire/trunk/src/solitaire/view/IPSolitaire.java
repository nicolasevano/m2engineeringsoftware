package solitaire.view;

import solitaire.view.impl.PColonne;
import solitaire.view.impl.PTasDeCarteColorees;

public interface IPSolitaire extends IUpdateString{
	
	/**
	 * setPcolonnes operation
	 * @param pcolonnes
	 */
	public abstract void setPcolonnes(PColonne[] pcolonnes);

	/**
	 * setPsabot operation
	 * @param psabot IPsabot presentation
	 */
	public abstract void setPsabot(IPSabot psabot);

	/**
	 * setPtasDeCarteColoree operation
	 * @param ptasDeCarteColoree array on color stack cart presentation
	 */
	public abstract void setPtasDeCarteColoree(
			PTasDeCarteColorees[] ptasDeCarteColoree);
	
	/**
	 * getPcolonnes operation
	 * @return IPColonne array column presentation
	 */
	public abstract IPColonne[] getPcolonnes();
	
	/**
	 * getPsabot operation
	 * @return IPSabot presentation
	 */
	public abstract IPSabot getPsabot();
	
	/**
	 * getPtasDeCarteColoree operation
	 * @return IPTasDeCarteColorees array color stack cart presentation
	 */
	public abstract IPTasDeCarteColorees[] getPtasDeCarteColoree();
	
	/**
	 * showWinMessage operation
	 * called to display win message
	 */
	public abstract void showWinMessage();
	
}