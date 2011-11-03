package shape;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyRectangle extends Dessin {
	
	public EmptyRectangle(){
		setOpaque( false );
	}
	
	public EmptyRectangle( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	public void paint( Graphics rectangle ) {
		super.paint( rectangle );
		rectangle.setColor( getColor() );
		rectangle.drawRect( 0, 0, getWidth() - 1, getHeight() - 1 );
	}
	
	public void paintComponent(Graphics g){
		//ici, mon code de surcharge
		super.paintComponent(g);
		}
	
	private static final long serialVersionUID = 1L;
	
}
