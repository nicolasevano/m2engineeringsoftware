import java.util.Iterator;


public class Master2 extends Formation implements Iterable< Semestre > {
	
	public Master2(String name) {
		super( name );
		// TODO Auto-generated constructor stub
	}

	/**
	 * getNote function return the current semester score on 20. 
	 * Semester note is the mean on 20 of all available score module if 
	 * they are otherwise nothing. 
	 */
	public int getNote(){
		
		int result = 0;
		int counter = 0;
		for( Semestre semestre : this ){
			if( semestre.asScore() ){
				result += semestre.getNote();
				counter++;
			}
		}
		return ( counter > 0 ) ? ( result / counter ) : 0 ;
		
	}
	
	public void setNote(int note){
		System.out.println( "Forbidden on a Semestre!" );
	}
	
	@Override
	boolean ajouteFormation( Formation formation ) {
		boolean result = false;
		if( formation instanceof Semestre ){
			
			if( this.semestreFirst == null ){
				this.semestreFirst = ( Semestre ) formation;
			} else {
				this.current.setNext( ( Semestre ) formation );
			}
			this.current = ( Semestre ) formation;
			result = true;
		}
		return result;
	}

	@Override
	boolean retireFormation( Formation formation ) {
		
		boolean result = false;
		Semestre previous = null;
		Semestre isToRemove = null;
		if( formation instanceof Semestre ){
			isToRemove = this.semestreFirst;
			while ( ( isToRemove != null ) && ( !result ) ){
				if( ( isToRemove.getName() ).equals( formation.getName() ) ){
					
					if( isToRemove == this.semestreFirst )
						this.semestreFirst = this.semestreFirst.getNext(); 
					else if( isToRemove == this.current ) {
						previous.setNext( null );
						this.current = previous;
					} else 
						previous.setNext( isToRemove.getNext() );
					result = true;
				} else {
					
					previous = isToRemove;
					isToRemove = isToRemove.getNext();
					
				}
			}
		}
		return result;
		
	}

	public Iterator<Master2> getIterator(Master2 first){
		return new Parcour( first );
	}
	
	@Override
	public Iterator<Semestre> iterator() {
		// TODO Poor syntax need instance on Module to get Iterator... 
		return current.getIterator( this.semestreFirst );
	}

	public Master2 getNext(){
		return this.next;
	}
	
	public void setNext(Master2 master2){
		this.next = master2;
	}
	
	private class Parcour implements Iterator<Master2>{
		
		public Parcour( Master2 master2 ){
			previous = null;
			current = master2;
		}
		@Override
		public boolean hasNext() {
			return (this.current.getNext() != null);
		}

		@Override
		public Master2 next() {
			this.previous = this.current;
			this.current = this.current.getNext();
			return this.current;
		}

		@Override
		public void remove() {
			if(this.previous != null) this.previous.setNext( this.current.getNext() );
			this.current = this.current.getNext();
		}
		
		private Master2 current;
		
		private Master2 previous;
		
	}
	
	private Master2 next;
	
	private Semestre current;
	
	private Semestre semestreFirst;
	
}
