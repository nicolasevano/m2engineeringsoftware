package sensor;

import java.util.List;

import canal.SensorServiceObserver;


public interface Sensor extends Subject{

	public EntryVersion getValue();
	
	public void setValue(int v);
	
	public int getForwardedValue();
	/**
	 * Tick function indicate that new value has arrived on the sensor.
	 */
	public void tick();
	
	public List<SensorServiceObserver> getObservers();
	
}
