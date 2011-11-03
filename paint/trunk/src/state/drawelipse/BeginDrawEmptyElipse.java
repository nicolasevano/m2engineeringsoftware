package state.drawelipse;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import shape.EmptyElipse;
import state.State;

public class BeginDrawEmptyElipse implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		System.out.println( "Start draw a new empty elipse." );
		Dessin result = new EmptyElipse(
				( ( ZoneDeDessin ) currentCommand.getPlan() ).getCurrentColor() );
		result.setOrigine( p );
		currentCommand.setDessin( result );
	}

}
