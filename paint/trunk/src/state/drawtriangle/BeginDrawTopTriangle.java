package state.drawtriangle;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import shape.TopTriangle;
import state.State;

public class BeginDrawTopTriangle implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		Dessin result;
		System.out.println( "Start draw a new triangle!" );
		result = new TopTriangle( ( ( ZoneDeDessin ) currentCommand.getPlan() ).getCurrentColor());
		result.setOrigine( p );
		currentCommand.setDessin( result );
	}

}
