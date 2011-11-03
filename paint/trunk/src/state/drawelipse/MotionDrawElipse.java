package state.drawelipse;

import java.awt.Point;

import command.Command;

import state.State;

public class MotionDrawElipse implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		int currentWidth;
		int currentHeight;
		
		int dx = origine.x - p.x;
		int dy = origine.y - p.y;

		//currentWidth = (int)Math.sqrt( dx * dx + dy * dy );
		currentWidth = (int)Math.abs( dx );
		currentHeight = (int)Math.abs( dy );
		currentCommand.getDessin().setBounds(origine.x - currentWidth,
				origine.y - currentHeight,
				currentWidth * 2, currentHeight * 2 );	
	}

}
