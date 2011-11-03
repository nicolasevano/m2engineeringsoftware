package solitaire.controler.impl;

import solitaire.application.Colonne;
import solitaire.controler.ICColonne;
import solitaire.controler.ICTasDeCartes;
import solitaire.controler.IControlCarteRetournable;
import solitaire.view.impl.PColonne;

public class CColonne extends Colonne implements IControlCarteRetournable, ICColonne{

	public CColonne( String nom, CUsine u ){
		
		super( nom, u );
		( ( CTasDeCartesAlterne ) this.visibles ).setCcolonne( this );
		
		presentation = new PColonne( ( ( CTasDeCartesAlterne ) this.visibles ).getPresentation(), 
									 ( ( CTasDeCartes ) this.cachees ).getPresentation() );
		( ( CTasDeCartes )cachees ).setValideDrop( false );
		presentation.setControl( this );
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICColonne#retournerCarte()
	 */
	@Override
	public void retournerCarte(){
		try{
			if( super.isCarteRetournable() ){
				super.retournerCarte();
				presentation.desactiverRetournerCarteListener();
			}
		}catch ( Exception e ) {
			
		}
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICColonne#activeRetourneCarte()
	 */
	public void activeRetourneCarte(){
		if( super.isCarteRetournable() )
			presentation.activerRetournerCarteListener();
	}
	
	/* (non-Javadoc)
	 * @see solitaire.controler.ICColonne#getPresentation()
	 */
	public PColonne getPresentation() {
		return presentation;
	}
	
	public ICTasDeCartes getVisibles() {
		return ( ICTasDeCartes ) this.visibles;
	}
	
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
	
	public ICTasDeCartes getCachees() {
		return ( ICTasDeCartes ) this.cachees;
	}
	
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
	
	private PColonne presentation;

}
