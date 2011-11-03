package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawcircle.BeginDrawCircle;
import state.drawcircle.EndDrawCircle;
import state.drawcircle.MotionDrawCircle;

public class DrawCircle extends Command {

	public DrawCircle(){
		
		super( new State[]{
				new BeginDrawCircle(),
				new MotionDrawCircle(),
				new EndDrawCircle()
				} );
		
	}
	
	public void execute( Point p ) {
		System.out.println( "Draw circle." );
		super.execute( p );
		
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

}
