package solitaire.listener;

import solitaire.controler.ICSolitaire;
import solitaire.controler.impl.CSolitaire;
import solitaire.stringloader.IConfigurationLoader;

public class ConfigurationListener implements IFileChangeListener{
	
	public ConfigurationListener(ICSolitaire main,IConfigurationLoader configuration ){
		this.main = (CSolitaire)main;
		this.configuration = configuration;
	}
	
	@Override
	public void fileChanged( String fileName ) {
		// TODO Auto-generated method stub
		configuration.load();
		main.updateString();
	}

	private IConfigurationLoader configuration;
	private CSolitaire main;
	
}
