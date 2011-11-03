package solitaire.addonapp.gameFile;

import solitaire.controler.ICColonne;
import solitaire.controler.ICSabot;
import solitaire.controler.ICTasDeCartes;

/**
 * IReaderGameFile allow to read a saved game file 
 * @author nicolas
 *
 */

public interface IReaderGameFile {

	/**
	 * getPsabot operation
	 * @return ICSabot sabot generated with saved game file read
	 */
	public abstract ICSabot getPsabot();

	/**
	 * getcColonnes operation
	 * @return ICColonne array generated with saved game file read
	 */
	public abstract ICColonne[] getcColonnes();

	/**
	 * getCTasDeCarteColorees operation
	 * @return ICTasDeCartes array genrated with saved game file read
	 */
	public abstract ICTasDeCartes[] getCTasDeCarteColorees();

	/**
	 * isReadableFile operation
	 * @return true if saved game file is completely read
	 */
	public abstract boolean isReadableFile();

}