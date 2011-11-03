package state.drawtriangle;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import shape.LeftTriangle;
import state.State;

public class BeginDrawLeftTriangle implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		Dessin result;
		System.out.println( "Start draw a new triangle!" );
		result = new LeftTriangle( ( ( ZoneDeDessin ) currentCommand.getPlan() ).getCurrentColor());
		result.setOrigine( p );
		currentCommand.setDessin( result );
	}

}
