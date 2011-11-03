
public class ElementFloat extends Element{
	
	ElementFloat(float value){
		super();
		this.value = value;
	}
	
	public float getValue(){
		return this.value;
	}
	
	public void setValue( float value ){
		this.value = value;
	}
	@Override
	void acceptVisiteur(Visiteur v) {
		// TODO Auto-generated method stub
		v.visitElementFloat( this );
		if( this.getPrevious() != null ){
			this.getPrevious().acceptVisiteur( v );
		}
	}
	
	@Override
	public Element getTop() {
		// TODO Auto-generated method stub
		return ElementFloat.top;
	}

	@Override
	public void setTop(Element element) {
		// TODO Auto-generated method stub
		ElementFloat.top = ( ElementFloat ) element;
	}
	
	private static ElementFloat top;
	
	private float value;
}
