package lattitude;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Droit")
public class Droit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6507283273567115733L;

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
	
	@Id
	@GeneratedValue
	long id;
	
	boolean isVisible;
	
	boolean isConnected;
	
}
