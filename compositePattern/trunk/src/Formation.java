
abstract class Formation {
	/**
	 * Constructor each formation as a unique name then constructor get it in parameter
	 * @param name
	 */
	public Formation(String name){
		//TODO check name is unique
		this.name = name;
	}
	
	/**
	 * getNote function return score of formation if exist
	 * @return a score on 20
	 */
	public int getNote(){
		//TODO use float instead of integer
		return note;
	}
	
	/**
	 * setNote function return score of formation 
	 * @param note
	 */
	public void setNote( int note ){
		score = true;
		this.note = note;
	}

	/**
	 * indicate if formation as a score
	 * @return int score
	 */
	public boolean asScore(){
		return score;
	}
	
	public String getName(){
		return name;
	}
	
	abstract boolean ajouteFormation( Formation formation );
	
	abstract boolean retireFormation( Formation formation );
	
	private boolean score;
	
	private int note;
	
	private String name;
}
