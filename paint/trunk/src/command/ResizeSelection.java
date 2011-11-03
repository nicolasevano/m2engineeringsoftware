package command;

import gui.ZoneDeDessin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import listener.RetaillageListener;

import state.State;
import state.resize.ResizeBegin;
import state.resize.ResizeEnd;
import state.resize.ResizeMotion;

public class ResizeSelection extends Command {

	public ResizeSelection( JButton toManageColor ) {
		super( new State[]{
				new ResizeBegin(),
				new ResizeMotion(),
				new ResizeEnd()
				} );
		panels = new JPanel [9] ;
		for (int i = 0 ; i < 9 ; i ++) {
			panels [i] = new JPanel () ;
			panels [i].addMouseListener (retaillageListeners [i]) ;
			panels [i].addMouseMotionListener (retaillageListeners [i]) ;
			panels [i].setCursor (cursors [i]) ;
			panels [i].setOpaque (false) ;
		}
		this.toManage = toManageColor;
		// TODO Auto-generated constructor stub
	}

	public void resizeInProgress(){
		toManageNormalColor = toManage.getBackground();
		toManageNormalLabel = toManage.getText();
		toManage.setText("Cliquez moi pour valider la nouvelle taille!");
		toManage.setBackground( Color.cyan );
	}
	
	public JPanel[] getPanels() {
		return panels;
	}

	public void setPanels(JPanel[] panels) {
		this.panels = panels;
	}

