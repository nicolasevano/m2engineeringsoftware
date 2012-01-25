package sensor;

import java.util.ArrayDeque;
import java.util.Queue;


public class EpoqueForwarding implements ForwardingAlgo {

	@Override
	/**
	 * Configure function, configure forwardingAlgo implementation with a sensor.
	 * @param sensor
	 */
	public void configure(Sensor sensor) {
		// TODO Auto-generated method stub
		this.sensor = sensor;
		version = 0;
	}

	@Override
	/**
	 * Execute function, execute forwardingAlgo implementation strategy.
	 */
	public void execute() {
		// TODO Auto-generated method stub
		EntryVersion entryVersion = new EntryVersion( version++, 
													  sensor.getForwardedValue(), 
													  ( ( SensorImpl ) sensor ).observers.size() );
		versionBuffer.add( entryVersion );
		sensor.notifySensorServiceObserver();
	}
	
	@Override
	/**
	 * Call when an observers on attached sensor get sensor value.
	 */
	public void observerUpdated(){
		if(!versionBuffer.isEmpty()){
			versionBuffer.element().decreaseTTL();
			if( versionBuffer.element().isUpTodate() ) versionBuffer.poll();
		}
	}
	
	@Override
	/**
	 * Get the head revision on versioned queue. 
	 */
	public EntryVersion getHeadVersion(){
		return ( !versionBuffer.isEmpty() )?versionBuffer.element():new EntryVersion(-1,-1,0);
		
	}
	
	
	/**
	 * Sensor on which version forwarding stategy is apply.
	 */
	private Sensor sensor;
	
	/**
	 * Current version release forwarded.
	 */
	private int version = 0;
	
	/**
	 * Version queue
	 */
	private Queue< EntryVersion > versionBuffer = new ArrayDeque< EntryVersion >();
}
