package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Dessin {
	public Triangle(){
		setOpaque( false );
	}
	
	public Triangle( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	@Override
	public void paint( Graphics triangle ){
		super.paint( triangle );
		triangle.setColor( getColor() );
		int larg = getWidth();
		int haut = getHeight();
		triangle.drawLine(0,haut - 1,larg, haut - 1);
		triangle.drawLine(0,haut,larg/2, haut/2);
		triangle.drawLine(larg/2, haut/2,larg, haut);
	}
		
	private static final long serialVersionUID = 1L;
}
