package test.sensor;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledFuture;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sensor.EntryVersion;
import sensor.EpoqueForwarding;
import sensor.ForwardingAlgo;
import sensor.Sensor;

import client.Screen;

import canal.Canal;
import canal.SensorServiceObserver;

public class EpoqueForwardingTest {
	
	ForwardingAlgo epoqueForwardingTest = null;
	
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
		
		epoqueForwardingTest = new EpoqueForwarding();
		sensorStub = new SensorStub( epoqueForwardingTest );
		canalStub = new CanalStub( sensorStub, 1 );
	}

	@After
	public void tearDown() throws Exception {
		sensorStub.detach( (SensorServiceObserver) canalStub );
		canalStub = null;
		epoqueForwardingTest = null;
	}

	@Test
	public void configureTest() {
		assertEquals(epoqueForwardingTest,( ( SensorStub ) sensorStub ).getForward() );
	}

	@Test
	public void executeTest() {
		sensorStub.tick();
		assertTrue( ( ( CanalStub ) canalStub ).updateCall);
	}
	
	@Test
	public void observerUpdatedTest(){
		
		sensorStub.setValue( 1 );
		sensorStub.tick();
		assertEquals( sensorStub.getValue().getValue(), 1 );
		sensorStub.setValue( 2 );
		sensorStub.tick();
		assertEquals( sensorStub.getValue().getValue(), 2 );
		
	}
	
	@Test
	public void getHeadVersionTest(){
		
		sensorStub.setValue( 1 );
		sensorStub.tick();
		epoqueForwardingTest.observerUpdated();
		assertEquals( 1, epoqueForwardingTest.getHeadVersion().getValue() );
		sensorStub.setValue( 2 );
		sensorStub.tick();
		epoqueForwardingTest.observerUpdated();
		assertEquals( 2, epoqueForwardingTest.getHeadVersion().getValue() );
		
	}
	
}
