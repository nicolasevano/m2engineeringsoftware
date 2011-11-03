package state.replacedessin;

import gui.ZoneDeDessin;

import java.awt.Point;

import shape.Dessin;
import state.State;

import command.Command;
import command.ReplaceDessin;

public class BeginReplaceDessin implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		if(( ( ZoneDeDessin ) currentCommand.getPlan() ).getComponentAt( p ) instanceof Dessin){
			Dessin toMove = (Dessin)( ( ZoneDeDessin ) currentCommand.getPlan() ).getComponentAt( p );
			( ( ZoneDeDessin )currentCommand.getPlan()).setSelected( toMove );
			currentCommand.setDessin( toMove );
			( ( ReplaceDessin ) currentCommand ).setTranslationRatioX( p.x - toMove.getLocation().x );
			( ( ReplaceDessin ) currentCommand ).setTranslationRatioY( p.y - toMove.getLocation().y );
		}
	}

}
