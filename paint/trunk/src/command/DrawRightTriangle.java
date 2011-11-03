package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawtriangle.BeginDrawRightTriangle;
import state.drawtriangle.EndDrawTriangle;
import state.drawtriangle.MotionDrawTriangle;

public class DrawRightTriangle extends Command {
	public DrawRightTriangle(){

		super( new State[]{
				new BeginDrawRightTriangle(),
				new MotionDrawTriangle(),
				new EndDrawTriangle()
		} );

	}

	public void execute( Point p ) {
		System.out.println( "Draw right triangle." );
		super.execute( p );
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
