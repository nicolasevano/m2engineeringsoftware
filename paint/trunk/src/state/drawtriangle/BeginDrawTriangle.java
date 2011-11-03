package state.drawtriangle;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import shape.Triangle;
import state.State;

public class BeginDrawTriangle implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		Dessin result;
		System.out.println( "Start draw a new triangle!" );
		result = new Triangle( ( ( ZoneDeDessin ) currentCommand.getPlan() ).getCurrentColor());
		result.setOrigine( p );
		currentCommand.setDessin( result );
	}

}
