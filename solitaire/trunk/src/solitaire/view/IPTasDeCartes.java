package solitaire.view;

import java.awt.Color;
import java.awt.datatransfer.Transferable;

import solitaire.controler.ICCarte;
import solitaire.controler.ICTasDeCartes;
import solitaire.controler.impl.CTasDeCartes;
import solitaire.view.impl.PCarte;

/**
 * IPTasDeCartes
 * @author nicolas
 *
 */
public interface IPTasDeCartes extends Transferable, IUpdateString{
	/**
	 * setDxDy operation
	 * set delta in x axe and y axe between each displayed cart of the stack
	 * @param dx
	 * @param dy
	 */
	public abstract void setDxDy(int dx, int dy);

	/**
	 * empiler operation
	 * put a cart on the stack
	 * @param c PCarte to put on the stack
	 */
	public abstract void empiler(PCarte c);

	/**
	 * depiler operation
	 * @param c PCarte to remove of the current presentation
	 * @throws Exception
	 */
	public abstract void depiler(PCarte c) throws Exception;

	/**
	 * getControl operation
	 * @return ICTasDeCartes control stack
	 */
	public abstract ICTasDeCartes getControl();

	/**
	 * setControl operation
	 * @param ICTasDeCartes control stack
	 */
	public abstract void setControl(ICTasDeCartes control);

	/**
	 * c2p_debutDnDKO operation
	 * called when begin drag and drop fail
	 */
	public abstract void c2p_debutDnDKO();

	/**
	 * c2p_debutDnDOK operation
	 * called when begin drag and drop success
	 * @param cc ICCarte control cart in drag
	 */
	public abstract void c2p_debutDnDOK(ICCarte cc);
	
	/**
	 * c2p_debutDnDOK operation
	 * called when begin drag and drop success
	 * @param tc ICTasDeCartes control stack in drag
	 */
	public abstract void c2p_debutDnDOK(ICTasDeCartes tc);

	/**
	 * c2p_finDnDInvalide operation
	 * called when end drag and drop fail
	 */
	public abstract void c2p_finDnDInvalide();

	/**
	 * c2p_finDnDValide operation
	 * called wjen begin drag and drop success
	 */
	public abstract void c2p_finDnDValide();

	/**
	 * getDefaultColor operation
	 * get default background color
	 * @return Color default back ground color of stack presentation
	 */
	public abstract Color getDefaultColor();

	/**
	 * setDefaultColor operation
	 * set default background color
	 * @param defaultColor Color background color to apply on stack presentation
	 */
	public abstract void setDefaultColor(Color defaultColor);

	/**
	 * isOrigine operation
	 * @return true if the current cart or stack in drag come from this stack
	 */
	public abstract boolean isOrigine();
	
	/**
	 * setOrigine operation
	 * @param origine boolean put it true if current cart or stack that will coming in drag is 
	 * from this stack
	 */
	public abstract void setOrigine(boolean origine);

}