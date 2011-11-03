package metronomelogic.command.lireclavier;

import metronome.view.View;
import metronomelogic.controler.Controler;
import metronomelogic.moteur.MoteurMetronome;

public class KeyInc implements KeyIsPushed {

	public KeyInc( MoteurMetronome currentMoteur ){
		this.currentMoteur = currentMoteur;
		//no longer use chain of responsibility
		//next = new KeyDec( currentMoteur );
	}
	
	@Override
	public KeyIsPushed getNext() {
		// TODO Auto-generated method stub
		return this.next;
	}

	@Override
	public boolean isPuched(int key) {
		// TODO Auto-generated method stub
		return key == View.KEY_INC;
	}

	@Override
	public void execute() {
		int tempo;
		//if( isPuched( key ) ){
		tempo = currentMoteur.getTempo();
		System.out.println( "current tempo is: " + tempo );
		currentMoteur.setTempo( ( ( tempo + 1 ) < 8 )? tempo + 1: tempo );
		tempo = currentMoteur.getTempo();
		System.out.println( "new tempo is: " + tempo );
		//} else {
		//	next.execute();
		//}
		
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
		if(next != null) next.setKey( key );
	}
	
	private KeyIsPushed next = null;
	
	private String name = null;
	
	private int key;
	
	private MoteurMetronome currentMoteur;

}
