package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends EmptyRectangle implements IDessin{

	public Rectangle(){
		setOpaque( false );
	}
	
	public Rectangle( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	
	
	@Override
	public void paint( Graphics rectangle ) {
		super.paint( rectangle );
		rectangle.setColor( getColor() );
		rectangle.fillRect( 0, 0, getWidth(), getHeight() );
	}
	
	public void paintComponent(Graphics g){
		//ici, mon code de surcharge
		super.paintComponent(g);
	}
	
	private static final long serialVersionUID = 1L;
}
