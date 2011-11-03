/**
 * 
 */
package metronomelogic.moteur;

import static org.junit.Assert.*;

import metronome.view.View;
import metronomelogic.Horloge;
import metronomelogic.controler.Controler;
import metronomelogic.controler.Observateur;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author 28008663
 *
 */
public class ConcreteMMTest {
	
	private Controler controlerMock;
	private ConcreteMM concreteMM;
	private View viewMock;
	private Horloge horlogeMock;
	private Monobserveurstub observateurStub; 
	
	class Monobserveurstub implements Observateur {
		public boolean actualiseTempoCalled;
		public boolean actualiseBpmCalled;

		@Override
		public void actualiseTempo() {
			actualiseTempoCalled = true; 
		}

		@Override
		public void actualiseBPM() {
			actualiseBpmCalled = true; 
		}
		
	}
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		horlogeMock = EasyMock.createMock( Horloge.class );
		viewMock = EasyMock.createMock( View.class );
		EasyMock.expect(viewMock.getHorloge()).andReturn(horlogeMock).anyTimes();
		EasyMock.replay(viewMock);
		
		controlerMock = EasyMock.createMock( Controler.class );
		EasyMock.expect(controlerMock.getPresente()).andReturn(viewMock).anyTimes();
		EasyMock.expect(controlerMock.getHorloge()).andReturn(horlogeMock).anyTimes();
		EasyMock.replay(controlerMock);
		observateurStub = new Monobserveurstub();
		concreteMM = new ConcreteMM(controlerMock );
		concreteMM.addBPMObs( observateurStub );
		concreteMM.addTempoObs( observateurStub );
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		horlogeMock=null;
		viewMock=null;
		controlerMock=null;
		concreteMM=null;
		observateurStub = null;
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#ConcreteMM(metronomelogic.controler.Controler)}.
	 */
	@Test
	public void testConcreteMMControler() {
		assertNotNull(concreteMM);
	}
	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#isEtatMarche()}.
	 */
	@Test
	public void testIsEtatMarche() {
		
		assertFalse(concreteMM.isEtatMarche());
		concreteMM.run();
		assertTrue(concreteMM.isEtatMarche());
		
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#run()}.
	 */
	@Test
	public void testRun() {
		
		assertFalse( concreteMM.isEtatMarche() );
		concreteMM.run();
		assertTrue( concreteMM.isEtatMarche() );
		
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#setBPM(int)}.
	 */
	@Test
	public void testSetBPM() {
		
		int bpm = 100;
		concreteMM.run();
		concreteMM.setBPM( bpm );
		assertTrue( ( ( Monobserveurstub ) observateurStub ).actualiseBpmCalled );
		assertEquals( bpm, concreteMM.getBPM() );
		
	}
	 
	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#setTempo(int)}.
	 */
	@Test
	public void testSetTempo() {
		
		int tempo = 7 ;
		concreteMM.run();
		concreteMM.setTempo( tempo );
		assertTrue( ( ( Monobserveurstub ) observateurStub ).actualiseTempoCalled );
		assertEquals( tempo, concreteMM.getTempo() );
		
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#stop()}.
	 */
	@Test
	public void testStop() {
		assertFalse(concreteMM.isEtatMarche());
		concreteMM.run();
		assertTrue(concreteMM.isEtatMarche());
		concreteMM.stop();
		assertFalse(concreteMM.isEtatMarche());
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#addTempoObs(metronomelogic.controler.Observateur)}.
	 */
	@Test
	public void testAddTempoObs() {
		
		int tempo = 7;
		concreteMM.run();
		concreteMM.setTempo( tempo );
		assertTrue( ( ( Monobserveurstub ) observateurStub ).actualiseTempoCalled );
		
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#notifyTempo()}.
	 */
	@Test
	public void testNotifyTempo() {
		
		int tempo = 7;
		concreteMM.run();
		concreteMM.setTempo( tempo );
		assertTrue( ( ( Monobserveurstub ) observateurStub ).actualiseTempoCalled );
		
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#removeTempoObs(metronomelogic.controler.Observateur)}.
	 */
	@Test
	public void testRemoveTempoObs() {
		
		int tempo = 7;
		concreteMM.removeTempoObs( observateurStub );
		concreteMM.run();
		assertFalse( ( ( Monobserveurstub ) observateurStub ).actualiseTempoCalled );
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#addBPMObs(metronomelogic.controler.Observateur)}.
	 */
	@Test
	public void testAddBPMObs() {
		
		int bpm = 100 ;
		concreteMM.run();
		concreteMM.setBPM( bpm );
		assertTrue( ( ( Monobserveurstub ) observateurStub ).actualiseBpmCalled );
		
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#notifyBPM()}.
	 */
	@Test
	public void testNotifyBPM() {
		
		int bpm = 100;
		concreteMM.run();
		concreteMM.setBPM( bpm );
		assertTrue( ( ( Monobserveurstub ) observateurStub ).actualiseBpmCalled );
		
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#removeBPMObs(metronomelogic.controler.Observateur)}.
	 */
	@Test
	public void testRemoveBPMObs() {
		
		int bpm = 100;
		concreteMM.removeBPMObs( observateurStub );
		concreteMM.run();
		concreteMM.setBPM( bpm );
		assertFalse( ( ( Monobserveurstub ) observateurStub ).actualiseBpmCalled );
		
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#getCommands()}.
	 */
	@Test
	public void testGetCommands() {
		
		assertNotNull( concreteMM.getCommands() );
		
	}

}
