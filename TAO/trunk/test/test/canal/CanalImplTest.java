package test.canal;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sensor.EpoqueForwarding;
import sensor.SensorImpl;
import canal.CallableServant;
import canal.Canal;
import canal.CanalImpl;
import client.Screen;

public class CanalImplTest {

	private Canal canalImplTest = null;
	
	private Screen screenStub = null;
	
	class ScreenStub implements Screen{

		public ScreenStub(int id){
			this.id = id;
		}
		@Override
		public void update(CallableServant outputCallable)
				throws RemoteException {
			// TODO Auto-generated method stub
			updateCall = true;
		}

		@Override
		public int getID() throws RemoteException {
			// TODO Auto-generated method stub
			return id;
		}
		
		protected int id;
		
		protected boolean updateCall = false;
	}
	
	@Before
	public void setUp() throws Exception {
		screenStub = new ScreenStub( 1 );
		canalImplTest = new CanalImpl( new SensorImpl( new EpoqueForwarding() ) );
	}

	@After
	public void tearDown() throws Exception {
		canalImplTest = null;
	}
	
	@Test
	public void attachTest(){
		try {
			canalImplTest.attach(screenStub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(screenStub,( ( CanalImpl ) canalImplTest ).getScreens().get( 0 ) );
	}
	
	@Test
	public void detachTest(){
		try {
			canalImplTest.attach( screenStub );
			assertEquals(screenStub,( ( CanalImpl ) canalImplTest ).getScreens().get( 0 ) );
			canalImplTest.detach(screenStub);
			assertEquals(0,( ( CanalImpl ) canalImplTest ).getScreens().size() );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
