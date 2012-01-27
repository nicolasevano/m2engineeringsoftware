package sensor;

import java.io.Serializable;


/**
 * EntryVersion class,  definite an entry on versioned on queue
 *
 */
public class EntryVersion implements Serializable {
	
	public EntryVersion(int key, int value, int TTL){
		this.key = key;
		this.value = value;
		this.TTL = TTL;
	}
	
	public int getKey(){
		// TODO Auto-generated method stub
		return key;
	}

	public int getValue(){
		// TODO Auto-generated method stub
		return value;
	}
	
	public void decreaseTTL(){
		this.TTL--;
	}
	
	public boolean isUpTodate(){
		return (TTL >= 0);
	}

	public void setValue(int value) {
		// TODO Auto-generated method stub
		this.value = value;
	}
	
	private int TTL;
	private int key;
	private int value;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1196670493443671355L;
}
