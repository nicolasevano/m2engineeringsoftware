package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import command.Command;

import listener.DessinListener;
import listener.DessinMotionListener;
import listener.DragZoneDessinGestureListener;
import listener.DragZoneDessinListener;
import listener.ZoneDeDessinDropTargetListener;

import shape.Dessin;

public class ZoneDeDessin extends JPanel implements IZoneDeDessin{
	
	/**
	 * constructor
	 */
	public ZoneDeDessin(){
		
		//nbShape = 0;
		
		setPreferredSize( new Dimension( 800,600 ) );
		zDDDTL = new ZoneDeDessinDropTargetListener();
		zDDDTL.setZoneDessin(this);
		dropTarget = new DropTarget( this, zDDDTL );
		//TODO One listener can done each of this both instantiation.
		aDL = new DessinListener();
		aDML = new DessinMotionListener();
		
		addMouseListener( aDL );
		addMouseMotionListener( aDML );
		cDL = new DragZoneDessinListener();
		cDL.setZoneDessin( this );
		dragSource = new DragSource();
		cDZDGL = new DragZoneDessinGestureListener();
		cDZDGL.setZoneDessin(this);
		dragSource.createDefaultDragGestureRecognizer(this, 
													  DnDConstants.ACTION_MOVE, 
													  cDZDGL
													  );
		
		setBackground( Color.white );
		setDropTarget( dropTarget );
		//no windows manager circle have to stay where user put it!
		setLayout( null );
	}
	
	public Command getCurrentCommand() {
		return currentCommand;
		
	}
	
	public void stopCreateShapeMode(){
		removeMouseListener( aDL );
		removeMouseMotionListener( aDML );
	}
	
	public void startCreateShapeMode(){
		addMouseListener( aDL );
		addMouseMotionListener( aDML );
	}

	public void setCurrentCommand(Command currentCommand) {
		
		this.currentCommand = currentCommand;
		( ( DessinListener ) aDL ).setCurrentCommand( currentCommand );
		( ( DessinMotionListener ) aDML ).setCurrentCommand( currentCommand );
		
	}
	
	public Dessin getSelected() {
		return selected;
	}

	public void setSelected(Dessin selected) {
		this.selected = selected;
	}
	
	public DragGestureEvent getInitialEvent() {
		return initialEvent;
	}

	public void setInitialEvent(DragGestureEvent initialEvent) {
		this.initialEvent = initialEvent;
	}
	
	public Border getRaisedbevel() {
		return raisedbevel;
	}
	
	public Border getLoweredbevel() {
		return loweredbevel;
	}
	
	public DragSource getDragSource() {
		return dragSource;
	}
	
	public DragZoneDessinListener getCDL() {
		return cDL;
	}
	
	public void addElement(Object o){
		
		add( ( Dessin ) o);
		validate();
		repaint();
		
	}
	
	public void drop(DropTargetDropEvent event){
		try{
			Transferable transferable = event.getTransferable();
			System.out.println( "detected transferable" );
			if( event.isLocalTransfer() ){
				if(transferable.isDataFlavorSupported(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType))){
					System.out.println( "transfert local" );
					event.acceptDrop( DnDConstants.ACTION_MOVE );
					Dessin toDrop = (Dessin) transferable.getTransferData(
							new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
					addElement( toDrop );
					event.getDropTargetContext().dropComplete(true);
				} else { // transfert non local
					if(transferable.isDataFlavorSupported(new DataFlavor(Dessin.class,null))){
						System.out.println( "transfert sérialisé" );
						event.acceptDrop( DnDConstants.ACTION_MOVE );
						Dessin toDrop = 
							(Dessin) transferable.getTransferData(
									new DataFlavor(Dessin.class,null));
						addElement(toDrop);
						event.getDropTargetContext().dropComplete(true);
					} else {
						event.rejectDrop();
					}
				} 
			}
		} catch( IOException ioe ) {
			ioe.printStackTrace();
			event.rejectDrop();
		} catch( UnsupportedFlavorException ufe ) {
			ufe.printStackTrace();
			event.rejectDrop();
		} catch ( java.lang.ClassNotFoundException cnfe ) {
			cnfe.printStackTrace();
			event.rejectDrop();
		}
	}
	
	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}
	
	/**mouse listener used to defined origin point of current shape*/
	protected MouseListener aDL;
	
	/**mouse dragged listener used to compute motion of the current shape */
	protected MouseMotionListener aDML;
	
	protected DragZoneDessinListener cDL;
	
	protected DragZoneDessinGestureListener cDZDGL;
	
	protected Command currentCommand;
	
	protected ZoneDeDessinDropTargetListener zDDDTL;
	
	protected DropTarget dropTarget;
	
	private Dessin selected;
	
	private DragGestureEvent initialEvent;
	
	private DragSource dragSource;
	
	private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	
	private static final long serialVersionUID = 1L;
	
	private Color currentColor = Color.BLUE;

}
