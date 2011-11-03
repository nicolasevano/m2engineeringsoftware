package shape;

import java.awt.Color;
import java.awt.Graphics;

public class TopTriangle extends Dessin {
	public TopTriangle(){
		setOpaque( false );
	}
	
	public TopTriangle( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	@Override
	public void paint( Graphics triangle ){
		super.paint( triangle );
		triangle.setColor( getColor() );
		int larg = getWidth();
		int haut = getHeight();
		triangle.drawLine( 0 , 0 , larg, 0 );
		triangle.drawLine( larg, 0, larg / 2, haut);
		triangle.drawLine( larg / 2, haut, 0, 0);
	}
		
	private static final long serialVersionUID = 1L;
}
