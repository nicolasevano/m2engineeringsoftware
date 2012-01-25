package canal;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import client.Screen;


import sensor.EntryVersion;
import sensor.Sensor;

public class CanalImpl implements SensorServiceObserver, Canal{
	
	public CanalImpl(Sensor sensor, int delay)throws RemoteException{
		this.delay = delay;
		this.access = sensor;
		updateScheduler = Executors.newScheduledThreadPool(1);
		getValueScheduler = Executors.newScheduledThreadPool(1);
	}
	
	/* (non-Javadoc)
	 * @see Canal#attach(Screen)
	 */
	@Override
	/**
	 * Attach function screen implementation to a canal
	 * @param screen
	 */
	public void attach(Screen screen) throws RemoteException{
		screens.add( screen );
	}
	
	/* (non-Javadoc)
	 * @see Canal#detach(Screen)
	 */
	@Override
	/**
	 * Detach function a screen implementation from a canal(if and only if attached before)
	 * @param screen
	 */
	public void detach( Screen screen ) throws RemoteException{
		screens.remove( screen );
	}
	
	/* (non-Javadoc)
	 * @see Canal#update(Sensor)
	 */
	@Override
	/**
	 * Update function notify that current sensor value has been updated
	 */
	public void update(){
		for( final Screen screen : screens ){
			CallableServant update = new CallableServant(){

				@Override
				public void update(Canal epoqueCP) {
					// TODO Auto-generated method stub
				}

				@Override
				public ScheduledFuture<EntryVersion> getValue(){
					ScheduledFuture<EntryVersion> result = null;
					try {
						result = canal.getValue(screen.getID());
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return result;
				}

				@Override
				public EntryVersion call() throws Exception {
					// TODO Auto-generated method stub
					screen.update( this );
					return null;
				}

				@Override
				public void setCanal(Canal canal){
					this.canal = canal;
				}			
				private Canal canal;
			};
			update.setCanal(this);
			( ( ScheduledExecutorService ) updateScheduler ).schedule( 
					update, 
					generator.nextInt(1000) + 1/*delay*/, 
					TimeUnit.MILLISECONDS );
		}
	}
	
	/* (non-Javadoc)
	 * @see Canal#getValue()
	 */
	@Override
	/**
	 * GetValue function allow to get a future on the new sensor value when it's ready 
	 * @return ScheduledFuture<integer> ticket sensor value
	 */
	public ScheduledFuture<EntryVersion> getValue(final int ID)throws RemoteException{
		System.out.println("Canal try to get back new value on sensor.");
		tickets.put( ID, new EntryVersion( -1,-1,-1 ) );
		CallableServant getValue = new CallableServant(){
			@Override
			public ScheduledFuture<EntryVersion> getValue() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setCanal(Canal canal) {
				// TODO Auto-generated method stub
				this.canal = canal;
			}

			@Override
			public void update(Canal epoqueCP) {
				// TODO Auto-generated method stub
			}

			@Override
			public EntryVersion call() throws Exception {
				// TODO Auto-generated method stub
				EntryVersion result;
				result = canal.getSensor().getValue();
				System.out.println("new value get:" + result);
				tickets.put(ID,result);
				return result;
			}
			private Canal canal;
		};
		
		getValue.setCanal( this );
		final ScheduledFuture<EntryVersion> f1 = ( ( ScheduledExecutorService ) getValueScheduler ).schedule( 
				getValue, 
				generator.nextInt(1000) + 1/*delay*/, 
				TimeUnit.MILLISECONDS );
		return f1;
	}
	
	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
	
	/* (non-Javadoc)
	 * @see Canal#getSensor()
	 */
	@Override
	/**
	 * GetSensor function return this attached sensor
	 * @return Sensor
	 * @throws RemoteException
	 */
	public Sensor getSensor()throws RemoteException{
		return this.access;
	}
	
	@Override
	/**
	 * GetTickets function return screen tickets
	 * @return Map<Integer,Integer>
	 * @throws RemoteException
	 */
	public Map<Integer, EntryVersion> getTickets()throws RemoteException {
		return tickets;
	}
	
	@Override
	/**
	 * GetTicket function return screen ticket
	 * @param id
	 * @return integer
	 * @throws RemoteException
	 */
	public EntryVersion getTicket( int id )throws RemoteException{
		return tickets.get( id );
	}
	
	/** screen notification executor */
	private ExecutorService updateScheduler;
	
	/** ticket sensor value executor */
	private ExecutorService getValueScheduler;
	
	/** delay execution for each callableServant */
	private int delay;
	
	/** current sensor on which canal is observer */
	private Sensor access;
	
	/** subscribed screen list */
	private List<Screen> screens = new ArrayList<Screen>();
	
	/** random number generator */
	private Random generator = new Random();
	
	/** ticket list for remote observer*/
	private Map< Integer, EntryVersion > tickets= new TreeMap<Integer, EntryVersion >();

	/**
	 * 
	 */
	private static final long serialVersionUID = 627186336165910579L;
}
