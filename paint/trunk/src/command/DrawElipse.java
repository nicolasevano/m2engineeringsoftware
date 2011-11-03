package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawelipse.BeginDrawElipse;
import state.drawelipse.EndDrawElipse;
import state.drawelipse.MotionDrawElipse;

public class DrawElipse extends Command{
public DrawElipse(){
		
		super( new State[]{
				new BeginDrawElipse(),
				new MotionDrawElipse(),
				new EndDrawElipse()
				} );
		
	}
	
	public void execute( Point p ) {
		System.out.println( "Draw elpise." );
		super.execute( p );
		
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
