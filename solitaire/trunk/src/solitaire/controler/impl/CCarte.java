package solitaire.controler.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import solitaire.application.Carte;
import solitaire.controler.ICCarte;
import solitaire.view.impl.PCarte;


public class CCarte extends Carte implements ICCarte{
	
	public CCarte( int v,int c ){
		super( Math.min( 13, Math.max( 1, v ) ), Math.min( 4, Math.max( 1,c ) ) );
		presentation = new PCarte( Carte.valeurs[ getValeur() - 1 ] + Carte.couleurs[ getCouleur() - 1 ], this );
		presentation.setFaceVisible( isFaceVisible() );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICCarte#setFaceVisible(boolean)
	 */
	public void setFaceVisible( boolean b ){
		super.setFaceVisible( b );
		presentation.setFaceVisible( isFaceVisible() );
	}
	
	public static void main( String ... args ){
		System.out.println( "user:" + System.getProperty( "user.dir" ) );
		PCarte.initDimensions ();
		JFrame test = new JFrame();
		test.getContentPane().setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		test.getContentPane().setBackground( new Color( 143, 143, 195                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ) ); // violet pâle
		//test.getContentPane().setVisible( true );
		test.setSize( new Dimension( 800, 600 ) );
		test.setPreferredSize( new Dimension( 800, 600 ) );
		test.addWindowListener( ( WindowListener ) new WindowAdapter() {
			 
			@Override
			public void windowClosing(WindowEvent e){
				System.exit( 0 );
			}
			
		});
		
		for( int i = 1; i < 5; i++ ){
			for( int j = 1; j < 14; j++ ){
				
				System.out.println(" i = " + i + ", j = " + j);
				ICCarte currentCarte = new CCarte( j,i );
				currentCarte.setFaceVisible( true );
				test.getContentPane().add( currentCarte.getPresentation() );
				System.out.println( "add CCarte: "+ j + "," + i  );
				
			}
		}
		test.setVisible(true);
		test.pack();
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICCarte#getPresentation()
	 */
	public PCarte getPresentation() {
		return presentation;
	}

	/* (non-Javadoc)
	 * @see solitaire.controler.ICCarte#setPresentation(solitaire.view.PCarte)
	 */
	public void setPresentation(PCarte presentation) {
		this.presentation = presentation;
	}
	
    /* (non-Javadoc)
	 * @see solitaire.controler.ICCarte#finDnD(solitaire.controler.ICCarte)
	 */
    public void finDnD (ICCarte cc){
    	
    }
    
	private PCarte presentation;

}
