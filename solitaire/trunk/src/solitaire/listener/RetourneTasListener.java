package solitaire.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import solitaire.controler.ICSabot;
import solitaire.view.IPSabot;

public class RetourneTasListener implements MouseListener {

	public RetourneTasListener( IPSabot pSabot){
		this.presentation = pSabot;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		try{
			( ( ICSabot )presentation.getControl() ).setReserve();
		} catch(Exception e) {
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
	private IPSabot presentation; 
}
