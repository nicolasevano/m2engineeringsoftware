package solitaire.controler.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import solitaire.addonapp.gameFile.IReaderGameFile;
import solitaire.addonapp.gameFile.impl.ReaderGameFile;
import solitaire.addonapp.gameFile.impl.WriterGameFile;
import solitaire.controler.ICSolitaire;
import solitaire.stringloader.IConfigurationLoader;
import solitaire.view.IPColonne;
import solitaire.view.IPSabot;
import solitaire.view.IPSolitaire;
import solitaire.view.IPTasDeCarteColorees;
import solitaire.view.IPUserOption;
import solitaire.view.impl.PUserOption;

public class CUserOption {

	public CUserOption( ICSolitaire main, IConfigurationLoader configuration ){
		this.main = main;
		presentation = new PUserOption( this, configuration );
	}
	
	public void newGameAction(){
		main.init();
	}
	
	public void loadGameAction( File toUseForLoad ){
		IReaderGameFile reader = new ReaderGameFile( toUseForLoad,main );
		if( reader.isReadableFile() );
			main.init( reader );
	}
	
	public void saveGameAction(File toUseForSave){
		new WriterGameFile( toUseForSave,main );
	}
	
	public IPUserOption getPresentation() {
		return presentation;
	}
	
	private IPUserOption presentation;
	private ICSolitaire main;
	
}
