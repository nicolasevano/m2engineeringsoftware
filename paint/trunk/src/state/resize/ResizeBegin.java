package state.resize;

import gui.ZoneDeDessin;

import java.awt.GridLayout;
import java.awt.Point;

import command.Command;
import command.ResizeSelection;

import shape.Dessin;
import state.State;

public class ResizeBegin implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		if(( ( ZoneDeDessin ) currentCommand.getPlan() ).getComponentAt( p ) instanceof Dessin){
			Dessin toMove = ( Dessin )( ( ZoneDeDessin ) currentCommand.getPlan() ).getComponentAt( p );
			( ( ZoneDeDessin )currentCommand.getPlan()).setSelected( toMove );
			currentCommand.setDessin( toMove );
			toMove.setLayout (new GridLayout ( 3,3 ) ) ;
			for (int i = 0 ; i < 9 ; i ++) {
				toMove.add ( ( ( ResizeSelection ) ( currentCommand ) ).getPanels()[i] ) ;
				( ( ResizeSelection ) currentCommand ).getRetaillageListeners()[i].setCurrentDessin( toMove );
		    }
			( ( ResizeSelection ) currentCommand ).resizeInProgress();
			toMove.validate ();
		}
		
	}

}
