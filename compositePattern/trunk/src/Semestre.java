import java.util.Iterator;


public class Semestre extends Formation implements Iterable<Module>{

	
	public Semestre(String name){
		super( name );
		this.moduleFirst = null;
	}
	
	@Override
	boolean ajouteFormation( Formation formation ) {
		boolean result = false;
		if( formation instanceof Module ){
			
			if( this.moduleFirst == null ){
				this.moduleFirst = ( Module ) formation;
				//System.out.println( "Add first module." );
			} else {
				//System.out.println( "Add one more module." );
				this.current.setNext( ( Module ) formation );
			}
			this.current = ( Module ) formation;
			result = true;
		}
		return result;
	}

	@Override
	boolean retireFormation( Formation formation ) {
		
		boolean result = false;
		Module previous = null;
		Module isToRemove = null;
		if( formation instanceof Module ){
			isToRemove = this.moduleFirst;
			while ( ( isToRemove != null ) && ( !result ) ){
				if( ( isToRemove.getName() ).equals( formation.getName() ) ){
					
					if( isToRemove == this.moduleFirst )
						this.moduleFirst = this.moduleFirst.getNext(); 
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
	
	
	/**
	 * getNote function return the current semester score on 20. 
	 * Semester note is the mean on 20 of all available score module if 
	 * they are otherwise nothing. 
	 */
	public int getNote(){
		
		int result = 0;
		int counter = 0;
		//System.out.println( "Get note of semestre." );
		//Iterator<Module> iterator = moduleFirst.getIterator( this.moduleFirst );
		//Module module;
		//while( iterator.hasNext() ){
			//System.out.println( "Iteration on module:" );
			//module = iterator.next();
			for(Module module: this){
			if( module.asScore() ){
				//System.out.println( "Get score of on module to compute score of semestre." );
				result += module.getNote();
				counter++;
			}
		}
		return (counter > 0) ? ( result / counter) : 0 ;
		
	}
	
	public void setNote(int note){
		System.out.println("Forbidden on a Semestre!");
	}
	
	public boolean asScore(){
		
		boolean result = false;
		for( Module module : this ){
			if( module.asScore() ){
				result = true;
				break;
			}
		}
		return result;
		
	}
	
	public Iterator<Semestre> getIterator( Semestre first ){
		return new Parcour( first );
	}
	
	@Override
	public Iterator<Module> iterator() {
		// TODO Poor syntax need instance on Module to get Iterator... 
		return current.getIterator( this.moduleFirst );
	}

	public Semestre getNext(){
		return this.next;
	}
	
	public void setNext(Semestre next){
		this.next = next;
	}
	
	private class Parcour implements Iterator<Semestre>{
		
		public Parcour(Semestre semestre){
			previous = null;
			current = semestre;
		}
		@Override
		public boolean hasNext() {
			return (this.current.getNext() != null);
		}

		@Override
		public Semestre next() {
			this.previous = this.current;
			this.current = this.current.getNext();
			return this.current;
		}

		@Override
		public void remove() {
			if(this.previous != null) this.previous.next = this.current.next;
			this.current = this.current.getNext();
		}
		
		private Semestre current;
		
		private Semestre previous;
		
	}
	
	private Semestre next;
	
	private Module current;
	
	private Module moduleFirst;

}
