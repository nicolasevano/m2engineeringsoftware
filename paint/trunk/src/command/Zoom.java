package command;

import java.awt.event.MouseWheelEvent;

import state.State;
import state.zoom.BeginZoom;
import state.zoom.EndZoom;
import state.zoom.MotionZoom;

public class Zoom extends Command{

	public Zoom(){
		
		super( new State[]{
				new BeginZoom(),
				new MotionZoom(),
				new EndZoom()
				} );
		
	}
	
	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		 int order = getDessin().getParent ().getComponentZOrder (getDessin()) ;
	     int newOrder = Math.min (getDessin().getParent ().getComponentCount() - 1, Math.max (0, order - mouseEvent.getWheelRotation ())) ;
	     getDessin().getParent ().setComponentZOrder (getDessin(), newOrder) ;
	     getDessin().getParent ().repaint () ;
	}

}
