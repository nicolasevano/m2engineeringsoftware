package solitaire.controler;

import solitaire.application.Carte;
import solitaire.controler.impl.CCarte;
import solitaire.controler.impl.CTasDeCartes;
import solitaire.view.IPTasDeCartes;

public interface ICTasDeCartes {
	
	public void empiler( Carte c );
	public void depiler();
	public void debutDnDDrag( ICCarte selectedControl );
	public ICTasDeCartes debutDnDDragTas( ICCarte selectedControl );
	public void sortieDnDDrop( CCarte cc );
	public void sortieDnDDrop( CTasDeCartes tc );
	public void finDnDDrag( CCarte cc, CTasDeCartes tc, boolean success);
	public boolean isValideDrop();
	public void setValideDrop(boolean isValideDrop);
	public boolean isCarteEmpilable( CCarte cc );
	public boolean isSommet( ICCarte cc );
	public boolean isTasEmpilable();
	public IPTasDeCartes getPresentation();
}