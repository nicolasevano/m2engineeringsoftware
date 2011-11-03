package state.drawcircle;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import shape.EmptyCircle;
import state.State;

public class BeginDrawEmptyCircle implements State{

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		System.out.println( "Start draw a new circle." );
		Dessin result = new EmptyCircle(
				( ( ZoneDeDessin ) currentCommand.getPlan() ).getCurrentColor() );
		result.setOrigine( p );
		currentCommand.setDessin( result );
	}

}
