
package metronomelogic.moteur;

import java.util.Map;

import metronomelogic.command.Command;
import metronomelogic.controler.Controler;


public interface MoteurMetronome extends TempoSubject, BPMSubject {

	public void stop() ;

	public void run() ;

	public void removeEventPeriodique(Command cmd) ;

	public void addEventDelay(Command cmd, double delai) ;

	public void addEventPeriodique(Command cmd, double delai) ;

	public int getTempo() ;

	public void setTempo(int tempo) ;

	public int getBPM() ;

	public void setBPM(int tempoParMesure) ;

	public boolean isEtatMarche() ;

	public Controler getAccede();
	  
	public void setAccede( Controler controler );
	
	public void setEtatMarche(boolean etatMarche) ;
	
	public Map<String, Command> getCommands() ;
	
	public static final int LIRE_CLAVIER = 0;
	
	public static final int LIRE_BPM = 1;
	
	public static final int GENERER_CLIC = 2;
	
	public static final int GENERER_ECLAIR_LED1 = 3;
	
	public static final int GENERER_ECLAIR_LED2 = 4;
	
	public static final String [] commandName = new String[]{
		"lireClavier",
		"lireBPM",
		"genererClic",
		"genererEclairLED1",
		"genererEclairLED2"
		};
}
