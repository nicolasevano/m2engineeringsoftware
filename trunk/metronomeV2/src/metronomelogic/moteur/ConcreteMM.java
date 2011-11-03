
package metronomelogic.moteur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import metronomelogic.command.Command;
import metronomelogic.command.GenererEclairSurLED2;
import metronomelogic.command.GenererSon;
import metronomelogic.command.LireBPM;

import metronomelogic.command.GenererEclairSurLED1;
import metronomelogic.command.lireclavier.LireClavier;
import metronomelogic.controler.Controler;
import metronomelogic.controler.Observateur;


public class ConcreteMM implements MoteurMetronome {
	
	public ConcreteMM(){
		this( null );
	}
	
	public ConcreteMM( Controler controler ){
		
		this.accede = controler;
		this.bpm = 100;
		this.tempo = 2;
		this.state = false;
		commands.put( commandName[ LIRE_CLAVIER ], ( ( Command ) new LireClavier( this ) ) );
		commands.put( commandName[ LIRE_BPM ], ( ( Command ) new LireBPM(this ) ) );
		commands.put( commandName[ GENERER_CLIC], ( ( Command ) new GenererSon( this ) ) );
		commands.put( commandName[ GENERER_ECLAIR_LED1 ], ( ( Command ) new GenererEclairSurLED1( this ) ) );
		commands.put( commandName[ GENERER_ECLAIR_LED2 ], ( ( Command ) new GenererEclairSurLED2( this ) ) );
		
		controler.getHorloge().activerPeriodiquement(commands.get( commandName[ LIRE_CLAVIER ] ), 0.1 );
		controler.getHorloge().activerPeriodiquement(commands.get( commandName[ LIRE_BPM ] ), 1 );
	}
	
	public Controler getAccede() {
		return accede;
	}

	public void setAccede( Controler accede ) {
		this.accede = accede;
	}
	
	@Override
	public void addEventDelay( Command cmd, double delay ) {
		accede.getHorloge().activerPeriodiquement( cmd, delay );
	}

	@Override
	public void addEventPeriodique(Command cmd, double delay) {
		accede.getHorloge().activerPeriodiquement( cmd, delay );
	}

	@Override
	public int getBPM() {
		return this.bpm;
	}

	@Override
	public int getTempo() {
		return this.tempo;
	}

	@Override
	public boolean isEtatMarche() {
		return this.state;
	}

	@Override
	public void removeEventPeriodique( Command cmd ) {
		accede.getHorloge().désactiver( cmd );
	}

	@Override
	public void run() {
		if( !state ){
			state = true;
			notifyBPM();
		}
	}

	@Override
	public void setBPM( int bpm ) {
		if(this.bpm != bpm){
			this.bpm = bpm;
			this.notifyBPM();
		}
	}

	@Override
	public void setEtatMarche( boolean etatMarche ) {
		this.state = etatMarche;
	}

	@Override
	public void setTempo( int tempo ) {
		if( this.tempo != tempo ){
			this.tempo = tempo;
			this.notifyTempo();
		}
	}

	@Override
	public void stop() {
		for(int i = 2; i < 5; i++ )
			accede.getHorloge().désactiver( commands.get( commandName[i] ) );
		state = false;
	}

	@Override
	public void addTempoObs( Observateur watcher ) {
		obsTempos.add( watcher );
	}

	@Override
	public void notifyTempo() {
		if( state )for( Observateur obs: obsTempos ){
			obs.actualiseTempo();
		}
	}

	@Override
	public void removeTempoObs( Observateur watcher ) {
		obsTempos.remove( watcher );
	}

	@Override
	public void addBPMObs( Observateur observer ) {
		obsBPMs.add( observer );
	}

	@Override
	public void notifyBPM() {
		if( state )for( Observateur obs: obsBPMs ){
			obs.actualiseBPM();
		}
	}

	@Override
	public void removeBPMObs( Observateur observer ) {
		obsTempos.remove( observer );
	}
	
	public final Map<String, Command> getCommands() {
		return commands;
	}
	
	private boolean state;
	
	private int bpm;
	
	private int tempo;
	
	private Map<String,Command> commands = new TreeMap<String,Command>();

	private Controler accede;
	
	private List<Observateur> obsTempos = new ArrayList<Observateur>();
	
	private List<Observateur> obsBPMs = new ArrayList<Observateur>();
	
}
