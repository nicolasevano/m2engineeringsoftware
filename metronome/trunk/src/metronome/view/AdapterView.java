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

public class AdapterView extends JFrame implements View{
	
	public AdapterView(){
		super( "metronome swing presentation" );
		addWindowListener( new Finisher() );
		
		controler.setPresente( this );
		moteur = new ConcreteMM( controler );
		controler.setManage( moteur );
		getContentPane().add( BorderLayout.NORTH, ( JPanel ) MaterielAdapte.getAfficheur() );
		getContentPane().add( BorderLayout.CENTER, ( JPanel ) MaterielAdapte.getMolette() );
		getContentPane().add( BorderLayout.SOUTH, ( JPanel ) MaterielAdapte.getClavier() );
		getContentPane().setPreferredSize( new Dimension( 400,200 ) );
		getContentPane().setSize( new Dimension( 600,200 ) );
		pack();
		setVisible( true );
	}
	
	public static void main( String ... args ){
		new AdapterView();
	}
	
	class Finisher extends WindowAdapter {

		public void windowClosing(WindowEvent e){
			System.exit( 0 );
		}
		
	}

	@Override
	public void allumerLED1() {
		MaterielAdapte.getAfficheur().afficherLED( 1 );
	}

	@Override
	public void allumerLED2() {
		MaterielAdapte.getAfficheur().afficherLED( 2 );
		
	}

	@Override
	public void eteindreLED1() {
		MaterielAdapte.getAfficheur().etteindreLED( 1 );

		
	}

	@Override
	public void eteindreLED2() {
		MaterielAdapte.getAfficheur().etteindreLED( 2 );
		
	}

	@Override
	public void emettreSon() {
		MaterielAdapte.getEmetteurSonore().emettreClic();
		
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
	public void displayBPM(int bpm) {
		// TODO Auto-generated method stub
		MaterielAdapte.getAfficheur().afficherTempo( bpm );
		
	}

	@Override
	public Horloge getHorloge() {
		// TODO Auto-generated method stub
		return MaterielAdapte.getHorloge();
	}

	@Override
	public EmetteurSonore getEmetteurSonore() {
		// TODO Auto-generated method stub
		return MaterielAdapte.getEmetteurSonore();
	}

	@Override
	public Controler getControler() {
		// TODO Auto-generated method stub
		return controler;
	}

	@Override
	public Afficheur getAfficheur() {
		// TODO Auto-generated method stub
		return MaterielAdapte.getAfficheur();
	}

	@Override
	public Molette getMolette() {
		// TODO Auto-generated method stub
		return MaterielAdapte.getMolette();
	}

	@Override
	public void setBPM() {
		// TODO Auto-generated method stub
		notifyBPM();
	}

	@Override
	public Clavier getClavier() {
		// TODO Auto-generated method stub
		return MaterielAdapte.getClavier();
	}

	@Override
	public int getTouchePressé() {
		boolean result = false;
		int i;
		//System.out.println("getTouchePressé");
		for( i = View.KEY_START; i < View.key.length; i++ ){
			result = MaterielAdapte.getClavier().touchePressée( i );
			if( result ){
				System.out.println( "getTouvhePressé = " + i );
				break;
			}
		}
		return ( result )?i:View.KEY_NONE;
	}

	private List<ObservateurPresentation> observateurs = new ArrayList<ObservateurPresentation>();
	private Controler controler = new ConcreteControler();
	private MoteurMetronome moteur;
	
}
