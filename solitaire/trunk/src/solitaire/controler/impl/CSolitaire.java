package solitaire.controler.impl;


import java.io.FileNotFoundException;

import solitaire.addonapp.gameFile.IReaderGameFile;
import solitaire.application.Solitaire;
import solitaire.controler.ICColonne;
import solitaire.controler.ICSabot;
import solitaire.controler.ICSolitaire;
import solitaire.listener.ConfigurationListener;
import solitaire.listener.IFileChangeListener;
import solitaire.stringloader.ConfigurationLoader;
import solitaire.stringloader.IConfigurationLoader;
import solitaire.view.IPColonne;
import solitaire.view.IPTasDeCarteColorees;
import solitaire.view.impl.PCarte;
import solitaire.view.impl.PColonne;
import solitaire.view.impl.PSolitaire;
import solitaire.view.impl.PTasDeCarteColorees;

public class CSolitaire extends Solitaire implements ICSolitaire{
	
	public CSolitaire(String nom, CUsine u){
		super( nom, u );
		cusine = u;
		configuration = new ConfigurationLoader();
		configuration.load();
		IFileChangeListener configurationListener = new ConfigurationListener((ICSolitaire)this, configuration);
		try {
			configuration.addFileChangeListener(configurationListener, IConfigurationLoader.configurationFileName, 5000);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TasColoreesName = new String[] { "Careau","Pic", "Coeur", "Tréffle" };
		TasColoreesName = new String[4];
		TasColoreesName[0] = configuration.getProperties().getProperty("carreau.tittle", "Careau");
		TasColoreesName[1] = configuration.getProperties().getProperty("pic.tittle","Pic");
		TasColoreesName[2] = configuration.getProperties().getProperty("coeur.tittle","Coeur");
		TasColoreesName[3] = configuration.getProperties().getProperty("treffle.tittle","Tréffle");
		cuserOption = new CUserOption( this, configuration );
		presentation = new PSolitaire( configuration );
		init();
	}
	
	public void init(){
		presentation.initialiser();
		super.initialiser();
		PColonne [] pcolonnes = new PColonne[super.pilesAlternees.length];
		PTasDeCarteColorees [] tasColorees = new PTasDeCarteColorees[super.pilesColorees.length];
		for( int i = 0; i < super.pilesAlternees.length; i++ ){
			pcolonnes[i] = ( ( ICColonne ) super.pilesAlternees[i] ).getPresentation();
			pcolonnes[i].setConfiguration( configuration );
			pcolonnes[i].updateString();
		}
		for( int i = 0; i < super.pilesColorees.length; i++ ){
			tasColorees[i] = ( ( CTasDeCarteColorees ) super.pilesColorees[i] ).getPresentation();
			tasColorees[i].setConfiguration( configuration );
			tasColorees[i].setTitle(TasColoreesName[i]);
			((CTasDeCarteColorees) tasColorees[i].getControl()).setMain(this);
		}
		( ( ICSabot ) super.sabot).getPresentation().setConfiguration(configuration);
		( ( ICSabot ) super.sabot).getPresentation().updateString();
		presentation.setPsabot( ( ( ICSabot ) super.sabot).getPresentation() );
		
		presentation.setPcolonnes( pcolonnes );
		
		presentation.setPtasDeCarteColoree( tasColorees );
		
		presentation.setUserOption(cuserOption.getPresentation());
		
		presentation.pack();
	}
	
	public void init( IReaderGameFile initialiser ){
		presentation.initialiser();
		//super.initialiser();
		PColonne [] pcolonnes = new PColonne[initialiser.getcColonnes().length];
		PTasDeCarteColorees [] tasColorees = 
			new PTasDeCarteColorees[initialiser.getCTasDeCarteColorees().length];
		for( int i = 0; i < initialiser.getcColonnes().length; i++ ){
			pcolonnes[i] = ( ( CColonne ) initialiser.getcColonnes()[i] ).getPresentation();
			pcolonnes[i].setConfiguration( configuration );
			//bug Fix no so clean however looks like working
			if( ( ( CTasDeCartesAlterne )( ( CColonne ) pcolonnes[i].getControl() ).getVisibles() ).isVide() ){
				if(!((CTasDeCartes)( ( CColonne ) pcolonnes[i].getControl() ).getCachees()).isVide() ){
					pcolonnes[i].activerRetournerCarteListener();
				}
			}
			pcolonnes[i].updateString();
		}
		for( int i = 0; i < initialiser.getCTasDeCarteColorees().length; i++ ){
			tasColorees[i] = ( ( CTasDeCarteColorees ) initialiser.getCTasDeCarteColorees()[i] ).
								getPresentation();
			((CTasDeCarteColorees)((PTasDeCarteColorees)tasColorees[i]).getControl()).setMain(this);
			tasColorees[i].setConfiguration( configuration );
			tasColorees[i].setTitle(TasColoreesName[i]);
			((CTasDeCarteColorees) tasColorees[i].getControl()).setMain(this);
		}
		( initialiser.getPsabot() ).getPresentation().setConfiguration(configuration);
		( initialiser.getPsabot() ).getPresentation().updateString();
		presentation.setPsabot( ( ( ICSabot ) initialiser.getPsabot() ).getPresentation() );
		
		presentation.setPcolonnes( pcolonnes );
		
		presentation.setPtasDeCarteColoree( tasColorees );
		
		presentation.setUserOption( cuserOption.getPresentation() );
		
		presentation.pack();
	}
	
	@Override
	public void actionGagne(){
		boolean gagne = true;
		IPTasDeCarteColorees [] pTasColorees = presentation.getPtasDeCarteColoree();
		for(int i = 0; i < pTasColorees.length; i++ ){
			CTasDeCarteColorees cTasColorees = (CTasDeCarteColorees) pTasColorees[i].getControl();
			if(!cTasColorees.isRempli()) gagne = false;
		}
		if(gagne){
			this.getPresentation().showWinMessage();
		}
	}
	
	public static void main(String ... args){
		
		PCarte.initDimensions();
		CUsine cusine = new CUsine();
		cusine.newSolitaire("toto", cusine)/*.run()*/;
		
	}
	
	@Override
	public CUsine getCUsine() {
		return cusine;
	}
	
	@Override
	public PSolitaire getPresentation() {
		return presentation;
	}
	
	public void updateString(){
		TasColoreesName[0] = configuration.getProperties().getProperty("carreau.tittle", "Careau");
		TasColoreesName[1] = configuration.getProperties().getProperty("pic.tittle", "Pic");
		TasColoreesName[2] = configuration.getProperties().getProperty("coeur.tittle", "Coeur");
		TasColoreesName[3] = configuration.getProperties().getProperty("treffle.tittle", "Tréffle");
		presentation.updateString();
		presentation.getPsabot().updateString();
		IPColonne [] pColonnes = presentation.getPcolonnes();
		for(int i = 0; i < pColonnes.length; i++){
			pColonnes[i].updateString();
		}
		IPTasDeCarteColorees [] pTasColorees = presentation.getPtasDeCarteColoree();
		for(int i = 0; i < pTasColorees.length; i++){
			pTasColorees[i].setTitle( TasColoreesName[i] );
		}
		cuserOption.getPresentation().updateString();
		presentation.pack();
	}
	
	private IConfigurationLoader configuration;
	private PSolitaire presentation;
	private CUserOption cuserOption;
	private CUsine cusine;
	public static String[] TasColoreesName;
}
