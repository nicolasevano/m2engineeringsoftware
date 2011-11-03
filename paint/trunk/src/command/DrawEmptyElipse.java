package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.drawelipse.BeginDrawEmptyElipse;
import state.drawelipse.EndDrawElipse;
import state.drawelipse.MotionDrawElipse;

public class DrawEmptyElipse extends Command {
	
public DrawEmptyElipse(){
		
		super( new State[]{
				new BeginDrawEmptyElipse(),
				new MotionDrawElipse(),
				new EndDrawElipse()
				} );
		
	}
	
	public void execute( Point p ) {
		System.out.println( "Draw empty elipse." );
		super.execute( p );
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
