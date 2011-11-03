package solitaire.view.impl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.awt.event.MouseListener;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import solitaire.controler.ICCarte;
import solitaire.controler.ICSabot;
import solitaire.controler.IControlCarteRetournable;
import solitaire.controler.impl.CSabot;
import solitaire.listener.RetourneTasListener;
import solitaire.listener.RetournerCarteListener;
import solitaire.stringloader.IConfigurationLoader;
import solitaire.view.IPCarte;
import solitaire.view.IPSabot;
import solitaire.view.IPTasDeCartes;
import solitaire.view.IUpdateString;

public class PSabot extends JPanel implements IPSabot,IUpdateString{
	
	public PSabot( IPTasDeCartes visible, IPTasDeCartes cache ){
		
		this.cache = cache;
		this.visible = visible;
		setLayout( new FlowLayout() );
		cache.setDxDy( 0, 0 );
		visible.setDxDy( 30, 0 );
		( ( PTasDeCartes ) visible ).setPreferredSize( new Dimension( PCarte.largeur + 750, PCarte.hauteur + 20  ) );
		( ( PTasDeCartes ) visible ).setSize( new Dimension( PCarte.largeur + 750, PCarte.hauteur + 20  ) );
		( ( PTasDeCartes ) visible ).setDefaultColor(Color.cyan);
		( ( PTasDeCartes ) visible ).setBackground(Color.cyan);
		add( ( ( PTasDeCartes ) cache ) );
		add( ( ( PTasDeCartes ) visible ) );
		dsml = new MyDragSourceMotionListener();
		ds = new DragSource();
		dgl = new MyDragGestureListener();
		RCL = new RetournerCarteListener( this );
		RTL = new RetourneTasListener( this );
		this.setPreferredSize( new Dimension( PCarte.largeur + 800, PCarte.hauteur + 60  ) );
		this.setSize( new Dimension( PCarte.largeur + 800, PCarte.hauteur + 60  ) );
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSabot#activerRetournerTasListener()
	 */
	public void activerRetournerTasListener(){
		
		( ( PTasDeCartes ) cache ).addMouseListener( RTL );
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSabot#desactiverRetournerTasListener()
	 */
	public void desactiverRetournerTasListener(){
		
		( ( PTasDeCartes ) cache ).removeMouseListener( RTL );
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSabot#activerRetournerCarteListener()
	 */
	public void activerRetournerCarteListener(){
		
		( ( PTasDeCartes ) cache ).addMouseListener( RCL );
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSabot#desactiverRetournerCarteListener()
	 */
	public void desactiverRetournerCarteListener(){
		
		( ( PTasDeCartes ) cache ).removeMouseListener( RCL );
		
	}
	
	/**
	 * classe permettant de reconnaître le début de la partie "Drag" du Drag'n Drop.
	 */
	protected class MyDragGestureListener implements DragGestureListener {
		@Override
		public void dragGestureRecognized (DragGestureEvent event) {
			ICCarte cc = null;
			try{
				
				Point dragOrigine = event.getDragOrigin();
				IPCarte pc = ( IPCarte )( getComponentAt( dragOrigine ) );
				cc = pc.getControl();
			} catch (Exception e) {
				//System.out.print("Something happen bad on MyDragGestureListener from PSabot");
				//e.printStackTrace();
			}
			theInitialEvent = event;
			control.c2p_debutDnD( cc );
		}

	} // class MyDragGestureListener
	
	/**
	 * classe permettant de gérer la partie "Drag" du Drag'n Drop.
	 */
	protected class MyDragSourceListener implements DragSourceListener {

		public void dragDropEnd1 (DragSourceDropEvent event) {   
			//((ICTourInter)controle).finDnDDrag (selected.getControle (), event.getDropSuccess ()) ;
			repaint () ;
		}
		
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
			// TODO Auto-generated method stub
			
		}

	}

	/**
	 *  classe permettant de faire suivre à un anneau sélectionné  le curseur de la souris
	 */
	protected class MyDragSourceMotionListener implements DragSourceMotionListener {
		
		@Override
		public void dragMouseMoved (DragSourceDragEvent event) {
			selected.setLocation (event.getLocation ().x - getRootPane ().getParent ().getX (),
					event.getLocation ().y - getRootPane ().getParent ().getY ()) ;
		}

	}

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
					pc = ( IPCarte ) transferable.getTransferData (new DataFlavor (DataFlavor.javaJVMLocalObjectMimeType)) ;
				}
			} catch (java.io.IOException exception) {
			} catch (UnsupportedFlavorException ufException) {
			} catch (java.lang.ClassNotFoundException e) {
			}
		}

		@Override
		public void dragExit (DropTargetEvent event) {
		}

		@Override
		public void dragOver (DropTargetDragEvent event) {
		}

		@Override
		public void drop (DropTargetDropEvent event) {
			theFinalEvent = event;
			( ( ( IPCarte ) pc ).getControl()).finDnD ( (ICCarte) pc.getControl() ) ;
		}

		@Override
		public void dropActionChanged (DropTargetDragEvent event) {
		}

	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSabot#c2p_debutDnDKO()
	 */
	public void c2p_debutDnDKO(){
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSabot#c2p_debutDnD(solitaire.view.PCarte)
	 */
	public void c2p_debutDnD(PCarte pc){
		ds.startDrag(theInitialEvent, new Cursor ( Cursor.MOVE_CURSOR ), pc , new MyDragSourceListener() );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPSabot#setControl(solitaire.controler.CSabot)
	 */
	public void setControl(CSabot csabot) {
		this.control = csabot;
	}
	
	
	@Override
	public IControlCarteRetournable getControl(){
		return control;
	}
	
	@Override
	public void updateString(){
		Properties property = configuration.getProperties();
		Border line = BorderFactory.createLineBorder( Color.blue, 1);
		( ( PTasDeCartes ) cache ).setToolTipText(property.getProperty("sabot.cachee.tooltip", 
				"Cliqué ici pour remplir la reserve quand elle est vide ou retourner 3 cartes." ) );
		( ( PTasDeCartes ) visible ).setToolTipText(property.getProperty("sabot.visible.tooltip",
				"selectionné une carte visible pour la placer dans une colonne ou un tas coloré"));
		TitledBorder panelBorder = BorderFactory.createTitledBorder(line, property.getProperty("sabot.main.tittle","main"));
	    ( ( PTasDeCartes ) visible ).setBorder( panelBorder );
	    panelBorder = BorderFactory.createTitledBorder(line, property.getProperty("sabot.reserve.tittle","réserve"));
	    ( ( PTasDeCartes ) cache ).setBorder( panelBorder );
	    panelBorder = BorderFactory.createTitledBorder(line, property.getProperty("sabot.tittle"," Sabot "));
	    this.setBorder( panelBorder );
	}
	
	public void setConfiguration(IConfigurationLoader configuration) {
		this.configuration = configuration;
	}
	
	protected PCarte selected = null;
	protected DragGestureEvent theInitialEvent ;
	protected Point dragOrigin = new Point(0, 0);
	protected DropTarget dropTarget = null ;
	protected DropTargetDropEvent theFinalEvent ;
	
	private IConfigurationLoader configuration;
	private DragSource ds;
	private MyDragSourceMotionListener dsml;
	private MyDragGestureListener dgl;
	private IPTasDeCartes cache;
	private IPTasDeCartes visible;
	private MouseListener RTL;
	private MouseListener RCL;
	private ICSabot control;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
