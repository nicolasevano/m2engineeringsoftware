package solitaire.view.impl;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import solitaire.controler.impl.CUserOption;
import solitaire.stringloader.IConfigurationLoader;
import solitaire.view.IPUserOption;

public class PUserOption extends JMenuBar implements IPUserOption {
	
	public PUserOption(CUserOption control,IConfigurationLoader configuration){
		
		this.control = control;
		this.configuration = configuration;
		Properties properties = configuration.getProperties();
		userAction = new JMenu( properties.getProperty( "menu.tittle", "Option de jeu" ) );
		userAction.setMnemonic( KeyEvent.VK_J );
		userAction.getAccessibleContext().setAccessibleDescription(
				properties.getProperty("menu.description",
						               "menu de jeu permet de lancer, sauvegarder ou charger une partie")
		);
		this.add( userAction );
		
		newGame = new JMenuItem(properties.getProperty("menu.option.newgame","Nouvelle partie"),
                KeyEvent.VK_N);
		newGame.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
		newGame.getAccessibleContext().setAccessibleDescription(
				properties.getProperty("menu.option.newgame.description","Crée une nouvelle partie"));
		newGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {	doNewGame();}
		});
		userAction.add( newGame );

		saveGame = new JMenuItem( properties.getProperty("menu.option.savegame","Sauvegarder la partie") );
		saveGame.setMnemonic(KeyEvent.VK_S);
		saveGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { doSaveGame(); }
		});
		userAction.add( saveGame );

		loadGame = new JMenuItem(properties.getProperty("menu.option.loadgame","Charger une partie"));
		loadGame.setMnemonic(KeyEvent.VK_C);
		loadGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { doLoadGame(); }
		});
		userAction.add( loadGame );
		fc.addChoosableFileFilter( new SolitaireFileFilter() );
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void updateString(){
		Properties properties = configuration.getProperties();
		userAction.setText( properties.getProperty( "menu.tittle", "Option de jeu" ) );
		userAction.getAccessibleContext().setAccessibleDescription(
				properties.getProperty("menu.description",
						               "menu de jeu permet de lancer, sauvegarder ou charger une partie"));
		newGame.setText( properties.getProperty("menu.option.newgame","Nouvelle partie") );
		newGame.getAccessibleContext().setAccessibleDescription(
				properties.getProperty("menu.option.newgame.description","Crée une nouvelle partie"));
		saveGame.setText( properties.getProperty("menu.option.savegame","Sauvegarder la partie") );
		loadGame.setText(properties.getProperty("menu.option.loadgame","Charger une partie"));
		userAction.repaint();
	}
	
	class SolitaireFileFilter extends FileFilter{
		
		public boolean accept(File f) {
			String extension = null;
			if (f.isDirectory()) {
				return true;
			}
			try{
				extension = f.getName().substring( f.getName().lastIndexOf("."), 
												   f.getName().length() );
			} catch(Exception e){}
			if (extension != null) {
				if (extension.equals( extentionAllowed ) ) {
	                	return true;
				} else {
					return false;
				}
			}

			return false;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}
		private static final String extentionAllowed = ".gsol";
	}
	
	private void doNewGame(){
		int result = JOptionPane.showConfirmDialog( ( Component ) null, 
													configuration.getProperties().getProperty("menu.newgame.confirmmsg",
													"voulez vous réélement démarrer une nouvelle partie. La partie courante sera perdu"
													),
													configuration.getProperties().getProperty("menu.newgame.confirmmsg.tittle",
																							  "Nouvelle partie"), 
													JOptionPane.OK_CANCEL_OPTION);
		if( result == JOptionPane.OK_OPTION ){
			control.newGameAction();
		}
	}
	
	private void doSaveGame(){
		
		int returnVal = fc.showOpenDialog( this );
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
        	
        	fToUse = fc.getSelectedFile();
        	control.saveGameAction( fToUse );
        	
        }
        
	}
	
	private void doLoadGame(){
		int returnVal = fc.showOpenDialog( this );
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
        	
        	fToUse = fc.getSelectedFile();
        	control.loadGameAction( fToUse );
        	
        }
	}
	
	private IConfigurationLoader configuration;
	private JMenu userAction;
	private JMenuItem newGame;
	private JMenuItem saveGame;
	private JMenuItem loadGame;
	private CUserOption control;
	private final JFileChooser fc = new JFileChooser();
	private File fToUse;
}
