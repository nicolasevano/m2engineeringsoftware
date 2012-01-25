package canal;

/**
 * 
 * sensor observers interface
 *
 */
public interface SensorServiceObserver {

	/**
	 * Call on each notify by the sensor on which the implementation of this interface is attached.
	 */
	public void update();
	
}
