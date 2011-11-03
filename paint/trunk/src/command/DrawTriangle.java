package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawtriangle.BeginDrawTriangle;
import state.drawtriangle.EndDrawTriangle;
import state.drawtriangle.MotionDrawTriangle;

public class DrawTriangle extends Command {
	public DrawTriangle(){
		
		super( new State[]{
				new BeginDrawTriangle(),
				new MotionDrawTriangle(),
				new EndDrawTriangle()
				} );
		
	}

	public void execute( Point p ) {
		System.out.println( "Draw triangle." );
		super.execute( p );
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
