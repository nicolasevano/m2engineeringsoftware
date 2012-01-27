package sensor;

import java.util.ArrayList;
import java.util.List;

import canal.SensorServiceObserver;


public class SensorImpl implements Sensor {
	
	/**
	 * Constructor take in parameter a Forwarding strategy used with this sensor.
	 * @param forwardingAlgo
	 */
	public SensorImpl(ForwardingAlgo forwardingAlgo){
		this.forward = forwardingAlgo;
		forward.configure( this );
		this.value = 0;
	}
	
	@Override
	/**
	 * Attach function attach a new SensorServiceObserver to this Sensor instance.
	 * @param SensorServiceObserver o new observer to attach to this subject
	 */
	public void attach(SensorServiceObserver o) {
		// TODO Auto-generated method stub
		this.observers.add(o);
	}
	
	@Override
	/**
	 * Detach function remove a SensorServiceObserver given in parameter from this Sensor instance.
	 * @param SensorServiceObserver o observer to detach from this subject
	 */
	public void detach(SensorServiceObserver o) {
		// TODO Auto-generated method stub
		this.observers.remove(o);
	}

	@Override
	/**
	 * NotifySensorServiceObserver function notify each observer that current sensor value has been changed.
	 */
	public void notifySensorServiceObserver() {
		// TODO Auto-generated method stub
		for( SensorServiceObserver observer : this.observers ){
			observer.update();
		}
	}

	@Override
	/**
	 * Return current Entry version sensor release.
	 */
	public EntryVersion getValue() {
		// TODO Auto-generated method stub
		
		EntryVersion result = forward.getHeadVersion();
		if (result.getValue() == -1) result.setValue( value );
		System.out.println( "Forwarded result version: " + result.getKey() );
		forward.observerUpdated();
		return result;
		
	}
	
	@Override
	/**
	 * Return the current real value of this sensor instance
	 */
	public int getForwardedValue(){
		return value;
	}
	
	@Override
	public void setValue( int value ){
		this.value = value;
	}
	
	@Override
	/**
	 * Tick function indicate that new value has arrived on the sensor.
	 */
	public void tick() {
		// TODO Auto-generated method stub
		forward.execute();
	}
	
	@Override
	public List<SensorServiceObserver> getObservers() {
		return observers;
	}

	
	public void setObservers(List<SensorServiceObserver> observers) {
		this.observers = observers;
	}
	
	/**
	 * List of all observer on this subject
	 */
	protected List<SensorServiceObserver> observers = new ArrayList<SensorServiceObserver>();
	
	/**
	 * Current subject value
	 */
	private int value = 0;
	
	/**
	 * Used forwarding method object instance use on each notify. 
	 */
	private ForwardingAlgo forward;
}
