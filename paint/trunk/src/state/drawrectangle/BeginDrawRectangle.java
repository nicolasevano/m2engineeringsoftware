package state.drawrectangle;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import shape.Rectangle;
import state.State;

public class BeginDrawRectangle implements State {

	@Override
	public void draw( Point p, Point origine, Command command ) {
		// TODO Auto-generated method stub
		Dessin result;
		System.out.println( "Start draw a new rectangle!" );
		//StringBuilder toTrace = new StringBuilder();
		//currentBeginning = p;
		//currentWidth = 0;
		result = new Rectangle( ( ( ZoneDeDessin ) command.getPlan() ).getCurrentColor());
		result.setOrigine( p );
		//add( currentRectangle );
		//nbShape++;
		//toTrace.append( "Create Rectangle number: \"" ).append( nbShape ).append( "\"." );
		//System.out.println( toTrace );
		command.setDessin( result );
	}

}
