package state.drawrectangle;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import shape.EmptyRectangle;
import state.State;

public class BeginDrawEmptyRectangle implements State{

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Dessin result;
		System.out.println( "Start draw a new empty rectangle!" );
		//StringBuilder toTrace = new StringBuilder();
		//currentBeginning = p;
		//currentWidth = 0;
		result = new EmptyRectangle( 
				( ( ZoneDeDessin ) currentCommand.getPlan() ).getCurrentColor() );
		result.setOrigine( p );
		//add( currentRectangle );
		//nbShape++;
		//toTrace.append( "Create Rectangle number: \"" ).append( nbShape ).append( "\"." );
		//System.out.println( toTrace );
		currentCommand.setDessin( result );
	}

}
