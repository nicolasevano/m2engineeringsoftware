package state.drawcircle;

import java.awt.Point;

import state.State;
import command.Command;

public class MotionDrawCircle implements State {

	@Override
	public void draw( Point p, Point origine, Command command ) {
		// TODO Auto-generated method stub
		int currentWidth;
		
		int dx = origine.x - p.x;
		int dy = origine.y - p.y;

		//currentWidth = (int)Math.sqrt( dx * dx + dy * dy );
		currentWidth = (int)Math.abs( dx + dy );
		command.getDessin().setBounds(origine.x - currentWidth,
				origine.y - currentWidth,
				currentWidth * 2, currentWidth * 2 );			
	}

}
