package state.replacedessin;

import gui.ZoneDeDessin;

import java.awt.Point;

import state.State;

import command.Command;
import command.ReplaceDessin;

public class EndReplaceDessin implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		//System.out.println("current x location = " + currentLocation.x + ", current y location = " + currentLocation.y);
		if( currentCommand.getDessin() != null){
			currentCommand.getDessin().setLocation( 
					p.x - ( ( ReplaceDessin ) currentCommand ).getTranslationRatioX(),
					p.y - ( ( ReplaceDessin ) currentCommand ).getTranslationRatioY() );
			currentCommand.setDessin( null );
			( ( ZoneDeDessin ) currentCommand.getPlan() ).setSelected( null );
		}
	}

}
