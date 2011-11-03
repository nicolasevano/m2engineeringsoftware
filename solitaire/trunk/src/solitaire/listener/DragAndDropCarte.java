package solitaire.listener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import solitaire.controler.ICCarte;
import solitaire.view.IPCarte;
import solitaire.view.impl.PCarte;
import solitaire.view.impl.PTasDeCartes;

public class DragAndDropCarte {
	
	public DragAndDropCarte(PTasDeCartes toListen){
		this.source = toListen;
		dsml = new MyDragSourceMotionListener();
		ds = new DragSource();
		mdgl = new MyDragGestureListener();
		ds.createDefaultDragGestureRecognizer(source, DnDConstants.ACTION_MOVE, mdgl);
		dt = new DropTarget(source, new MyDropTargetListener());
		selected = null;
	}
	
	/**
	 * classe permettant de reconnaître le début de la partie "Drag" du Drag'n Drop.
	 */
	protected class MyDragGestureListener implements DragGestureListener {
		@Override
		public void dragGestureRecognized (DragGestureEvent event) {
			selected = null ;
			ICCarte selectedControl = null ;
			theInitialEvent = event ;
			dragOrigin = event.getDragOrigin() ;
			try {
				selected = ( PCarte )source.getComponentAt ( dragOrigin ) ;
				selectedControl = ( ICCarte ) selected.getControl();
			} catch (Exception e) { }
			source.getControl().debutDnDDrag( selectedControl );
		}

	}
	
	/**
	 * classe permettant de gérer la partie "Drag" du Drag'n Drop.
	 */
	protected class MyDragSourceListener implements DragSourceListener {

		@Override
		public void dragEnter (DragSourceDragEvent event) {
			event.getDragSourceContext ().setCursor( new Cursor ( Cursor.MOVE_CURSOR ) ) ;
		}
		
		@Override
		public void dragExit (DragSourceEvent event) {
		}

		@Override
		public void dragOver (DragSourceDragEvent event) {
		}
		
		@Override
		public void dropActionChanged (DragSourceDragEvent event) {
		}

		@Override
		public void dragDropEnd(DragSourceDropEvent dsde) {
			source.getControl().finDnDDrag (selected.getControl(),null, dsde.getDropSuccess()) ;
			source.repaint() ;
			source.setOrigine( false );
		}

	}

	/**
	 *  classe permettant de faire suivre à un anneau sélectionné  le curseur de la souris
	 */
	protected class MyDragSourceMotionListener implements DragSourceMotionListener {
		
		@Override
		public void dragMouseMoved ( DragSourceDragEvent event ) {
			selected.setLocation ( event.getLocation().x - source.getRootPane().getParent().getX (),
					event.getLocation().y - source.getRootPane().getParent().getY() ) ;
		}

	}

	//------------------------------------------------------------------
	// pour le "drop"
	//------------------------------------------------------------------

	/**
	 * classe permettant de gérer la partie "Drop" du Drag'n Drop.
	 */
	protected class MyDropTargetListener implements DropTargetListener {

		protected IPCarte pc = null ;
		
		@Override
		public void dragEnter (DropTargetDragEvent event) {
			try {
				Transferable transferable = event.getTransferable () ;
				if (transferable.isDataFlavorSupported (new DataFlavor (DataFlavor.javaJVMLocalObjectMimeType))) {
					event.acceptDrag (DnDConstants.ACTION_MOVE) ;
					//TODO
					pc = (IPCarte)transferable.getTransferData (new DataFlavor (DataFlavor.javaJVMLocalObjectMimeType)) ;
				}
			} catch (java.io.IOException exception) {
			} catch (UnsupportedFlavorException ufException) {
			} catch (java.lang.ClassNotFoundException e) {
			}
			//TODO
			source.getControl().debutDnDDrag( pc.getControl() ) ;
		}

		@Override
		public void dragExit (DropTargetEvent event) {
			source.setBackground( source.getDefaultColor() );
		}

		@Override
		public void dragOver ( DropTargetDragEvent event ) {
			if( !source.isOrigine() ){
				if( source.getControl().isValideDrop() && source.getControl().isCarteEmpilable( pc.getControl() ) ){
					source.setBackground( Color.green );
				} else {
					source.setBackground( Color.red );
				}
			}
		}

		@Override
		public void drop ( DropTargetDropEvent event ) {
			theFinalEvent = event;
			source.getControl().sortieDnDDrop( pc.getControl() ) ;
			source.setBackground( source.getDefaultColor() );
		}

		@Override
		public void dropActionChanged (DropTargetDragEvent event) {
		}

	}
	
	public void dadc_debutDnDKO(){
		
		//System.out.println( "debut drag and drop KO" );
		
	}
	
	public void dadc_debutDnDOK(ICCarte cc){
		
		ds.startDrag( theInitialEvent, new Cursor ( Cursor.MOVE_CURSOR ), cc.getPresentation(), new MyDragSourceListener() );
		ds.addDragSourceMotionListener( dsml );
		//System.out.println("debut drag and drop OK");
		source.repaint();
		source.setOrigine( true );
	}
	
	public void dadc_finDnDInvalide(){
		
		theFinalEvent.rejectDrop();
		
	}
	
	public void dadc_finDnDValide(){
		
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete( true );
		
	}
	
	protected PCarte selected = null;
	protected DragGestureEvent theInitialEvent ;
	protected MyDragGestureListener mdgl;
	protected DragSource ds;
	protected MyDragSourceMotionListener dsml;
	protected Point dragOrigin = new Point(0, 0);
	protected DropTargetDropEvent theFinalEvent ;
	protected DropTarget dt;
	protected DropTarget dropTarget = null;
	private PTasDeCartes source;
}
