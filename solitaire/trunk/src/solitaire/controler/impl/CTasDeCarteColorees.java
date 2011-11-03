package solitaire.controler.impl;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.controler.ICCarte;
import solitaire.controler.ICSolitaire;
import solitaire.controler.ICTasDeCartes;
import solitaire.controler.IWinCandidate;
import solitaire.view.impl.PTasDeCarteColorees;

public class CTasDeCarteColorees extends TasDeCartesColorees implements ICTasDeCartes, IWinCandidate{
	
	public CTasDeCarteColorees(String nom,int couleur ,Usine u) {
		super( nom, couleur, u );
		// TODO Auto-generated constructor stub
		presentation = new PTasDeCarteColorees( nom, this );
	}
	
	public void empiler(Carte c){
		if( isEmpilable( c ) ){
			super.empiler(c);
			try {
				if(c == getSommet()){
					presentation.empiler( ((ICCarte ) c).getPresentation() );
				}
			} catch (Exception e) {
				//System.out.println( "tas de carte coloree presentation: exception" );
				//e.printStackTrace();
			}
			main.actionGagne();
		}
	}
	
	@Override
	public void depiler(){
		//
		
		ICCarte c;
		try {
			c = ( ICCarte ) getSommet();
			super.depiler();
			presentation.depiler( c.getPresentation() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	@Override
	public void debutDnDDrag(ICCarte selectedControl) {
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
			}
		} else {
			nbSelection++;
			presentation.c2p_debutDnDKO();
		}
	}
	
	@Override
	public ICTasDeCartes debutDnDDragTas( ICCarte selectedControl ) {
		nbSelection++;
		presentation.c2p_debutDnDKO();
		return null;
	}
	
	@Override
	public void sortieDnDDrop(CCarte cc) {
		//System.out.println("empile carte tas coloree");
		if( this.isEmpilable( cc ) ){
			this.empiler(cc);
			presentation.c2p_finDnDValide();
		} else {
			//System.out.println("la carte ne peut être empiler.");
			presentation.c2p_finDnDInvalide();
		}
	}
	
	@Override
	public void finDnDDrag( CCarte cc,CTasDeCartes tc, boolean success){
		if(!success){
			empiler( cc );
		}
	}
	
	public PTasDeCarteColorees getPresentation() {
		return presentation;
	}
	
	@Override
	public boolean isValideDrop() {
		return valideDrop;
	}

	@Override
	public void setValideDrop(boolean isValideDrop) {
		valideDrop = isValideDrop;
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
		} catch (Exception e) {}
		return result;
	}
	
	@Override
	public void sortieDnDDrop(CTasDeCartes tc) {
		// TODO Auto-generated method stub
		presentation.c2p_finDnDInvalide();
	}
	
	@Override
	public boolean isTasEmpilable(){
		return false;
	}
	
	@Override
	public void setMain(ICSolitaire main) {
		this.main = main;
	}

	private ICSolitaire main;
	private boolean valideDrop = true;
	private PTasDeCarteColorees presentation;
	private int nbSelection;
	
}
