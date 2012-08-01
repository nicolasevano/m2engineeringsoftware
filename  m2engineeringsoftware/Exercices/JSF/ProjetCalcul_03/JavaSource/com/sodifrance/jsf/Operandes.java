package com.sodifrance.jsf;

import java.util.ArrayList;
import java.util.List;

public class Operandes {

	public Operandes(){
		
		listOp = new ArrayList<Operande>();
		
	}
	
	public List<Operande> getListOp() {
		return listOp;
	}

	public void setListOp( List<Operande> listOp ) {
		
		this.listOp = listOp;
		
	}
	
	private List<Operande> listOp;

}
