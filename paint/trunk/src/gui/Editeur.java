package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Editeur extends JFrame implements IEditeur {

	public Editeur(){
		
		super( "paint editor" );
		addWindowListener( new Finisher() );
		zoneDessin = new ZoneDeDessin();
		getContentPane().add( BorderLayout.CENTER, zoneDessin );
		shapeSelection = new ShapeSelection( this );
		getContentPane().add( BorderLayout.WEST, shapeSelection );
		colorSelection = new ColorSelection( this );
		getContentPane().add( BorderLayout.EAST, colorSelection );
		commandSelection = new CommandSelection( this );
		getContentPane().add( BorderLayout.SOUTH, commandSelection );
		pack();
		setVisible( true );
		
	}
	
	public static void main( String [] args ){
		
		new Editeur();
		
	}
	
	/* (non-Javadoc)
	 * @see gui.IEditeur#getZoneDessin()
	 */
	public JPanel getZoneDessin() {
		
		return zoneDessin;
		
	}

	/* (non-Javadoc)
	 * @see gui.IEditeur#setZoneDessin(javax.swing.JPanel)
	 */
	public void setZoneDessin(JPanel zoneDessin) {
		
		this.zoneDessin = zoneDessin;
		
	}
	
	class Finisher extends WindowAdapter {

		public void windowClosing(WindowEvent e){
			System.exit( 0 );
		}
		
	}
	
	private JPanel zoneDessin;
	
	private ShapeSelection shapeSelection;
	
	private ColorSelection colorSelection;
	
	private CommandSelection commandSelection;
	
	private static final long serialVersionUID = 1L;
}
