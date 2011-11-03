package solitaire.view;

import java.awt.Graphics;
import java.awt.datatransfer.Transferable;

import javax.swing.ImageIcon;

import solitaire.controler.impl.CCarte;

/**
 * IPCarte
 * @author nicolas
 *
 */
public interface IPCarte extends Transferable{

	/**
	 * setFaceVisible operation
	 * @param faceVisible if true set cart visible otherwise hide it
	 */
	public abstract void setFaceVisible(boolean faceVisible);

	/**
	 * paint operation
	 * @param g
	 */
	public abstract void paint(Graphics g);

	/**
	 * getIcon operation
	 * @return ImageIcon of the cart
	 */
	public abstract ImageIcon getIcone();

	/**
	 * getControl operation
	 * @return CCarte control cart
	 */
	public abstract CCarte getControl();

}