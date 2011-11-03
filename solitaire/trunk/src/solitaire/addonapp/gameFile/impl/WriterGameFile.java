package solitaire.addonapp.gameFile.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import solitaire.addonapp.gameFile.IWriterGameFile;
import solitaire.controler.ICSolitaire;
import solitaire.controler.impl.CColonne;
import solitaire.controler.impl.CSabot;
import solitaire.controler.impl.CSolitaire;
import solitaire.controler.impl.CTasDeCarteColorees;
import solitaire.controler.impl.CTasDeCartes;
import solitaire.controler.impl.CTasDeCartesAlterne;
import solitaire.controler.impl.CUsine;
import solitaire.view.IPColonne;
import solitaire.view.IPSabot;
import solitaire.view.IPSolitaire;
import solitaire.view.IPTasDeCarteColorees;

public class WriterGameFile extends GameFile implements IWriterGameFile{
	
	public WriterGameFile(File toWrite, ICSolitaire main ){
		super.main = main;
		CUsine usine = ( ( CSolitaire ) main ).getCUsine();
		CTasDeCartes tmpTas = (CTasDeCartes) usine.newTasDeCartes("recop", usine);
		IPSolitaire currentGame = main.getPresentation();
		IPSabot psabot = currentGame.getPsabot();
		IPColonne [] pcolonnes = currentGame.getPcolonnes();
		IPTasDeCarteColorees [] pTasDeCarteColorees = currentGame.getPtasDeCarteColoree();
		PrintStream saveStream = null;
		try {
			saveStream = new PrintStream( new FileOutputStream( toWrite ) );
			//save main set
			tmpTas = convertCacheeToVisible( ( CTasDeCartes )( ( CSabot )psabot.getControl() ).getCachees(),
											 usine);
			saveStream.println( tmpTas.toString() );
			tmpTas = copieTas( ( CTasDeCartes ) ( ( CSabot ) psabot.getControl() ).getVisibles(), usine);
			saveStream.println( tmpTas.toString() );
			//save colmuns
			for( int i = 0; i < pcolonnes.length;i++ ){
				tmpTas = convertCacheeToVisible(
						( CTasDeCartes )( ( CColonne ) pcolonnes[i].getControl() ).getCachees(),
						usine);
				saveStream.println( tmpTas.toString() );
				tmpTas = copieTas( 
						( CTasDeCartesAlterne )( ( CColonne ) pcolonnes[i].getControl() ).getVisibles(),
						usine);
				saveStream.println( tmpTas.toString() );
			}
			//save color stack
			for( int i = 0; i < pTasDeCarteColorees.length;i++ ){
				tmpTas = copieTas(
						( CTasDeCarteColorees ) pTasDeCarteColorees[i].getControl(),
						usine);
				saveStream.println( tmpTas.toString() );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally { saveStream.close();	}
	}
}
