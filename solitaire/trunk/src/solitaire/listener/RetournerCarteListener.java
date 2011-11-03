package solitaire.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import solitaire.view.IViewDoubleTas;

public class RetournerCarteListener implements MouseListener {
	
	public RetournerCarteListener(IViewDoubleTas presentation){
		this.presentation = presentation;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		try{
			presentation.getControl().retournerCarte();
		} catch(Exception e) {
			//Nothing to 
			//or add semantic control counter if user click too much cart tell him to click on
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	private IViewDoubleTas presentation;
}
