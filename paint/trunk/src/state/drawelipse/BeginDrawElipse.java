package state.drawelipse;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import shape.Elipse;
import state.State;

public class BeginDrawElipse implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		System.out.println( "Start draw a new elipse." );
		Dessin result = new Elipse( ( ( ZoneDeDessin ) currentCommand.getPlan()).getCurrentColor() );
		
		System.out.println( "In color : " + ( ( ZoneDeDessin ) currentCommand.getPlan()).getCurrentColor() );
		result.setOrigine( p );
		currentCommand.setDessin( result );
	}

}
