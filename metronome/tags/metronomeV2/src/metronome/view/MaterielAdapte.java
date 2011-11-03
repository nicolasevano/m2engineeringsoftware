package metronome.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import metronomelogic.Afficheur;
import metronomelogic.Clavier;
import metronomelogic.EmetteurSonore;
import metronomelogic.Horloge;
import metronomelogic.Molette;
import metronomelogic.controler.ConcreteControler;
import metronomelogic.controler.Controler;
import metronomelogic.controler.ObservateurPresentation;
import metronomelogic.moteur.ConcreteMM;
import metronomelogic.moteur.MoteurMetronome;

public class MaterielAdapte{

	public MaterielAdapte(){
	}
	
	
	public static EmetteurSonore getEmetteurSonore() {
		return currentEmetteurSonore;
	}
	
	public static Afficheur getAfficheur() {
		// TODO Auto-generated method stub
		return currentAfficheur;
	}
	
	public static Molette getMolette() {
		// TODO Auto-generated method stub
		return currentMolette;
	}

	public static Clavier getClavier() {
		// TODO Auto-generated method stub
		return currentClavier;
	}
	
	public static Horloge getHorloge() {
		return currentHorloge;
	}
	
	private static Horloge currentHorloge = new HorlogeSimulate();
	private static Clavier currentClavier = new ClavierSimulate();
	private static Molette currentMolette = new MoletteSimulate();
	private static EmetteurSonore currentEmetteurSonore = new EmetteurSonoreSimulate();
	private static Afficheur currentAfficheur = new AfficheurSimulate();
	
	//private List<ObservateurPresentation> observateurs = new ArrayList<ObservateurPresentation>();
	//private Controler controler = new ConcreteControler();
	//private MoteurMetronome moteur;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

}
