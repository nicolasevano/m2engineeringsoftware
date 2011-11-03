package state.remove;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import shape.Dessin;
import state.State;

public class RemoveDessin implements State{

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		Dessin toRemove;
		if(( ( ZoneDeDessin ) currentCommand.getPlan() ).getComponentAt( p ) instanceof Dessin){
			toRemove = (Dessin)( ( ZoneDeDessin ) currentCommand.getPlan() ).getComponentAt( p );
			( ( ZoneDeDessin ) currentCommand.getPlan() ).remove( toRemove );
			( ( ZoneDeDessin ) currentCommand.getPlan() ).repaint();
		}
	}

}
