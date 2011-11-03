package shape;

import java.awt.Color;
import java.awt.Graphics;

public class RightTriangle extends Dessin {
	
	public RightTriangle(){
		setOpaque( false );
	}
	
	public RightTriangle( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	@Override
	public void paint( Graphics triangle ){
		super.paint( triangle );
		triangle.setColor( getColor() );
		int larg = getWidth();
		int haut = getHeight();
		triangle.drawLine( larg - 1, 0, larg - 1, haut );
		triangle.drawLine( larg, haut, 0, haut/2);
		triangle.drawLine( 0, haut/2, larg, 0);
	}
		
	private static final long serialVersionUID = 1L;
}
