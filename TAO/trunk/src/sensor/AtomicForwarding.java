package sensor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import sensor.EntryVersion;

import canal.SensorServiceObserver;




public class AtomicForwarding implements ForwardingAlgo {

	@Override
	/**
	 * Configure function, configure forwardingAlgo implementation with a sensor.
	 * @param sensor
	 */
	public void configure( Sensor sensor ) {
		// TODO Auto-generated method stub
		this.sensor = sensor;
	}

	@Override
	/**
	 * Execute function, execute forwardingAlgo implementation strategy.
	 */
	public synchronized void execute() {
		//( ( SensorImpl ) sensor ).setValue( sensor.getValue() + 1 );
		blockingQueue.addAll( sensor.getObservers() );
		sensor.notifySensorServiceObserver();
		this.snapShotValue = sensor.getForwardedValue();
		while( !blockingQueue.isEmpty() ){
			try {
				Thread.sleep( 100 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println( "Waitting getValue from observer." );
		}
	}
	
	/**
	 * Call when an observers on attached sensor get sensor value.
	 */
	public void observerUpdated(){
		if( !blockingQueue.isEmpty() ){
			
			System.out.println( "Remove one observer from blocking queue." );
			blockingQueue.remove();
			
		}
	}
	
	@Override
	/**
	 * Useless in atomic strategy
	 */
	public EntryVersion getHeadVersion() {
		// TODO Auto-generated method stub
		EntryVersion result = new EntryVersion( -1, snapShotValue, 1 );
		return result;
	}
	
	/**
	 * sensor on which atomic strategy is apply
	 */
	private Sensor sensor;
	
	/**
	 * waiting observers used during update atomic sequences.
	 */
	private BlockingQueue<SensorServiceObserver> blockingQueue = new LinkedBlockingQueue<SensorServiceObserver>();
	private int snapShotValue = 0;
}
