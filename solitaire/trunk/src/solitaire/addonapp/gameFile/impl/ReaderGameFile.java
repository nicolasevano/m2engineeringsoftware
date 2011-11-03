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
import java.util.ArrayList;
import java.util.List;

import solitaire.addonapp.gameFile.IReaderGameFile;
import solitaire.controler.ICColonne;
import solitaire.controler.ICSabot;
import solitaire.controler.ICSolitaire;
import solitaire.controler.ICTasDeCartes;
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
import solitaire.view.impl.PColonne;
import solitaire.view.impl.PTasDeCarteColorees;

public class ReaderGameFile extends GameFile implements IReaderGameFile {
	
	public ReaderGameFile( File toRead, ICSolitaire main ){
		super.main = main;
		InputStream loadStream = null;
		InputStreamReader ipsr = null;
		BufferedReader br = null;
		String line;
        try{
        	loadStream = new FileInputStream( toRead );
    		ipsr = new InputStreamReader( loadStream );
    		br = new BufferedReader( ipsr );	
    		while( ( line=br.readLine() ) != null ){
    			dataList.add( line );
    		}
    		dataSabot.add( dataList.get( 0 ) );
    		dataSabot.add( dataList.get( 1 ) );
    		for(int i = 2; i < dataList.size() - 4; i++){
    			dataColums.add( dataList.get( i ) );
    		}
    		for(int i = dataList.size() - 4; i < dataList.size(); i++){
    			dataColorStacks.add(dataList.get( i ));
    		}
    		initSabot();
    		initColomns();
    		initColorStack();
    		this.isReadableFile = true;
        }catch( Exception e ){
        	e.printStackTrace();
        }
        finally{
        	try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	/* (non-Javadoc)
	 * @see solitaire.addonapp.gameFile.impl.IWriterGameFile#getPsabot()
	 */
	public ICSabot getPsabot() {
		return cSabot;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.addonapp.gameFile.impl.IWriterGameFile#getcColonnes()
	 */
	public ICColonne[] getcColonnes() {
		return cColonnes;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.addonapp.gameFile.impl.IWriterGameFile#getCTasDeCarteColorees()
	 */
	public ICTasDeCartes[] getCTasDeCarteColorees() {
		return cTasDeCarteColorees;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.addonapp.gameFile.impl.IWriterGameFile#isReadableFile()
	 */
	public boolean isReadableFile() {
		return isReadableFile;
	}
	
	private void initSabot(){
		CTasDeCartes tmp = null;
		CTasDeCartes current = null;
		CUsine usine = ( ( CSolitaire ) main ).getCUsine();
		CSabot readSabot = ( CSabot ) usine.newSabot("savedOne", usine);
		tmp = parseALineConfigFile( dataSabot.get( 0 ), usine );
    	tmp = convertVisibleToCache(tmp, usine);
    	current = (CTasDeCartes) readSabot.getCachees();
    	viderTas( current );
    	current.recopier( tmp );
    	tmp = parseALineConfigFile( dataSabot.get( 1 ), usine );
		current = ( CTasDeCartes ) readSabot.getVisibles();
		viderTas( current );
		tmp = convertCacheeToVisible(tmp, usine);
		current.recopier( tmp );
		this.cSabot = readSabot;
	}
	
	private void initColomns(){
		CTasDeCartes tmp = null;
		CTasDeCartesAlterne currentAlt = null;
		CTasDeCartes current = null;
		//System.out.println("init Colums");
		cColonnes = new CColonne[ ( dataColums.size() / 2 ) ];
		//System.out.println("initColums OK load data read");
		CUsine usine = ( ( CSolitaire ) main ).getCUsine();
		for( int i = 0; i < cColonnes.length;i++ ){
			cColonnes[i] = ( ICColonne ) usine.newColonne("savedOne", usine);
		}
		for( int i = 0, z = 0; i < cColonnes.length; i++, z += 2 ){
			tmp = parseALineConfigFile( dataColums.get(z), usine );
			tmp = convertVisibleToCache(tmp, usine);
			current = ( CTasDeCartes )( ( CColonne ) cColonnes[i]).getCachees();
			viderTas( current );
        	current.recopier( tmp );
        	tmp = parseALineConfigFile( dataColums.get(z + 1), usine );
        	currentAlt = ( CTasDeCartesAlterne )( ( CColonne ) cColonnes[i] ).getVisibles();
        	viderTas(currentAlt);
        	currentAlt.recopier( tmp );
		}
	}
	
	private void initColorStack(){
		CTasDeCartes tmp = null;
		CTasDeCarteColorees currentCol = null;
		cTasDeCarteColorees = new CTasDeCarteColorees[4];
		CUsine usine = ( ( CSolitaire ) main ).getCUsine();
		for( int i = 0; i < cTasDeCarteColorees.length;i++ ){
			cTasDeCarteColorees[i] = ( ICTasDeCartes ) usine.newTasDeCartesColorees( "savedOne", 
																					 i + 1, 
																					 usine );
		}
		for( int i = 0; i < 4; i++ ){
			tmp = parseALineConfigFile( dataColorStacks.get(i), usine );
			currentCol = ( CTasDeCarteColorees ) cTasDeCarteColorees[i];
			viderTas(currentCol);
			currentCol.recopier( tmp );
		}
	}
	
	private ICSabot cSabot;
	
	private ICColonne [] cColonnes;
	
	private ICTasDeCartes [] cTasDeCarteColorees;
	
	private boolean isReadableFile = false;
	
	private List< String > dataList = new ArrayList<String>();
	
	private List< String > dataSabot = new ArrayList<String>();
	
	private List< String > dataColums = new ArrayList<String>();
	
	private List< String > dataColorStacks = new ArrayList<String>();
	
}
