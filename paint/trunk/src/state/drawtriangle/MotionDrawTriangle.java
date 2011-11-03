package state.drawtriangle;

import java.awt.Point;

import command.Command;

import state.State;

public class MotionDrawTriangle implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		int currentWidth = Math.abs(origine.x - p.x);
		int currentHeight = Math.abs(origine.y - p.y);
		System.out.println( "p.x = " + p.x + ", currentWidth = " + currentWidth );
		System.out.println( "p.y = " + p.y + ", currentHeight = " + currentHeight );
		//command.getDessin().setBounds(((p.x - origine.x)>0)?(p.x - currentWidth):p.x,
		//		   					  ((p.y - origine.y)>0)?(p.y - currentHeight):p.y,
		//							  currentWidth, 
		//							  currentHeight );
		currentCommand.getDessin().setBounds(Math.min(p.x, origine.x),
									  Math.min(p.y, origine.y),
									  currentWidth, 
									  currentHeight );
	}

}
