package listener;

import java.awt.Point;
import java.awt.event.MouseAdapter;

import shape.Dessin;

public class RetaillageListener extends MouseAdapter {
	
	public Dessin getCurrentDessin() {
		return currentDessin;
	}
	
	public void setCurrentDessin(Dessin currentDessin) {
		this.currentDessin = currentDessin;
	}
	
	public Dessin currentDessin;
	public Point offsetAbsolu;
    public Point opposeAbsolu;
    public Point departAbsolu;
    
}
