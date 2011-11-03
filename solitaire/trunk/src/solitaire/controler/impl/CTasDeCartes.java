package solitaire.controler.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.view.impl.PCarte;
import solitaire.view.impl.PTasDeCartes;
import solitaire.controler.ICCarte;
import solitaire.controler.ICTasDeCartes;

public class CTasDeCartes extends TasDeCartes implements ICTasDeCartes {

	
	public CTasDeCartes(String nom, Usine u) {
		super( nom, u );
		// TODO Auto-generated constructor stub
		presentation = new PTasDeCartes( nom , this);
		cu = ( CUsine ) u;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#empiler(solitaire.application.Carte)
	 */
	public void empiler(Carte c){
		//this.recopier(solitaire.application.Tas tas);
		if( isEmpilable( c ) ){
			super.empiler( c );
			try {
				if( c == getSommet() ){
					presentation.empiler( ( ( ICCarte) c).getPresentation() );
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#depiler()
	 */
	public void depiler(){
		ICCarte c;
		try {
			c = ( ICCarte ) getSommet();
			super.depiler();
			presentation.depiler( ( ( ICCarte ) c ).getPresentation() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public static void main (String args []) {
	      PCarte.initDimensions () ;
	      JFrame f = new JFrame ( "Test CTasDeCartes" ) ;
	      ICCarte firstCarte = new CCarte ( 5,3 );
	      //firstCarte.setFaceVisible( false );
	      ICCarte secondCarte = new CCarte ( 10,2 );
	      //secondCarte.setFaceVisible( true );
	      CTasDeCartes tasDeCarte = new CTasDeCartes( "tas de carte de test", new Usine() );
	      tasDeCarte.getPresentation().setDxDy( 10, 10 );
	      tasDeCarte.getPresentation().setBackground( Color.CYAN );
	      f.getContentPane().add( tasDeCarte.getPresentation() );
	      //tasDeCarte.empiler( firstCarte );
	      //tasDeCarte.empiler( secondCarte );
	      for( int i = 1; i < 5; i++ ){
				for( int j = 1; j < 14; j++ ){
					
					//System.out.println(" i = " + i + ", j = " + j);
					CCarte currentCarte = new CCarte( j,i );
					currentCarte.setFaceVisible( true );
					tasDeCarte.empiler( currentCarte );
					//System.out.println( "add CCarte: "+ j + "," + i  );
					
				}
	      }
	      f.setSize( new Dimension( 800, 600 ) );
	      f.setPreferredSize( new Dimension( 800, 600 ) );
	      f.addWindowListener ( new WindowAdapter () {
		    public void windowClosing ( WindowEvent e ) {
		       System.exit ( 0 ) ;
		    }
		 }) ;
	      f.pack () ;
	      f.setVisible (true) ;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#getPresentation()
	 */
	public PTasDeCartes getPresentation() {
		return presentation;
	}

	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#setPresentation(solitaire.view.PTasDeCartes)
	 */
	public void setPresentation(PTasDeCartes presentation) {
		this.presentation = presentation;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#debutDnDDrag(solitaire.controler.CCarte)
	 */
	public void debutDnDDrag( ICCarte selectedControl ){
		if( selectedControl != null ){
			try {
				if( ( !isVide() ) && ( selectedControl == getSommet() ) ){
					this.depiler();
					presentation.c2p_debutDnDOK( selectedControl );
				} else {
					nbSelection++;
					presentation.c2p_debutDnDKO();
				}
			} catch (Exception e) {
			}
		} else {
			nbSelection++;
			presentation.c2p_debutDnDKO();
		}
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#debutDnDDragTas(solitaire.controler.CCarte)
	 */
	@Override
	public ICTasDeCartes debutDnDDragTas( ICCarte selectedControl ){
		
		nbSelection++;
		presentation.c2p_debutDnDKO();
		return null;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#sortieDnDDrop(solitaire.controler.CCarte)
	 */
	public void sortieDnDDrop( CCarte cc ){
		try {
			if( isValideDrop && ( this.isVide() || this.isEmpilable( cc ) ) ){
				this.empiler( cc );
				presentation.c2p_finDnDValide();
			} else {
				presentation.c2p_finDnDInvalide();
			}
		} catch (Exception e) {
			presentation.c2p_finDnDInvalide();
		}
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#sortieDnDDrop(solitaire.controler.CTasDeCartes)
	 */
	public void sortieDnDDrop( CTasDeCartes tc ){
		presentation.c2p_finDnDInvalide();
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#finDnDDrag(solitaire.controler.CCarte, solitaire.controler.CTasDeCartes, boolean)
	 */
	@Override
	public void finDnDDrag( CCarte cc,CTasDeCartes tc, boolean success){
		CCarte current = null;
		if(!success){
			if(tc == null){
				empiler( cc );
			} else {
				do{
					try {
						current = ( CCarte ) tc.getSommet();
					} catch (Exception e) {}
					tc.depiler();
					this.empiler( current );
				}while(!tc.isVide());
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#finDnDDrag(solitaire.controler.CTasDeCartes, boolean)
	 */
	public void finDnDDrag( CTasDeCartes tc, boolean success){
		CCarte current = null;
		if( !success ){
			do{
				try {
					current = ( CCarte ) tc.getSommet();
				} catch (Exception e) {}
				this.empiler( current );
				tc.depiler();
			}while( !tc.isVide() );
		} 
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#isValideDrop()
	 */
	public boolean isValideDrop() {
		return isValideDrop;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#setValideDrop(boolean)
	 */
	public void setValideDrop(boolean isValideDrop) {
		this.isValideDrop = isValideDrop;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#isCarteEmpilable(solitaire.controler.CCarte)
	 */
	@Override
	public boolean isCarteEmpilable( CCarte cc ){
		return ( isValideDrop && ( this.isVide() || this.isEmpilable( cc ) ) );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#isTasEmpilable()
	 */
	@Override
	public boolean isTasEmpilable(){
		return false;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICTasDeCartes#isSommet(solitaire.controler.CCarte)
	 */
	@Override
	public boolean isSommet( ICCarte cc){
		boolean result = false;
		try {
			result = (cc == ( ICCarte ) getSommet());
		} catch (Exception e) {}
		return result;
	}
	
	private PTasDeCartes presentation;
	private boolean isValideDrop;
	private int nbSelection;
	private CUsine cu;
}
