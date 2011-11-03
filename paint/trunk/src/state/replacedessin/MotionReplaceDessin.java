package state.replacedessin;

import java.awt.Point;

import state.State;

import command.Command;
import command.ReplaceDessin;

public class MotionReplaceDessin implements State {

	@Override
	public void draw(Point p, Point origine, Command currentCommand) {
		// TODO Auto-generated method stub
		//System.out.println("current x location = " + currentLocation.x + ", current y location = " + currentLocation.y);
		if( currentCommand.getDessin() != null){
			System.out.println("pointer x location = " + p.x + ", pointer y location = " + p.y);
			System.out.println("x ratio = " + ( ( ReplaceDessin ) currentCommand ).getTranslationRatioX() + ", y ratio = " + ( ( ReplaceDessin ) currentCommand ).getTranslationRatioY());
			currentCommand.getDessin().setLocation( 
					p.x - ( ( ReplaceDessin ) currentCommand ).getTranslationRatioX(),
					p.y - ( ( ReplaceDessin ) currentCommand ).getTranslationRatioY());
		}
	}

}
