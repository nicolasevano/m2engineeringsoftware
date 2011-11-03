package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawcircle.BeginDrawEmptyCircle;
import state.drawcircle.EndDrawCircle;
import state.drawcircle.MotionDrawCircle;

public class DrawEmptyCircle extends Command {


	public DrawEmptyCircle(){
		
		super( new State[]{
				new BeginDrawEmptyCircle(),
				new MotionDrawCircle(),
				new EndDrawCircle()
				} );
		
	}
	
	public void execute( Point p ) {
		System.out.println( "Draw empty circle." );
		super.execute( p );
		
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

}
