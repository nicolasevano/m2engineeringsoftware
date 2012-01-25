package sensor;

import canal.SensorServiceObserver;


public interface Subject {
	
	/**
	 * Attach function, attach a new observers on a sensor subject 
	 * @param o SensorServiceObserver
	 */
	public void attach(SensorServiceObserver o);
	
	/**
	 * Detach function, detach an observers on sensor subject if and only if attached before. 
	 * @param o SensorServiceObserver
	 */
	public void detach(SensorServiceObserver o);
	
	/**
	 * notifySensorServiceObserver function, notify each observers that sensor is up to date. 
	 */
	public void notifySensorServiceObserver();
}
