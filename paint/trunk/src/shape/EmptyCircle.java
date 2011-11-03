package shape;

import java.awt.Color;
import java.awt.Graphics;

public class EmptyCircle extends Dessin {
	
	public EmptyCircle(){
		setOpaque( false );
	}
	
	public EmptyCircle( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	@Override
	public void paint( Graphics circle ){
		super.paint( circle );
		circle.setColor( getColor() );
		circle.drawOval( 0, 0, getWidth() - 1, getHeight() - 1 );
	}
	
	public void paintComponent(Graphics g){
		//ici, mon code de surcharge
		super.paintComponent(g);
		}
	
	private static final long serialVersionUID = 1L;
}
