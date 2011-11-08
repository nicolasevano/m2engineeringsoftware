package metronome.view;

import static org.junit.Assert.*;

import metronomelogic.command.Command;
import metronomelogic.controler.ConcreteControler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HorlogeSimulateTest {
	private HorlogeSimulate horlogeSimulate;
	private Command commandStub;
	
	class CommandStub implements Command {
		public boolean executeCall;
		

		@Override
		public void execute() {
			executeCall = true;
			
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "testCommand";
		}

		@Override
		public void setName(String name) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Before
	public void setUp() throws Exception {
		commandStub = new CommandStub();
		horlogeSimulate= new HorlogeSimulate();
	}

	@After
	public void tearDown() throws Exception {
		commandStub = null;
		horlogeSimulate= null;
	}
	

	@Test
	public void testActiverAprésDélai() {
		horlogeSimulate.activerAprésDélai(commandStub, 0.1);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			fail("no slept enough time");
		}
		assertTrue(((CommandStub)commandStub).executeCall);
	}

	@Test
	public void testActiverPeriodiquement() {
		
		horlogeSimulate.activerPeriodiquement(commandStub, 0.1);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			fail("no slept enough time");
		}
		assertTrue(((CommandStub)commandStub).executeCall);
		((CommandStub)commandStub).executeCall = false;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			fail("no slept enough time");
		}
		assertTrue(((CommandStub)commandStub).executeCall);
	}

	@Test
	public void testDésactiver() {
		horlogeSimulate.activerPeriodiquement(commandStub, 0.1);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			fail("no slept enough time");
		}
		assertTrue(((CommandStub)commandStub).executeCall);
		horlogeSimulate.désactiver( commandStub );
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			fail("no slept enough time");
		}
		((CommandStub)commandStub).executeCall = false;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			fail("no slept enough time");
		}
		assertFalse(((CommandStub)commandStub).executeCall);
	}

}
