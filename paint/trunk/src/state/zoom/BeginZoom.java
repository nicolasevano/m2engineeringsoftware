package state.zoom;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import state.State;

public class BeginZoom implements State{

	@Override
	public void draw( Point p, Point origine, Command currentCommand ) {
		// TODO Auto-generated method stub
		if(( ( ZoneDeDessin ) currentCommand.getPlan() ).getComponentAt( p ) instanceof Dessin){
			Dessin toMove = ( Dessin )( ( ZoneDeDessin ) currentCommand.getPlan() ).getComponentAt( p );
			( ( ZoneDeDessin )currentCommand.getPlan()).setSelected( toMove );
			currentCommand.setDessin( toMove );
		}
	}

}
