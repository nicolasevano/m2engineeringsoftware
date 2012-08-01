package com.sodifrance.jsf;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;

public class ValeurChangeListener implements javax.faces.event.ValueChangeListener{

	public ValeurChangeListener(Nombre nombre){
		this.nombre = nombre;
	}
	
	@Override
	public void processValueChange(ValueChangeEvent arg0)
			throws AbortProcessingException {
				nombre.setValeur( Integer.valueOf( ( String ) arg0.getNewValue() ) );
				nombre.fini();
	}
	
	public Nombre getNombre() {
		return nombre;
	}

	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}
	
	private Nombre nombre;

}
