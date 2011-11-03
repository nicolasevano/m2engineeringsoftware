public class ElementInteger extends Element{
	
	ElementInteger(int value){
		super();
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	@Override
	void acceptVisiteur(Visiteur v) {
		// TODO Auto-generated method stub
		v.visitElementInteger( this );
		if( this.getPrevious() != null ){
			this.getPrevious().acceptVisiteur( v );
		}
	}
	
	@Override
	public Element getTop() {
		// TODO Auto-generated method stub
		return ElementInteger.top;
	}

	@Override
	public void setTop(Element element) {
		// TODO Auto-generated method stub
		ElementInteger.top = ( ElementInteger ) element;
	}

	private static ElementInteger top;
	
	private int value;	
}
