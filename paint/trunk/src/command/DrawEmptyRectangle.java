package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawrectangle.BeginDrawEmptyRectangle;
import state.drawrectangle.EndDrawRectangle;
import state.drawrectangle.MotionDrawRectangle;

public class DrawEmptyRectangle extends Command {
	public DrawEmptyRectangle(){
		
		super( new State[]{
				new BeginDrawEmptyRectangle(),
				new MotionDrawRectangle(),
				new EndDrawRectangle()
				} );
		
}

public void execute( Point p ) {
	System.out.println( "Draw empty rectangle." );
	super.execute( p );
}

@Override
public void execute(MouseWheelEvent mouseEvent) {
	// TODO Auto-generated method stub
	
}
}
