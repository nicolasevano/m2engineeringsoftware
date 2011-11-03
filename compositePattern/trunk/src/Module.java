import java.util.Iterator;


public class Module extends Formation {

	public Module( String name ){
		super( name );
	}
	
	
	public Iterator< Module > getIterator( Module first ){
		return new Parcour( first );
	}
	
	public Module getNext() {
		return next;
	}
	
	public void setNext(Module module){
		this.next = module;
	}
	
	@Override
	boolean ajouteFormation(Formation formation) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	boolean retireFormation(Formation formation) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private class Parcour implements Iterator<Module>{
		
		public Parcour(Module module){
			previous = null;
			current = module;
		}
		@Override
		public boolean hasNext() {
			return (this.current.getNext() != null);
		}

		@Override
		public Module next() {
			Module result;
			this.previous = this.current;
			result = this.current;
			this.current = this.current.getNext();
			return result;
		}

		@Override
		public void remove() {
			if(this.previous != null) this.previous.next = this.current.next;
			this.current = this.current.next;
		}
		
		private Module current;
		
		private Module previous;
		
	}
	
	private Module next;

}
