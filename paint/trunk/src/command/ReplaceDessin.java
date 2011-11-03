package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import state.State;
import state.replacedessin.BeginReplaceDessin;
import state.replacedessin.EndReplaceDessin;
import state.replacedessin.MotionReplaceDessin;

public class ReplaceDessin extends Command {
	
	//TODO define constructor with out argument
	public ReplaceDessin(){
		super( new State[]{
				new BeginReplaceDessin(),
				new MotionReplaceDessin(),
				new EndReplaceDessin()
				} );
		// TODO Auto-generated constructor stub
	}
	
	public void execute( Point p ){
		System.out.println( "Replace a Dessin." );
		super.execute( p );
	}

	public int getTranslationRatioX() {
		return translationRatioX;
	}

	public void setTranslationRatioX(int translationRatioX) {
		this.translationRatioX = translationRatioX;
	}

	public int getTranslationRatioY() {
		return translationRatioY;
	}

	public void setTranslationRatioY(int translationRationY) {
		this.translationRatioY = translationRationY;
	}
	
	private int translationRatioX;
	
	private int translationRatioY;

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

}
