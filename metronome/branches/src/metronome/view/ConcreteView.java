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

public class ConcreteView extends JFrame implements View{

	public ConcreteView(){
		
		super( "metronome swing presentation" );
		addWindowListener( new Finisher() );
		moteur = new ConcreteMM( controler );
		controler.setManage( moteur );
		controler.setPresente( this );
		getContentPane().add( BorderLayout.NORTH, ( JPanel ) currentAfficheur );
		getContentPane().add( BorderLayout.CENTER, ( JPanel ) currentMolette );
		getContentPane().add( BorderLayout.SOUTH, ( JPanel ) currentClavier );
		getContentPane().setPreferredSize( new Dimension( 400,200 ) );
		getContentPane().setSize( new Dimension( 600,200 ) );
		pack();
		setVisible( true );
		
	}
	
	public static void main(String ... args ){
		new ConcreteView();
	}
	
	class Finisher extends WindowAdapter {

		public void windowClosing(WindowEvent e){
			System.exit( 0 );
		}
		
	}
	
	@Override
	public void allumerLED1() {
		currentAfficheur.afficherLED( 1 );
	}

	@Override
	public void allumerLED2() {
		currentAfficheur.afficherLED( 2 );
	}

	@Override
	public void displayBPM( int bpm ) {
		currentAfficheur.afficherTempo( bpm );
	}

	@Override
	public void emettreSon() {
		currentEmetteurSonore.emettreClic();
	}

	@Override
	public void eteindreLED1() {
		currentAfficheur.etteindreLED( 1 );
	}

	@Override
	public void eteindreLED2() {
		currentAfficheur.etteindreLED( 2 );
	}

	@Override
	public Horloge getHorloge() {
		// TODO Auto-generated method stub
		return currentHorloge;
	}

	@Override
	public void notifyBPM() {
		// TODO Auto-generated method stub
		for(ObservateurPresentation observateur:observateurs)
			observateur.actualisePresentationBPM();
	}

	@Override
	public void addBPMObs(ObservateurPresentation observer) {
		observateurs.add( observer );
	}

	@Override
	public void notifyViewBPM() {
		// TODO Auto-generated method stub
		for(ObservateurPresentation observateur: observateurs)
			observateur.notify();
		
	}

	@Override
	public void removeBPMObs(ObservateurPresentation observer) {
		observateurs.remove( observer );
	}
	
	@Override
	public EmetteurSonore getEmetteurSonore() {
		return currentEmetteurSonore;
	}
	
	@Override
	public Controler getControler() {
		return controler;
	}
	
	@Override
	public Afficheur getAfficheur() {
		// TODO Auto-generated method stub
		return currentAfficheur;
	}
	
	@Override
	public Molette getMolette() {
		// TODO Auto-generated method stub
		return currentMolette;
	}

	private Horloge currentHorloge = new HorlogeSimulate();
	private Clavier currentClavier = new ClavierSimulate( this );
	private Molette currentMolette = new MoletteSimulate( this );
	private EmetteurSonore currentEmetteurSonore = new EmetteurSonoreSimulate();
	private Afficheur currentAfficheur = new AfficheurSimulate();
	private List<ObservateurPresentation> observateurs = new ArrayList<ObservateurPresentation>();
	private Controler controler = new ConcreteControler();
	private MoteurMetronome moteur;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
