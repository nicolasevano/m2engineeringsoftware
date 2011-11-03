package metronomelogic.command.lireclavier;

import metronomelogic.command.Command;

public interface KeyIsPushed extends Command{
	boolean isPuched( int key );
	KeyIsPushed getNext();
	void setKey( int key );
	int getKey();
}
