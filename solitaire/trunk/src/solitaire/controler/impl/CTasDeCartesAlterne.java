package solitaire.controler.impl;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.controler.ICCarte;
import solitaire.controler.ICColonne;
import solitaire.controler.ICTasDeCartes;
import solitaire.view.impl.PTasDeCartesAlternes;

public class CTasDeCartesAlterne extends TasDeCartesAlternees implements ICTasDeCartes{
	
	public CTasDeCartesAlterne( String nom, Usine u ){
		super( nom, u );
		// TODO Auto-generated constructor stub
		presentation = new PTasDeCartesAlternes( nom, this );
		cu = ( CUsine ) u;
	}
	
	@Override
	public void empiler(Carte c){
		super.empiler( c );
		try {
			if(getSommet() == c){
				presentation.empiler( ( ( ICCarte ) c).getPresentation() );
			}
		} catch (Exception e) {
			//System.out.println( "tas de carte alterné control: exception" );
			//e.printStackTrace();
		}
		//if( isEmpilable( c ) ){
		//	if( this.isVide() ) 
		//		if( c.getValeur() == 13 ){
		//			empilerWithoutConstraint( c );
		//		}
		//} else {
			
			//
			
		//}
	}
	
	
	@Override
	public void depiler(){
		
		ICCarte c;
		try {
			c = ( ICCarte ) getSommet();
			super.depiler();
			presentation.depiler( c.getPresentation() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(" Exception CTasDeCarteAlterne cannot do this operation");
			//e.printStackTrace();
		}
		
	}
	
	@Override
	public void debutDnDDrag(ICCarte selectedControl) {
		//System.out.println("debut grag and drop carte");
		if( selectedControl != null ){
			try {
				if( !this.isVide() && selectedControl == getSommet() ){
					this.depiler();
					presentation.c2p_debutDnDOK( selectedControl );
				} else {
					nbSelection++;
					presentation.c2p_debutDnDKO();
				}
			} catch (Exception e) {
				//nbSelection++;
				//presentation.c2p_debutDnDKO();
				//e.printStackTrace();
			}
		} else {
			nbSelection++;
			presentation.c2p_debutDnDKO();
		}
	}

	@Override
	public ICTasDeCartes debutDnDDragTas( ICCarte selectedControl ){
		ICTasDeCartes result = (CTasDeCartes) cu.newTasDeCartes( "tmp", cu );
		//System.out.println("debut grag and drop tas");
		CCarte current = null;
		if( selectedControl != null ){
			try {
				if( !isVide() ){
					do{
						current = ( CCarte ) getSommet();
						this.depiler();
						result.empiler( current );
					}while( selectedControl != current );
					presentation.c2p_debutDnDOK( result );
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
		return result;
	}
	
	@Override
	public void sortieDnDDrop( CTasDeCartes tc ){
		CCarte current = null;
		//System.out.println("sortie drag and drop tas");
		try {
			if(  this.isVide() || this.isEmpilable( tc.getSommet() ) ){
				do{
					current = ( CCarte ) tc.getSommet();
					this.empiler( current );
					tc.depiler();
				}while( !tc.isVide() );
				presentation.c2p_finDnDValide();
			} else {
				presentation.c2p_finDnDInvalide();
			}
		} catch (Exception e) {
			presentation.c2p_finDnDInvalide();
		}
	}
	
	@Override
	public void sortieDnDDrop(CCarte cc) {
		//System.out.println("sortie drag and drop carte");
		if( this.isEmpilable( cc ) ){
			this.empiler( cc );
			presentation.c2p_finDnDValide();
		} else {
			presentation.c2p_finDnDInvalide();
		}
	}
	
	@Override
	public void finDnDDrag( CCarte cc,CTasDeCartes tc, boolean success){
		CCarte current = null;
		//System.out.println( "finDnDDrag" );
		//System.out.println("tc = " + tc);
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
				}while( !tc.isVide() );
			}
		} else {
			//System.out.println( "active retourne Carte" );
			ccolonne.activeRetourneCarte();
		}
	}
	
	public PTasDeCartesAlternes getPresentation() {
		return presentation;
	}
	
	public void setCcolonne(ICColonne ccolonne) {
		this.ccolonne = ccolonne;
	}
	
	@Override
	public boolean isValideDrop() {
		// TODO Auto-generated method stub
		return valideDrop;
	}

	@Override
	public void setValideDrop(boolean isValideDrop) {
		// TODO Auto-generated method stub
		this.valideDrop = isValideDrop;
	}
	
	@Override
	public boolean isCarteEmpilable( CCarte cc ){
		return this.isEmpilable( cc );
	}
	
	@Override
	public boolean isSommet( ICCarte cc){
		boolean result = false;
		try {
			result = (cc == ( ICCarte ) getSommet());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		//System.out.println( "carte au sommet = " + result );
		return result;
	}
	
	@Override
	public boolean isTasEmpilable(){
		return true;
	}
	
	private boolean valideDrop = true; 
	private ICColonne ccolonne;
	private PTasDeCartesAlternes presentation;
	private int nbSelection;
	private CUsine cu;
	

}
