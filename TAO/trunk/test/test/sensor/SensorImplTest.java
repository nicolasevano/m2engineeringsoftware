package test.sensor;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sensor.EntryVersion;
import sensor.EpoqueForwarding;
import sensor.Sensor;

import client.Screen;

import canal.Canal;
import canal.SensorServiceObserver;
import sensor.SensorImpl;

public class SensorImplTest {
	
	private Sensor sensorImplTest = null;
	
	private Canal canalStub = null;
	
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
	
	@Before
	public void setUp() throws Exception {
		
		sensorImplTest = new SensorImpl(new EpoqueForwarding());
		canalStub = new CanalStub( sensorImplTest, 1 );
		
	}

	@After
	public void tearDown() throws Exception {
		sensorImplTest = null;
	}

	@Test
	public void attachTest() {
		// TODO Auto-generated method stub
		assertEquals( 1, sensorImplTest.getObservers().size() );
	}
	
	@Test
	public void detachTest() {
		// TODO Auto-generated method stub
		assertEquals( 1, sensorImplTest.getObservers().size() );
		sensorImplTest.detach( ( SensorServiceObserver ) canalStub );
		assertEquals( 0, sensorImplTest.getObservers().size() );
	}

	@Test
	public void notifySensorServiceObserverTest() {
		sensorImplTest.notifySensorServiceObserver();
		assertTrue( ( ( CanalStub) canalStub).updateCall );
	}

	@Test
	public void getValueTest() {
		// TODO Auto-generated method stub
		sensorImplTest.setValue( 1 );
		sensorImplTest.tick();
		assertEquals( 1, sensorImplTest.getValue().getValue() );
		sensorImplTest.getValue().getValue();
		sensorImplTest.setValue( 2 );
		sensorImplTest.tick();
		assertEquals( 2, sensorImplTest.getValue().getValue() );
		sensorImplTest.getValue().getValue();
		
	}
	
	@Test
	public void tickTest() {
		sensorImplTest.setValue( 1 );
		sensorImplTest.tick();
		assertEquals( 1,sensorImplTest.getValue().getValue() );
		sensorImplTest.getValue().getValue();
		sensorImplTest.setValue( 2 );
		sensorImplTest.tick();
		assertEquals( 2,sensorImplTest.getValue().getValue() );
	}
	
}
