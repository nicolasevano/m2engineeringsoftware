package state.drawrectangle;

import java.awt.Point;

import state.State;
import command.Command;


public class MotionDrawRectangle implements State {

	@Override
	public void draw( Point p, Point origine, Command command ) {
		// TODO Auto-generated method stub
		//int currentWidth = (int) Math.sqrt( (origine.x - p.x) * (origine.x - p.x) );
		//int currentHeight = (int) Math.sqrt( (origine.y - p.y) * (origine.y - p.y) );
		int currentWidth = Math.abs(origine.x - p.x);
		int currentHeight = Math.abs(origine.y - p.y);
		System.out.println( "p.x = " + p.x + ", currentWidth = " + currentWidth );
		System.out.println( "p.y = " + p.y + ", currentHeight = " + currentHeight );
		//command.getDessin().setBounds(((p.x - origine.x)>0)?(p.x - currentWidth):p.x,
		//		   					  ((p.y - origine.y)>0)?(p.y - currentHeight):p.y,
		//							  currentWidth, 
		//							  currentHeight );
		command.getDessin().setBounds(Math.min(p.x, origine.x),
									  Math.min(p.y, origine.y),
									  currentWidth, 
									  currentHeight );
	}

}
