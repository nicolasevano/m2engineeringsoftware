package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Elipse extends Dessin{
	
	public Elipse(){
		setOpaque( false );
	}
	
	public Elipse( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	@Override
	public void paint( Graphics elipse ){
		super.paint( elipse );
		elipse.setColor( getColor() );
		elipse.fillOval( 0, 0, getWidth(), getHeight() );
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
