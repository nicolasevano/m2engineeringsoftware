package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawtriangle.BeginDrawTopTriangle;
import state.drawtriangle.EndDrawTriangle;
import state.drawtriangle.MotionDrawTriangle;

public class DrawTopTriangle extends Command {
	public DrawTopTriangle(){

		super( new State[]{
				new BeginDrawTopTriangle(),
				new MotionDrawTriangle(),
				new EndDrawTriangle()
		} );

	}

	public void execute( Point p ) {
		System.out.println( "Draw top triangle." );
		super.execute( p );
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
