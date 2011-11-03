package solitaire.view.impl;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import solitaire.stringloader.IConfigurationLoader;
import solitaire.view.IPColonne;
import solitaire.view.IPSabot;
import solitaire.view.IPSolitaire;
import solitaire.view.IPTasDeCarteColorees;
import solitaire.view.IPUserOption;


public class PSolitaire extends JFrame implements IPSolitaire {
	
	public PSolitaire(IConfigurationLoader configuration){
		Properties properties = configuration.getProperties();
		super.setTitle(properties.getProperty( "tittle", "solitaire" ) );
		winMsg = properties.getProperty( "winmsg", 
				"Vous avez Gagner! Vous pouvez relancer une nouvelle partie ou en charger une a partir du menu." );
		winMsgTittle = "partie terminé";
		this.configuration = configuration;
		this.addWindowListener( new Finisher() );
		this.getContentPane().setLayout( new BorderLayout() );
		this.setPreferredSize( new Dimension( 1024, 800 ) );
		this.setSize( new Dimension( 1024, 800 ) );
		this.setVisible(true);
		this.pack();
	}
	
	class Finisher extends WindowAdapter {

		public void windowClosing(WindowEvent e){
			System.exit( 0 );
		}
		
	}
	
	public void initialiser(){
		buildTasColorees();
		buildColonnes();
		//this.repaint();
	}
	
	private void buildTasColorees(){
		if(tasColorees != null)this.getContentPane().remove( tasColorees );
		tasColorees = new JPanel();
		tasColorees.setLayout( new GridLayout( 1,4 ) );
		this.getContentPane().add( tasColorees, BorderLayout.SOUTH );
		this.getContentPane().repaint();
		this.repaint();
	}
	
	private void buildColonnes(){
		if(colonnesPanel != null)this.getContentPane().remove( colonnesPanel );
		colonnesPanel = new JPanel();
		colonnesPanel.setLayout( new FlowLayout() );
		this.getContentPane().add(colonnesPanel, BorderLayout.CENTER );
		this.getContentPane().repaint();
		this.repaint();
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSolitaire#setPcolonnes(solitaire.view.PColonne[])
	 */
	public void setPcolonnes(PColonne []pcolonnes) {
		this.pcolonnes = pcolonnes;
		for( int i = 0; i < this.pcolonnes.length; i++ ){
			this.colonnesPanel.add( pcolonnes[i] );
		}
		this.getContentPane().repaint();
		this.repaint();
	}
	
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSolitaire#setPsabot(solitaire.view.IPSabot)
	 */
	public void setPsabot(IPSabot psabot) {
		if(this.psabot != null){
			this.getContentPane().remove( ( PSabot ) this.psabot);
		}
		this.psabot = psabot;
		this.getContentPane().add( ( PSabot ) psabot, BorderLayout.NORTH );
		this.getContentPane().repaint();
		this.repaint();
	}
	
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSolitaire#setPtasDeCarteColoree(solitaire.view.PTasDeCarteColorees[])
	 */
	public void setPtasDeCarteColoree( PTasDeCarteColorees []ptasDeCarteColoree ) {
		this.ptasDeCarteColoree = ptasDeCarteColoree;
		this.tasColorees.removeAll();
		for( int i = 0; i < this.ptasDeCarteColoree.length; i++ ){
			this.tasColorees.add( ptasDeCarteColoree[i] );
		}
		this.repaint();
	}
	
	public IPUserOption getUserOption() {
		return userOption;
	}

	public void setUserOption(IPUserOption userOption) {
		if( this.userOption != null ) this.getContentPane().remove( ( PUserOption ) this.userOption );
		this.userOption = userOption;
		this.setJMenuBar( (PUserOption) userOption );
		this.repaint();
	}
	
	@Override
	public IPColonne[] getPcolonnes() {
		return pcolonnes;
	}
	
	@Override
	public IPSabot getPsabot() {
		return psabot;
	}
	
	@Override
	public IPTasDeCarteColorees[] getPtasDeCarteColoree() {
		return ptasDeCarteColoree;
	}
	
	public void showWinMessage(){
		int result = JOptionPane.showConfirmDialog( ( Component ) null, 
				"Vous avez Gagner!" + 
				" Vous pouvez relancer une nouvelle partie ou en charger une a partir du menu.",
				"partie terminé", JOptionPane.DEFAULT_OPTION);
	}
	
	@Override
	public void updateString() {
		// TODO Auto-generated method stub
		Properties properties = configuration.getProperties();
		super.setTitle(properties.getProperty( "tittle", "solitaire" ) );
		winMsg = properties.getProperty( "winmsg", 
				"Vous avez Gagner! Vous pouvez relancer une nouvelle partie ou en charger une a partir du menu." );
		winMsgTittle = "partie terminé";
	}
	
	private String winMsg;
	private String winMsgTittle;
	
	private IPColonne [] pcolonnes;

	private IPSabot psabot;

	private IPTasDeCarteColorees [] ptasDeCarteColoree;

	private JPanel tasColorees;
	private JPanel colonnesPanel;
	private IPUserOption userOption;
	private IConfigurationLoader configuration; 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
