
public abstract class Element {
	
	protected Element(){
		addElement( this );
	}
	
	private void addElement( Element element ){
		if( element.getTop() == null )
			element.setTop( this );
		else { 
			element.getTop().setNext( element );
			element.setPrevious( element.getTop() );
			element.setTop( element );
		}
		
	}
	
	abstract void acceptVisiteur(Visiteur v);
	
	public Element getElement(){
		return this;
	}
	
	public void setPrevious(Element previous){
		this.previous = previous;
	}
	
	public Element getPrevious(){
		return this.previous;
	}
	
	public void setNext(Element next){
		this.next = next;
	}
	
	public Element getNext(){
		return this.next;
	}
	
	abstract void setTop(Element element);
	
	abstract Element getTop();
	
	private Element previous;
	private Element next;
}
