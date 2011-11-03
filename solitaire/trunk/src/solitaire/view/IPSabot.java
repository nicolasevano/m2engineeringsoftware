package solitaire.view;

import solitaire.controler.impl.CSabot;
import solitaire.stringloader.IConfigurationLoader;
import solitaire.view.impl.PCarte;
/**
 * IPSabot
 * @author nicolas
 *
 */
public interface IPSabot extends IViewDoubleTas,IUpdateString {

	/**
	 * activerRetournerTasListener operation
	 * allow to return visible stack on hided stack
	 */
	public abstract void activerRetournerTasListener();

	/**
	 * desactiverRetournerTasListener operation
	 * forbid to return visible stack on hided stack
	 */
	public abstract void desactiverRetournerTasListener();

	/**
	 * activerRetournerCarteListener operation
	 * enable listener that allow to return a cart from hided stack to visible one 
	 */
	public abstract void activerRetournerCarteListener();

	/**
	 * desactiverRetournerCarteListener operation
	 * disable listener that allow to return a cart from hided stack to visible one
	 */
	public abstract void desactiverRetournerCarteListener();

	/**
	 * c2p_debutDnDKO operation
	 * called if begin drag and drop fail
	 */
	public abstract void c2p_debutDnDKO();
	
	/**
	 * c2p_debutDnD operation
	 * called if begin drag and drop success 
	 * @param pc cart control in drag
	 */
	public abstract void c2p_debutDnD(PCarte pc);

	/**
	 * setControl operation
	 * @param csabot CSabot control
	 */
	public abstract void setControl(CSabot csabot);
	
	/**
	 * setConfiguration operation
	 * @param configuration on configuration file loader that provide access to each String displayed 
	 * on application
	 */
	public void setConfiguration(IConfigurationLoader configuration);

}