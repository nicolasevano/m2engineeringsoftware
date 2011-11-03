package shape;
import java.awt.Color;
import java.awt.Graphics;

public class Circle extends EmptyCircle {
	
	public Circle(){
		setOpaque( false );
	}
	
	public Circle( Color color ){
		super.setColor( color );
		setOpaque( false );
	}
	
	@Override
	public void paint( Graphics circle ){
		super.paint( circle );
		circle.setColor( getColor() );
		circle.fillOval( 0, 0, getWidth(), getHeight() );
	}
		
	private static final long serialVersionUID = 1L;

}
