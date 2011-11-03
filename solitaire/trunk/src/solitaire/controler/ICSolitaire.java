package solitaire.controler;

import solitaire.addonapp.gameFile.IReaderGameFile;
import solitaire.controler.impl.CUsine;
import solitaire.view.IPSolitaire;
import solitaire.view.IUpdateString;
/**
 * ICSolitaire
 * @author nicolas
 *
 */
public interface ICSolitaire extends IUpdateString{

	/**
	 * init operation
	 * init a new game
	 */
	public void init();
	
	/**
	 * init operation
	 * init a game with saved game file read by loLoad instance of IReaderGameFile 
	 * @param toLoad
	 */
	public void init( IReaderGameFile toLoad );
	
	/**
	 * getPresentation operation
	 * @return IPSolitaire presentation
	 */
	public IPSolitaire getPresentation();
	
	/**
	 * getUsine operation
	 * @return CUsine control factory
	 */
	public CUsine getCUsine();
	
	/**
	 * actionGagne operation
	 * called each time a cart is put on a color stack to define if the current game is win or not 
	 */
	public void actionGagne();
	
}