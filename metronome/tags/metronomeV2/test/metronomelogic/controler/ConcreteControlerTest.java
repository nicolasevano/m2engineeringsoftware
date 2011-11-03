package metronomelogic.controler;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import metronome.view.View;
import metronomelogic.Afficheur;
import metronomelogic.Clavier;
import metronomelogic.EmetteurSonore;
import metronomelogic.Horloge;
import metronomelogic.Molette;
import metronomelogic.command.Command;
import metronomelogic.command.GenererEclairSurLED1;
import metronomelogic.command.GenererEclairSurLED2;
import metronomelogic.command.GenererSon;
import metronomelogic.command.LireBPM;
import metronomelogic.command.lireclavier.LireClavier;
import metronomelogic.moteur.ConcreteMM;
import metronomelogic.moteur.MoteurMetronome;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConcreteControlerTest {
	
	private ConcreteControler concreteControler;
	private View viewMock;
	//private Horloge horlogeMock;
	private Afficheur afficheurMock;
	private Molette moletteMock;
	private EmetteurSonore emetteurSonoreMock;
	private MonMoteurStub moteurStub;
	private MonHorlogeStub horlogeStub;
	private MaViewStub viewStub;
	
	//design because setPresnte call addBPMObs;
	class MaViewStub implements View{

		@Override
		public void allumerLED1() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void allumerLED2() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayBPM(int bpm) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void emettreSon() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void eteindreLED1() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void eteindreLED2() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Afficheur getAfficheur() {
			// TODO Auto-generated method stub
			return afficheurMock;
		}

		@Override
		public Clavier getClavier() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Controler getControler() {
			// TODO Auto-generated method stub
			return concreteControler;
		}

		@Override
		public EmetteurSonore getEmetteurSonore() {
			// TODO Auto-generated method stub
			return emetteurSonoreMock;
		}

		public void setHorloge( Horloge horloge ){
			this.horloge = horloge;
		}
		@Override
		public Horloge getHorloge() {
			// TODO Auto-generated method stub
			return horloge;
		}

		@Override
		public Molette getMolette() {
			// TODO Auto-generated method stub
			return moletteMock;
		}

		@Override
		public int getTouchePressé() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void notifyBPM() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setBPM() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addBPMObs(ObservateurPresentation observer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void notifyViewBPM() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeBPMObs(ObservateurPresentation observer) {
			// TODO Auto-generated method stub
			
		}
		private Horloge horloge;
	}
	
	//Horloge stub
	class MonHorlogeStub implements Horloge{
		
		
		public boolean activerArpésDelayCall = false;
		public boolean activerPeriodiquement = false;
		
		@Override
		public void activerAprésDélai(Command cmd, double périodeEnSecondes) {
			// TODO Auto-generated method stub
			activerArpésDelayCall = true;
		}

		@Override
		public void activerPeriodiquement(Command cmd, double périodeEnSecondes) {
			// TODO Auto-generated method stub
			activerPeriodiquement = true;
			
		}

		@Override
		public void désactiver(Command cmd) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//moteur stub definition
	class MonMoteurStub implements MoteurMetronome{
		
		MonMoteurStub(){
			commands.put( commandName[ LIRE_CLAVIER ], ( EasyMock.createMock(Command.class) ) );
			commands.put( commandName[ LIRE_BPM ], ( EasyMock.createMock(Command.class) ) );
			commands.put( commandName[ GENERER_CLIC], ( EasyMock.createMock(Command.class) ) );
			commands.put( commandName[ GENERER_ECLAIR_LED1 ], ( EasyMock.createMock(Command.class ) ) );
			commands.put( commandName[ GENERER_ECLAIR_LED2 ], ( EasyMock.createMock(Command.class) ) );
		}
		
		@Override
		public void addEventDelay(Command cmd, double delai) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addEventPeriodique(Command cmd, double delai) {
			controler.getHorloge().activerPeriodiquement(cmd, delai);
			
		}

		@Override
		public Controler getAccede() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getBPM() {
			// TODO Auto-generated method stub
			return bpm;
		}

		@Override
		public Map<String, Command> getCommands() {
			// TODO Auto-generated method stub
			return commands;
		}

		@Override
		public int getTempo() {
			// TODO Auto-generated method stub
			return tempo;
		}

		@Override
		public boolean isEtatMarche() {
			// TODO Auto-generated method stub
			return state;
		}

		@Override
		public void removeEventPeriodique(Command cmd) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			this.state = true;
		}

		@Override
		public void setAccede(Controler controler) {
			this.controler = controler;
			
		}

		@Override
		public void setBPM(int tempoParMesure) {
			if(this.bpm != tempoParMesure){
				this.bpm = tempoParMesure;
				this.notifyBPM();
			}
		}

		@Override
		public void setEtatMarche(boolean etatMarche) {
			// TODO Auto-generated method stub
			this.state = true;
		}

		@Override
		public void setTempo(int tempo) {
			if( this.tempo != tempo ){
				this.tempo = tempo;
				this.notifyTempo();
			}
		}

		@Override
		public void stop() {
			// TODO Auto-generated method stub
			this.state = false;
		}

		@Override
		public void addTempoObs(Observateur watcher) {
			obsTempos.add( watcher );
			
		}

		@Override
		public void notifyTempo() {
			for( Observateur obs: obsTempos ){
				obs.actualiseTempo();
			}
		}

		@Override
		public void removeTempoObs(Observateur watcher) {
			obsTempos.remove( watcher );
			
		}

		@Override
		public void addBPMObs(Observateur observer) {
			obsBPMs.add( observer );
		}

		@Override
		public void notifyBPM() {
			// TODO Auto-generated method stub
			if(state)for( Observateur obs: obsBPMs ){
				obs.actualiseBPM();
			}
		}

		@Override
		public void removeBPMObs(Observateur observer) {
			obsBPMs.remove( observer );
		}
		
		private List<Observateur> obsTempos = new ArrayList<Observateur>();
		
		private List<Observateur> obsBPMs = new ArrayList<Observateur>();
		
		private Map<String,Command> commands = new TreeMap<String,Command>();
		
		private boolean state;
		
		private Controler controler;
		private int tempo = 2;
		private int bpm = 100;
	}
	
	@Before
	public void setUp() throws Exception {
		
		//horlogeMock = EasyMock.createMock( Horloge.class );
		horlogeStub = new MonHorlogeStub();
		//viewMock = EasyMock.createMock( View.class);
		afficheurMock = EasyMock.createMock( Afficheur.class );
		
		moletteMock = EasyMock.createMock( Molette.class );
		EasyMock.expect( moletteMock.position() ).andReturn( 0.75 ).anyTimes();
		EasyMock.replay( moletteMock );
		emetteurSonoreMock = EasyMock.createMock(EmetteurSonore.class);
		//EasyMock.expect( viewMock.getHorloge() ).andReturn( horlogeStub ).anyTimes();
		//EasyMock.expect( viewMock.getAfficheur() ).andReturn( afficheurMock ).anyTimes();
		//EasyMock.expect( viewMock.getEmetteurSonore() ).andReturn( emetteurSonoreMock ).anyTimes();
		//EasyMock.expect( viewMock.getMolette() ).andReturn( moletteMock ).anyTimes();
		//EasyMock.replay( viewMock );
		viewStub = new MaViewStub();
		viewStub.setHorloge( horlogeStub );
		moteurStub = new MonMoteurStub();
		concreteControler = new ConcreteControler();
		concreteControler.setPresente( viewStub );
		concreteControler.setManage( moteurStub );
		moteurStub.setAccede( concreteControler );
		moteurStub.addBPMObs( concreteControler );
		moteurStub.addTempoObs( concreteControler );
		
	}

	@After
	public void tearDown() throws Exception {
		
		horlogeStub = null;
		afficheurMock = null;
		moletteMock = null;
		emetteurSonoreMock = null;
		viewStub = null;
		moteurStub = null;
		concreteControler = null;
		
	}

	@Test
	public void testConcreteControler() {
		
		assertNotNull( concreteControler );
		
	}

	@Test
	public void testConvertInBPM() {
		assertEquals( 50,concreteControler.convertInBPM( 0.25 ) );
		assertEquals( 100,concreteControler.convertInBPM( 0.5 ) );
		assertEquals( 150,concreteControler.convertInBPM( 0.75 ) );
		assertEquals( 200,concreteControler.convertInBPM( 1 ) );
	}

	@Test
	public void testGetAfficheur() {
		assertNotNull( concreteControler.getAfficheur() );
	}

	@Test
	public void testGetEmetteurSonore() {
		assertNotNull( concreteControler.getEmetteurSonore() );
	}

	@Test
	public void testGetHorloge() {
		assertNotNull( concreteControler.getHorloge() );
	}

	@Test
	public void testGetManage() {
		assertNotNull( concreteControler.getManage() );
	}

	@Test
	public void testSetManage() {
		//setManage is done on setup just check if reference return by call to getManage is not null
		assertNotNull(concreteControler.getManage());
	}

	@Test
	public void testActualiseTempo() {
		moteurStub.run();
		moteurStub.setTempo( 3 );
		assertTrue( horlogeStub.activerPeriodiquement );
	}

	@Test
	public void testActualiseBPM() {
		moteurStub.run();
		moteurStub.setBPM( 110 );
		assertTrue( horlogeStub.activerPeriodiquement );
	}

	@Test
	public void testStart() {
		concreteControler.start();
		assertTrue(moteurStub.isEtatMarche());
	}

	@Test
	public void testStop() {
		concreteControler.stop();
		assertFalse(moteurStub.isEtatMarche());
	}

	@Test
	public void testActualisePresentationBPM() {
		concreteControler.actualisePresentationBPM();
		//System.out.println("bmp is:" + moteurStub.getBPM() );
		assertEquals( 150, moteurStub.getBPM() );
	}

	@Test
	public void testDecTempo() {
		concreteControler.decTempo();
		assertEquals( 2, moteurStub.getTempo() );
		concreteControler.incTempo();
		concreteControler.decTempo();
		assertEquals( 2, moteurStub.getTempo() );
	}

	@Test
	public void testIncTempo() {
		assertEquals( 2, moteurStub.getTempo() );
		concreteControler.incTempo();
		assertEquals( 3, moteurStub.getTempo() );
		concreteControler.incTempo();
		assertEquals( 4, moteurStub.getTempo() );
		concreteControler.incTempo();
		assertEquals( 5, moteurStub.getTempo() );
		concreteControler.incTempo();
		assertEquals( 6, moteurStub.getTempo() );
		concreteControler.incTempo();
		assertEquals( 7, moteurStub.getTempo() );
		concreteControler.incTempo();
		assertEquals( 7, moteurStub.getTempo() );
		
	}

	@Test
	public void testGetPresente() {
		assertNotNull( concreteControler.getPresente() );
	}

	@Test
	public void testSetPresente() {
		//use set setPresent in setup then just check if return reference 
		//per call of getPresente operation is not null
		assertNotNull( concreteControler.getPresente() );
	}

}
