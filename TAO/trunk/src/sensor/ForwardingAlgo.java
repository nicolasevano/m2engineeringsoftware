package sensor;

import sensor.EntryVersion;


public interface ForwardingAlgo {

	/**
	 * Configure function, configure forwardingAlgo implementation with a sensor.
	 * @param sensor
	 */
	public void configure(Sensor sensor);
	
	/**
	 * Execute function, execute forwardingAlgo implementation strategy.
	 */
	public void execute();
	
	/**
	 * Call when an observers on attached sensor get sensor value.
	 */
	public void observerUpdated();
	
	/**
	 * Get the current forwared version (not the last).
	 */
	public EntryVersion getHeadVersion();
}
