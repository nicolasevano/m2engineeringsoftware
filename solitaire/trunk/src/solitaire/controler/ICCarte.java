package solitaire.controler;

import solitaire.view.impl.PCarte;

public interface ICCarte {

	/**
	 * setFaceVisible operation
	 * @param boolean b when is true set cart visible false set card hided. 
	 */
	public abstract void setFaceVisible(boolean b);

	/**
	 * getPresentation operation
	 * @return PCarte cart presentation
	 */
	public abstract PCarte getPresentation();

	/**
	 * setPresentation operation
	 * @param presentation PCarte cart presentation
	 */
	public abstract void setPresentation(PCarte presentation);

	/**
	 * operation finDnD
	 * @param cc if something special to do at end of darg and drop on cart
	 */
	public abstract void finDnD(ICCarte cc);

}