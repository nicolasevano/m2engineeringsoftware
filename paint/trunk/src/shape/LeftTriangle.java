package shape;

import java.awt.Color;
import java.awt.Graphics;

public class LeftTriangle extends Dessin{
	public LeftTriangle(){
		setOpaque( false );
	}
	
	public LeftTriangle( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	@Override
	public void paint( Graphics triangle ){
		super.paint( triangle );
		triangle.setColor( getColor() );
		int larg = getWidth();
		int haut = getHeight();
		triangle.drawLine( 0, 0, 0, haut );
		triangle.drawLine( 0, 0, larg, haut/2);
		triangle.drawLine( larg, haut/2, 0, haut);
	}
		
	private static final long serialVersionUID = 1L;
}
