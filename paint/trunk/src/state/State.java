package state;

import java.awt.Point;

import command.Command;

public interface State {
	public void draw( Point p, Point origine, Command currentCommand );
}
