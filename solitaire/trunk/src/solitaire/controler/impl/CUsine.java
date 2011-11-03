package solitaire.controler.impl;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Sabot;
import solitaire.application.Solitaire;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

public class CUsine extends Usine {

	@Override
	public Carte newCarte(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return new CCarte(arg0, arg1);
	}

	@Override
	public Colonne newColonne(String arg0, Usine arg1) {
		// TODO Auto-generated method stub
		return new CColonne(arg0, (CUsine) arg1);
	}

	@Override
	public Sabot newSabot(String arg0, Usine arg1) {
		// TODO Auto-generated method stub
		return new CSabot(arg0, (CUsine) arg1);
	}

	@Override
	public Solitaire newSolitaire(String arg0, Usine arg1) {
		// TODO Auto-generated method stub
		return new CSolitaire(arg0, (CUsine) arg1);
	}

	@Override
	public TasDeCartes newTasDeCartes(String arg0, Usine arg1) {
		// TODO Auto-generated method stub
		return new CTasDeCartes(arg0, (CUsine) arg1);
	}

	@Override
	public TasDeCartesAlternees newTasDeCartesAlternees(String arg0, Usine arg1) {
		// TODO Auto-generated method stub
		return new CTasDeCartesAlterne(arg0, (CUsine) arg1);
	}

	@Override
	public TasDeCartesColorees newTasDeCartesColorees(String arg0, int arg1,
			Usine arg2) {
		// TODO Auto-generated method stub
		return new CTasDeCarteColorees(arg0, arg1, (CUsine) arg2);
	}
	
}
