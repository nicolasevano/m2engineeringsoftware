package test.sensor;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sensor.AtomicForwarding;
import sensor.EntryVersion;
import sensor.ForwardingAlgo;
import sensor.Sensor;
import canal.Canal;
import canal.SensorServiceObserver;
import client.Screen;

public class AtomicForwardingTest {

	ForwardingAlgo atomicForwardingTest = null;
	
	Sensor sensorStub = null;
	
	Canal canalStub = null;
	
	class CanalStub implements Canal, SensorServiceObserver{
		
		public CanalStub( Sensor sensor,int simulatedID ){
			this.sensor = sensor;
			sensor.attach( ( SensorServiceObserver ) this);
			this.simulatedID = simulatedID;
			this.updateCall = false;
		}
		
		@Override
		public void attach(Screen screen) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void detach(Screen screen) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
			updateCall = true;
		}

		@Override
		public ScheduledFuture<EntryVersion> getValue(int id)
				throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		
		public EntryVersion getValueStub(){
			currentValue = sensor.getValue();
			return currentValue;
		}

		@Override
		public Sensor getSensor() throws RemoteException {
			// TODO Auto-generated method stub
			return sensor;
		}

		@Override
		public Map<Integer, EntryVersion> getTickets() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EntryVersion getTicket(int id) throws RemoteException {
			currentValue = sensor.getValue();
			return currentValue;
		}
		
		private Sensor sensor = null;
		private EntryVersion currentValue;
		private int simulatedID;
		protected boolean updateCall;
	}
	
	
	
	class SensorStub implements Sensor{
		
		public SensorStub(ForwardingAlgo forward){
			this.forward = forward;
			forward.configure( this );
		}
		
		public ForwardingAlgo getForward(){
			return this.forward;
		}
		
		@Override
		public void attach(SensorServiceObserver o) {
			// TODO Auto-generated method stub
			observers.add( o );
		}

		@Override
		public void detach(SensorServiceObserver o) {
			// TODO Auto-generated method stub
			observers.remove( o );
		}

		@Override
		public void notifySensorServiceObserver() {
			// TODO Auto-generated method stub
			for( SensorServiceObserver observer : observers ){
				observer.update();
			}
		}

		@Override
		public EntryVersion getValue() {
			// TODO Auto-generated method stub
			forward.observerUpdated();
			EntryVersion result = forward.getHeadVersion();
			return result;
		}

		@Override
		public void setValue(int v) {
			// TODO Auto-generated method stub
			this.value = v;
		}

		@Override
		public int getForwardedValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			forward.execute();
		}
		
		@Override
		public List<SensorServiceObserver> getObservers() {
			// TODO Auto-generated method stub
			return observers;
		}
		
		/**
		 * List of all observer on this subject
		 */
		private List<SensorServiceObserver> observers = new ArrayList<SensorServiceObserver>();
		private int value = 0;
		private ForwardingAlgo forward = null;
		
	}
			
	@Before
	public void setUp() throws Exception {
		
		atomicForwardingTest = new AtomicForwarding();
		sensorStub = new SensorStub( atomicForwardingTest );
		canalStub = new CanalStub( sensorStub, 1 );
	}

	@After
	public void tearDown() throws Exception {
		sensorStub.detach( (SensorServiceObserver) canalStub );
		canalStub = null;
		atomicForwardingTest = null;
	}

	@Test
	public void configureTest() {
		assertEquals(atomicForwardingTest, ( ( SensorStub ) sensorStub ).getForward() );
	}

	@Test
	public void executeTest() {
		new Thread(){
			public void run(){
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				atomicForwardingTest.observerUpdated();
			}
		}.start();
		sensorStub.tick();
		
		assertTrue( ( ( CanalStub ) canalStub ).updateCall);
	}
	
	@Test
	public void observerUpdatedTest(){
		
		new Thread(){
			public void run(){
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assertEquals( sensorStub.getValue().getValue(), 1 );
			}
		}.start();
		sensorStub.setValue( 1 );
		sensorStub.tick();
		new Thread(){
			public void run(){
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assertEquals( sensorStub.getValue().getValue(), 2 );
			}
		}.start();
		sensorStub.setValue( 2 );
		sensorStub.tick();
	}
	
	@Test
	public void getHeadVersionTest(){
		sensorStub.setValue( 1 );
		new Thread(){
			public void run(){
				try {
					Thread.sleep( 400 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assertEquals( atomicForwardingTest.getHeadVersion().getValue(), 1 );
				atomicForwardingTest.observerUpdated();
			}
		}.start();
		sensorStub.tick();
		sensorStub.setValue( 2 );
		new Thread(){
			public void run(){
				try {
					Thread.sleep( 400 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				assertEquals( atomicForwardingTest.getHeadVersion().getValue(), 2 );
				atomicForwardingTest.observerUpdated();
			}
		}.start();
		sensorStub.tick();
	}

}