	@Override
	public void execute(MouseWheelEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public RetaillageListener[] getRetaillageListeners() {
		return retaillageListeners;
	}

	public void setRetaillageListeners(RetaillageListener[] retaillageListeners) {
		this.retaillageListeners = retaillageListeners;
	}

	public Cursor[] getCursors() {
		return cursors;
	}

	public void setCursors(Cursor[] cursors) {
		this.cursors = cursors;
	}

	@SuppressWarnings("deprecation")
	public void endResize(){
		if( getDessin() != null ){
			getDessin().removeAll () ;
			getDessin().validate () ;
		}
		( ( ZoneDeDessin )getPlan()).setSelected( null );
		setDessin( null );
		toManage.setBackground( toManageNormalColor );
		toManage.setLabel( toManageNormalLabel );
	}
	
	class RetaillageNWListener extends RetaillageListener {

		@Override
		public void mousePressed (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			offsetAbsolu = new Point (- p.x, - p.y) ;
			opposeAbsolu = new Point (getDessin().getX () + p.x, getDessin().getY () + p.y) ;
			departAbsolu = new Point (getDessin().getX () + getDessin().getWidth (),
					getDessin().getY () + getDessin().getHeight ()) ;
		}        

		@Override
		public void mouseDragged (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			opposeAbsolu.x = getDessin().getX () + p.x + offsetAbsolu.x ;
			opposeAbsolu.y = getDessin().getY () + p.y + offsetAbsolu.y ;
			getDessin().setBounds (Math.min (departAbsolu.x, opposeAbsolu.x),
					Math.min (departAbsolu.y, opposeAbsolu.y),
					Math.abs (Math.max (departAbsolu.x - opposeAbsolu.x, 0)),
					Math.abs (Math.max (departAbsolu.y - opposeAbsolu.y, 0))) ;
			getDessin().validate () ;
		}

	}

	class RetaillageNListener extends RetaillageListener {

		@Override
		public void mousePressed (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			offsetAbsolu = new Point (0, - p.y) ;
			opposeAbsolu = new Point (getDessin().getX (), getDessin().getY () + p.y) ;
			departAbsolu = new Point (getDessin().getX () + getDessin().getWidth (), getDessin().getY () + getDessin().getHeight ()) ;    
		}

		@Override
		public void mouseDragged (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			opposeAbsolu.y = getDessin().getY () + p.y + offsetAbsolu.y ;
			getDessin().setBounds (Math.min (departAbsolu.x, opposeAbsolu.x),
					Math.min (departAbsolu.y, opposeAbsolu.y),
					Math.abs (opposeAbsolu.x - departAbsolu.x),
					Math.abs (Math.max (departAbsolu.y - opposeAbsolu.y, 0))) ;
			getDessin().validate () ;
		}      

	}

	class RetaillageNEListener extends RetaillageListener {

		@Override
		public void mousePressed (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			offsetAbsolu = new Point (getDessin().getWidth () - p.x, - p.y) ;
			opposeAbsolu = new Point (getCurrentDessin().getX () + p.x, getCurrentDessin().getY () + p.y) ;
			departAbsolu = new Point (getCurrentDessin().getX (), getCurrentDessin().getY () + getCurrentDessin().getHeight ()) ;
		}

		@Override
		public void mouseDragged (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			opposeAbsolu.x = getCurrentDessin().getX () + p.x + offsetAbsolu.x ;
			opposeAbsolu.y = getCurrentDessin().getY () + p.y + offsetAbsolu.y ;
			getCurrentDessin().setBounds (Math.min (departAbsolu.x, opposeAbsolu.x),
					Math.min (departAbsolu.y, opposeAbsolu.y),
					Math.abs (Math.max (opposeAbsolu.x - departAbsolu.x, 0)),
					Math.abs (Math.max (departAbsolu.y - opposeAbsolu.y, 0))) ;

			getCurrentDessin().validate () ;
		}      

	}

	class RetaillageWListener extends RetaillageListener {

		@Override
		public void mousePressed (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			offsetAbsolu = new Point (- p.x, 0) ;
			opposeAbsolu = new Point (getCurrentDessin().getX () + p.x, getCurrentDessin().getY ()) ;
			departAbsolu = new Point (getCurrentDessin().getX () + getCurrentDessin().getWidth (),
					getCurrentDessin().getY () + getCurrentDessin().getHeight ()) ;
		}


		@Override
		public void mouseDragged (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			opposeAbsolu.x = getCurrentDessin().getX () + p.x + offsetAbsolu.x ;
			getCurrentDessin().setBounds (Math.min (departAbsolu.x, opposeAbsolu.x),
					Math.min (departAbsolu.y, opposeAbsolu.y),
					Math.abs (Math.max (departAbsolu.x - opposeAbsolu.x, 0)),
					Math.abs (opposeAbsolu.y - departAbsolu.y)) ;
			getCurrentDessin().validate () ;
		}

	}


	class RetaillageCListener extends RetaillageListener {

	}

	class RetaillageEListener extends RetaillageListener {

		@Override
		public void mousePressed (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			offsetAbsolu = new Point (getCurrentDessin().getWidth () - p.x, 0) ;
			opposeAbsolu = new Point (getCurrentDessin().getX () + p.x, getCurrentDessin().getY () + getCurrentDessin().getHeight ()) ;
			departAbsolu = new Point (getCurrentDessin().getX (), getCurrentDessin().getY ()) ;
		}

		@Override
		public void mouseDragged (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			opposeAbsolu.x = getCurrentDessin().getX () + p.x + offsetAbsolu.x ;
			getCurrentDessin().setBounds (Math.min (departAbsolu.x, opposeAbsolu.x),
					Math.min (departAbsolu.y, opposeAbsolu.y),
					Math.abs (Math.max (opposeAbsolu.x - departAbsolu.x, 0)),
					Math.abs (opposeAbsolu.y - departAbsolu.y)) ;
			getCurrentDessin().validate () ;
		}      

	}


	class RetaillageSWListener extends RetaillageListener {

		@Override
		public void mousePressed (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			offsetAbsolu = new Point (- p.x, getCurrentDessin().getHeight () - p.y) ;
			opposeAbsolu = new Point (getCurrentDessin().getX () + p.x , getCurrentDessin().getY () + p.y) ;
			departAbsolu = new Point (getCurrentDessin().getX () + getCurrentDessin().getWidth (), getCurrentDessin().getY ()) ;
			getCurrentDessin().validate () ;
			getCurrentDessin().revalidate () ;
		}

		@Override
		public void mouseDragged (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			opposeAbsolu.x = getCurrentDessin().getX () + p.x + offsetAbsolu.x ;
			opposeAbsolu.y = getCurrentDessin().getY () + p.y + offsetAbsolu.y ;
			getCurrentDessin().setBounds (Math.min (departAbsolu.x, opposeAbsolu.x),
					Math.min (departAbsolu.y, opposeAbsolu.y),
					Math.abs (Math.max (departAbsolu.x - opposeAbsolu.x, 0)),
					Math.abs (Math.max (opposeAbsolu.y - departAbsolu.y, 0))) ;
			getCurrentDessin().validate () ;
		}      

	}

	class RetaillageSListener extends RetaillageListener {

		@Override
		public void mousePressed (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			offsetAbsolu = new Point (0, getCurrentDessin().getHeight () - p.y) ;
			opposeAbsolu = new Point (getCurrentDessin().getX () + getCurrentDessin().getWidth (), getCurrentDessin().getY () + p.y) ;
			departAbsolu = new Point (getCurrentDessin().getX (), getCurrentDessin().getY ()) ;
			getCurrentDessin().validate () ;
		}


		@Override
		public void mouseDragged (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			opposeAbsolu.y = getCurrentDessin().getY () + p.y + offsetAbsolu.y ;
			getCurrentDessin().setBounds (Math.min (departAbsolu.x, opposeAbsolu.x),
					Math.min (departAbsolu.y, opposeAbsolu.y),
					Math.abs (opposeAbsolu.x - departAbsolu.x),
					Math.abs (Math.max (opposeAbsolu.y - departAbsolu.y, 0))) ;
			getCurrentDessin().validate () ;
		}      

	}

	class RetaillageSEListener extends RetaillageListener {

		private Point offsetAbsolu ;
		private Point opposeAbsolu ;
		private Point departAbsolu ;

		@Override
		public void mousePressed (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			offsetAbsolu = new Point (getCurrentDessin().getWidth () - p.x, getCurrentDessin().getHeight () - p.y) ;
			opposeAbsolu = new Point (getCurrentDessin().getX () + p.x, getCurrentDessin().getY () + p.y) ;
			departAbsolu = new Point (getCurrentDessin().getX (), getCurrentDessin().getY ()) ;
		}

		@Override
		public void mouseDragged (MouseEvent e) {
			e.translatePoint (((JPanel)e.getSource()).getX (), ((JPanel)e.getSource()).getY ()) ;
			Point p = e.getPoint () ;
			opposeAbsolu.x = getCurrentDessin().getX () + p.x + offsetAbsolu.x ;
			opposeAbsolu.y = getCurrentDessin().getY () + p.y + offsetAbsolu.y ;
			getCurrentDessin().setBounds (Math.min (departAbsolu.x, opposeAbsolu.x),
					Math.min (departAbsolu.y, opposeAbsolu.y),
					Math.abs (Math.max (opposeAbsolu.x - departAbsolu.x, 0)),
					Math.abs (Math.max (opposeAbsolu.y - departAbsolu.y, 0))) ;
			getCurrentDessin().validate () ;
		}      

	}
	
	// parce qu'on peut sortir et rentrer en cours d'interaction,
	// et qu'on ne veut pas retailler dans tous les sens à la fois ...
	// d'où l'utilisation du booléen de la classe Dessin
	// pour ne pas changer le curseur tout le temps ...
	// en particulier lorsque l'on passe au dessus d'un autre Dessin

	private RetaillageListener retaillageListeners [] = {
			new RetaillageNWListener (),
			new RetaillageNListener (),
			new RetaillageNEListener (),
			new RetaillageWListener (),
			new RetaillageCListener (),
			new RetaillageEListener (),
			new RetaillageSWListener (),
			new RetaillageSListener (),
			new RetaillageSEListener ()
	} ;
	
	private Cursor cursors [] = {
			Cursor.getPredefinedCursor (Cursor.NW_RESIZE_CURSOR),
			Cursor.getPredefinedCursor (Cursor.N_RESIZE_CURSOR),
			Cursor.getPredefinedCursor (Cursor.NE_RESIZE_CURSOR),
			Cursor.getPredefinedCursor (Cursor.W_RESIZE_CURSOR),
			Cursor.getPredefinedCursor (Cursor.WAIT_CURSOR),
			Cursor.getPredefinedCursor (Cursor.E_RESIZE_CURSOR),
			Cursor.getPredefinedCursor (Cursor.SW_RESIZE_CURSOR),
			Cursor.getPredefinedCursor (Cursor.S_RESIZE_CURSOR),
			Cursor.getPredefinedCursor (Cursor.SE_RESIZE_CURSOR)
	} ;
	
	private JPanel panels [] ;
	
	private JButton toManage;
	private Color toManageNormalColor;
	private String toManageNormalLabel;
	
}
