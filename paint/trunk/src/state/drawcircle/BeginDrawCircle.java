package state.drawcircle;

import gui.ZoneDeDessin;

import java.awt.Point;

import shape.Circle;
import shape.Dessin;
import state.State;
import command.Command;

public class BeginDrawCircle implements State{

	@Override
	public void draw( Point p, Point origine, Command command ) {
		// TODO Auto-generated method stub
		System.out.println( "Start draw a new circle." );
		Dessin result = new Circle( ( ( ZoneDeDessin ) command.getPlan()).getCurrentColor() );
		
		System.out.println( "In color : " + ( ( ZoneDeDessin ) command.getPlan()).getCurrentColor() );
		result.setOrigine( p );
		command.setDessin( result );
	}

}
