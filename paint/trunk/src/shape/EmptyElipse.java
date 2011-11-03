package shape;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyElipse extends Dessin {
	
	public EmptyElipse(){
		setOpaque( false );
	}
	
	public EmptyElipse( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	@Override
	public void paint( Graphics emptyElipse ){
		super.paint( emptyElipse );
		emptyElipse.setColor( getColor() );
		emptyElipse.drawOval( 0, 0, getWidth() - 1, getHeight() -1 );
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
