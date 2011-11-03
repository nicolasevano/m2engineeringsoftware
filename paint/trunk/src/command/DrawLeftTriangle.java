package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawtriangle.BeginDrawLeftTriangle;
import state.drawtriangle.EndDrawTriangle;
import state.drawtriangle.MotionDrawTriangle;

public class DrawLeftTriangle extends Command{
	public DrawLeftTriangle(){

		super( new State[]{
				new BeginDrawLeftTriangle(),
				new MotionDrawTriangle(),
				new EndDrawTriangle()
		} );

	}

	public void execute( Point p ) {
		System.out.println( "Draw left triangle." );
		super.execute( p );
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
