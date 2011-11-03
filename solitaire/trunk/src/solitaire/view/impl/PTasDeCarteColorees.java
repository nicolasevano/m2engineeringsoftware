package solitaire.view.impl;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import solitaire.controler.ICTasDeCartes;
import solitaire.view.IPTasDeCarteColorees;

public class PTasDeCarteColorees extends PTasDeCartes implements IPTasDeCarteColorees {
	
	public PTasDeCarteColorees( String nom, ICTasDeCartes control){
		
		super( nom, control );
		label = new JLabel( nom );
		//scrPane = new JScrollPane();
		this.add( label );
		this.setLayout( null );
		this.setDefaultColor( Color.yellow );
		this.setBackground( Color.yellow );
		PCarte.initDimensions();
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCarteColorees#setTitle(java.lang.String)
	 */
	public void setTitle(String title){
		String pic = configuration.getProperties().getProperty("pic.tittle", "Pic");
		String treffle = configuration.getProperties().getProperty("treffle.tittle", "Tréffle");
		this.setPreferredSize( new Dimension( PCarte.largeur + 10, PCarte.hauteur + 20  ) );
		Border line = BorderFactory.createLineBorder( 
				( title.contains(pic) || ( title.contains(treffle) ) )?Color.black:Color.red, 1);
        TitledBorder panelBorder = BorderFactory.createTitledBorder(line, title);
        this.setBorder( panelBorder );
        this.repaint();
	}
	
	@Override
	public void updateString(){
	}
	
	private JLabel label;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
