package command;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

import shape.Dessin;
import state.State;

public abstract class Command {
	
	public Command(State [] states){
		System.out.println("New Command!");
		this.states = states;
		currentState = 0;
	}
	
	public void execute(Point p){
		states[ currentState ].draw( p, (dessin != null)? dessin.getOrigine() : null, this );
	}
	
	public abstract void execute( MouseWheelEvent mouseEvent);
	
	public void setPlan(JPanel currentPlan){
		this.currentPlan  = currentPlan;
	}
	
	public JPanel getPlan(){
		return currentPlan;
	}
	
	public void setDessin(Dessin dessin) {
		this.dessin = dessin;
	}

	public Dessin getDessin() {
		return dessin;
	}
	
	public boolean isWheelMouse() {
		return wheelMouse;
	}

	public void setWheelMouse(boolean wheelMouse) {
		this.wheelMouse = wheelMouse;
	}

	
	public State nextState(){
		State result;
		
		if( currentState < ( states.length - 1 ) ){
			result = states[ currentState++ ];
		} else {
			currentState = 0;
			result = states[ currentState ];
		}
		return result;
	}
	
	private boolean wheelMouse = false;
	
	private Dessin dessin;
	
	private JPanel currentPlan;
	
	private State []states;
	
	int currentState;

}
