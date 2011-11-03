
package metronomelogic.controler;

import metronome.view.View;
import metronomelogic.Afficheur;
import metronomelogic.EmetteurSonore;
import metronomelogic.Horloge;
import metronomelogic.moteur.MoteurMetronome;

public class ConcreteControler implements Controler {
	
	public ConcreteControler(){
		
	}
	
	@Override
	public int convertInBPM( double bpmRatio ) {
		return (int)( bpmRatio * 200 );
	}

	@Override
	public Afficheur getAfficheur() {
		// TODO Auto-generated method stub
		return presente.getAfficheur();
	}

	@Override
	public EmetteurSonore getEmetteurSonore() {
		// TODO Auto-generated method stub
		return presente.getEmetteurSonore();
	}

	@Override
	public Horloge getHorloge() {
		// TODO Auto-generated method stub
		return presente.getHorloge();
	}

	@Override
	public MoteurMetronome getManage() {
		// TODO Auto-generated method stub
		return manage;
	}

	@Override
	public double getMoletteBPM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTouchePressé() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setManage(MoteurMetronome moteurMetronome) {
		this.manage = moteurMetronome;
		manage.addTempoObs( this );
		manage.addBPMObs( this );
	}

	@Override
	public void actualiseTempo() {
		
		manage.removeEventPeriodique(
				manage.getCommands().get(
						MoteurMetronome.commandName[ MoteurMetronome.GENERER_ECLAIR_LED2 ]
				                         ) );
		manage.addEventPeriodique(manage.getCommands().get(
				MoteurMetronome.commandName[ MoteurMetronome.GENERER_ECLAIR_LED2 ] ), 
				Double.valueOf( Double.valueOf(60) /( Double.valueOf((manage.getTempo() * manage.getBPM()) ) ) ) 
				);
		// TODO Auto-generated method stub
	}

	@Override
	public void actualiseBPM() {
		
		manage.removeEventPeriodique(
				manage.getCommands().get(
						MoteurMetronome.commandName[ MoteurMetronome.GENERER_ECLAIR_LED1 ]
				                         ) );
		manage.addEventPeriodique(manage.getCommands().get(
				MoteurMetronome.commandName[ MoteurMetronome.GENERER_ECLAIR_LED1 ] ), 
				Double.valueOf( ( 60 / Double.valueOf( manage.getBPM() ) ) ) 
				);
		
		manage.removeEventPeriodique(
				manage.getCommands().get(
						MoteurMetronome.commandName[ MoteurMetronome.GENERER_CLIC ]
				                         ) );
		manage.addEventPeriodique(manage.getCommands().get(
				MoteurMetronome.commandName[ MoteurMetronome.GENERER_CLIC ] ), 
				( Double.valueOf(60) /Double.valueOf( manage.getBPM() ) ) 
				);
		
		manage.removeEventPeriodique(
				manage.getCommands().get(
						MoteurMetronome.commandName[ MoteurMetronome.GENERER_ECLAIR_LED2 ]
				                         ) );
		manage.addEventPeriodique(manage.getCommands().get(
				MoteurMetronome.commandName[ MoteurMetronome.GENERER_ECLAIR_LED2 ] ), 
				Double.valueOf( 60 /( Double.valueOf(manage.getTempo() * manage.getBPM() ) ) ) 
				);
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		manage.run();
	}
	
	public void stop() {
		manage.stop();
	}
	
	@Override
	public void actualisePresentationBPM() {
		// TODO Auto-generated method stub
		double position = presente.getMolette().position();
		int bpm = convertInBPM( position );
		manage.setBPM( bpm );
		presente.displayBPM( bpm );
		
	}
	
	@Override
	public void decTempo() {
		int tempo;
		tempo = manage.getTempo();
		manage.setTempo( ( ( tempo - 1 ) > 1 )? tempo - 1: tempo );
		
	}

	@Override
	public void incTempo() {
		int tempo;
		tempo = manage.getTempo();
		System.out.println( "current tempo is: " + tempo );
		manage.setTempo( ( ( tempo + 1 ) < 8 )? tempo + 1: tempo );
		tempo = manage.getTempo();
		System.out.println( "new tempo is: " + tempo );
	}

	@Override
	public View getPresente() {

		return presente;
		
	}

	@Override
	public void setPresente( View presente ) {
		
		this.presente = presente;
		presente.addBPMObs( this );
		
	}
	
	private View presente;
	
	private MoteurMetronome manage;

}
