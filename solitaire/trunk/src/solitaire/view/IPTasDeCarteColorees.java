package solitaire.view;

import solitaire.stringloader.IConfigurationLoader;


public interface IPTasDeCarteColorees extends IPTasDeCartes,IUpdateString{

	/**
	 * setTitle operation
	 * @param title String on each color stack presentation
	 */
	public abstract void setTitle(String title);
	
	/**
	 * setConfiguration operation
	 * @param configuration ConfigurationLoader allow access to each displayed String of application
	 */
	public void setConfiguration(IConfigurationLoader configuration);

}