package solitaire.view;

import solitaire.controler.ICColonne;
import solitaire.controler.IControlCarteRetournable;
import solitaire.stringloader.IConfigurationLoader;

/**
 * IPolonne
 * @author nicolas
 *
 */
public interface IPColonne extends IUpdateString{

	/**
	 * activerRetournerCarteListener operation
	 * ask to enable listener on hided stack, allow to return a cart 
	 */
	public abstract void activerRetournerCarteListener();

	/**
	 * desactiverRetournerCarteListener operation
	 * ask to disable listener on hided stack, forfid to return a cart
	 */
	public abstract void desactiverRetournerCarteListener();

	/**
	 * setControl operation
	 * @param control ICColonne control
	 */
	public abstract void setControl(ICColonne control);

	/**
	 * getControl operation
	 * @return IControlCarteRetournable control 
	 */
	public abstract IControlCarteRetournable getControl();
	
	/**
	 * set current configuration used to manage string to display
	 * @param configuration
	 */
	public void setConfiguration(IConfigurationLoader configuration);

}