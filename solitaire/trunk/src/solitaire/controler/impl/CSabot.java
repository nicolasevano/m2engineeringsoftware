package solitaire.controler.impl;

import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.application.Usine;
import solitaire.controler.ICCarte;
import solitaire.controler.ICSabot;
import solitaire.controler.ICTasDeCartes;
import solitaire.view.IPSabot;
import solitaire.view.impl.PSabot;

public class CSabot extends Sabot implements ICSabot{
	
	public CSabot(String nom, Usine u){
		super( nom, u );
		presentation = new PSabot( ( ( CTasDeCartes ) this.visibles ).getPresentation(), 
								   ( ( CTasDeCartes ) this.cachees ).getPresentation() );
		
		( ( CTasDeCartes ) this.cachees ).setValideDrop( false );
		( ( CTasDeCartes ) this.visibles ).setValideDrop( true );
		presentation.setControl( this );
		presentation.activerRetournerCarteListener();
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICSabot#setReserve()
	 */
	@Override
	public void setReserve(){
		CCarte current;
		
		super.setReserve( visibles );
		//
		do{
			
			try{
				current = (CCarte) cachees.getSommet();
				cachees.depiler();
				current.setFaceVisible(false);
				visibles.empiler(current);
			} catch(Exception e) {
				current = null;
			}
			
		}while( current != null );
		super.setReserve( visibles );
		//
		if( !cachees.isVide() ){
			
			presentation.desactiverRetournerTasListener();
			presentation.activerRetournerCarteListener();
			
		}	
		
	}
	
	@Override
	public void retournerCarte(){
		int counterCarteRetourne = 0;
		try {
			if( !this.isRetournable() ){
				//System.out.println(" carte retournable ");
				do{
					super.retournerCarte();
				}while( ++counterCarteRetourne < 3 );
				if( cachees.isVide() ){
					presentation.activerRetournerTasListener();
					presentation.desactiverRetournerCarteListener();
				}
			} else {
				//System.out.println( "carte non retournable" );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICSabot#getPresentation()
	 */
	public IPSabot getPresentation() {
		return presentation;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICSabot#c2p_debutDnD(solitaire.controler.CCarte)
	 */
	public void c2p_debutDnD(ICCarte cc){
		if( cc != null){
			try {
				if( cc == this.getSommet() ){
					depiler();
					presentation.c2p_debutDnD( cc.getPresentation() );
				} else {
					nbManualSelection++;
					presentation.c2p_debutDnDKO();
				} 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			nbSelection++;
		}
		nbSelection++;
		presentation.c2p_debutDnDKO();
	}
	
	@Override
	public ICTasDeCartes getVisibles(){
		return ( ICTasDeCartes ) this.visibles;
	}
	
	@Override
	public void setVisibles( ICTasDeCartes visibles ){
		do{
			try {
				this.visibles.depiler();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!this.visibles.isVide());
		this.visibles.recopier( (CTasDeCartes)visibles );
	}
	
	@Override
	public ICTasDeCartes getCachees(){
		return ( CTasDeCartes ) this.cachees;
	}
	
	@Override
	public void setCachees( ICTasDeCartes cachees ){
		do{
			try {
				this.cachees.depiler();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!this.cachees.isVide());
		this.cachees.recopier( (CTasDeCartes)cachees );
	}
	
	private int nbSelection = 0;
	private int nbManualSelection = 0;
	private IPSabot presentation;
}
