package state.drawtriangle;

import java.awt.Point;

import command.Command;

import state.State;

public class EndDrawTriangle implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		int currentWidth = Math.abs(origine.x - p.x);
		int currentHeight = Math.abs(origine.y - p.y);
		System.out.println( "p.x = " + p.x + ", currentWidth = " + currentWidth );
		System.out.println( "p.y = " + p.y + ", currentHeight = " + currentHeight );
		currentCommand.getDessin().setBounds(Math.min(p.x, origine.x),
									  Math.min(p.y, origine.y),
									  currentWidth, 
									  currentHeight );
	}

}
