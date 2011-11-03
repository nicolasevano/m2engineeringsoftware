package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawrectangle.BeginDrawRectangle;
import state.drawrectangle.EndDrawRectangle;
import state.drawrectangle.MotionDrawRectangle;

public class DrawRectangle extends Command {

	public DrawRectangle(){
			
			super( new State[]{
					new BeginDrawRectangle(),
					new MotionDrawRectangle(),
					new EndDrawRectangle()
					} );
			
	}
	
	public void execute( Point p ) {
		System.out.println( "Draw rectangle." );
		super.execute( p );
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

}
