package state.zoom;

import gui.ZoneDeDessin;

import java.awt.Point;

import command.Command;

import state.State;

public class EndZoom implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		( ( ZoneDeDessin )currentCommand.getPlan()).setSelected( null );
		currentCommand.setDessin( null );
	}

}
