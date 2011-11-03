package state.drawcircle;

import java.awt.Point;

import state.State;
import command.Command;

public class EndDrawCircle implements State{

	@Override
	public void draw( Point p, Point origine, Command command ) {
		// TODO Auto-generated method stub
		int dx = origine.x - p.x;
		int dy = origine.y - p.y;
		int currentRadius = (int)Math.sqrt( dx* dx + dy * dy );
		command.getDessin().setBounds( origine.x - currentRadius,
				        			   origine.y - currentRadius,
				        			   currentRadius * 2,
				        			   currentRadius * 2 );
		
	}

}
