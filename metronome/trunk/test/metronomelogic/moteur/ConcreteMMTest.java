/**
 * 
 */
package metronomelogic.moteur;

import static org.junit.Assert.*;

import metronome.view.View;
import metronomelogic.Horloge;
import metronomelogic.command.Command;
import metronomelogic.command.lireclavier.LireClavier;
import metronomelogic.controler.Controler;

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
		concreteMM = new ConcreteMM(controlerMock );
		
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
		assertFalse(concreteMM.isEtatMarche());
		concreteMM.run();
		assertTrue(concreteMM.isEtatMarche());
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#setBPM(int)}.
	 */
	@Test
	public void testSetBPM() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#setEtatMarche(boolean)}.
	 */
	@Test
	public void testSetEtatMarche() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#setTempo(int)}.
	 */
	@Test
	public void testSetTempo() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#notifyTempo()}.
	 */
	@Test
	public void testNotifyTempo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#removeTempoObs(metronomelogic.controler.Observateur)}.
	 */
	@Test
	public void testRemoveTempoObs() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#addBPMObs(metronomelogic.controler.Observateur)}.
	 */
	@Test
	public void testAddBPMObs() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#notifyBPM()}.
	 */
	@Test
	public void testNotifyBPM() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#removeBPMObs(metronomelogic.controler.Observateur)}.
	 */
	@Test
	public void testRemoveBPMObs() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link metronomelogic.moteur.ConcreteMM#getCommands()}.
	 */
	@Test
	public void testGetCommands() {
		fail("Not yet implemented");
	}

}
