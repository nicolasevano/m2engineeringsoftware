package solitaire.view;

import solitaire.controler.IControlCarteRetournable;
/**
 * IViewDoubleTas
 * @author nicolas
 *
 */
public interface IViewDoubleTas {
	/**
	 * getControl operation
	 * get back a control on an element that contain a hide stack on witch it is possible to turn a cart
	 * @return IControlCarteRetournable control
	 */
	public IControlCarteRetournable getControl();
}
