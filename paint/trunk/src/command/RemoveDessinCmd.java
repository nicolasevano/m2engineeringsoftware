package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.remove.RemoveDessin;

public class RemoveDessinCmd extends Command {
public RemoveDessinCmd(){
		
		super( new State[]{
				new RemoveDessin()
				} );
		
	}

	public void execute( Point p ) {
		System.out.println( "Remove dessin." );
		super.execute( p );
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
