package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import canal.Canal;

/**
 * 
 * RMI screen bridge
 *
 */
public class RMIChannelBridge extends UnicastRemoteObject {

	/**
	 * Constructor take in parameter the distant canal.
	 * @param canalrmi
	 * @throws RemoteException
	 */
	public RMIChannelBridge(Canal canalrmi)throws RemoteException{
		super();
		rmiChannel = canalrmi;
		this.updated = new checkUpdate();
	}
	
	public static void main(String...args){
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext( "TAORMIClient.xml" );
		RMIChannelBridge channel = ( RMIChannelBridge ) beanFactory.getBean( "rmiBridge" );
		try {
			channel.setScreen4( (ScreenImplRMI) beanFactory.getBean( "screen4" ));
			channel.getRmiChannel().attach( channel.getScreen4() );
			( (ScreenImplRMI) channel.getScreen4() ).setChannel(channel);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			System.out.println("exception");
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * CheckUpdate class used to check when canal is up to date. Extends Thread. 
	 *
	 */
	class checkUpdate extends Thread{
		
		/**
		 * Check each second whether sensor value is updated.
		 */
		public void run(){
			while( live ){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if( getRmiChannel().getTicket( screen4.getID() ) != null &&
						getRmiChannel().getTicket( screen4.getID() ).getKey() != -1)
						( ( ScreenImplRMI ) screen4 ).setValue( getRmiChannel().getTicket( screen4.getID() ) );
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NullPointerException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public boolean isLive() {
			return live;
		}
		
		public void setLive(boolean live) {
			this.live = live;
		}
		
		/**
		 * Pooling sensor thread is running if true.
		 */
		private boolean live;
		
	}
	
	public Screen getScreen4() {
		return screen4;
	}

	/**
	 * setScreen4 initiate screen for reference class member and launch pooling thread on sensor.
	 * @param screen4
	 */
	public void setScreen4(Screen screen4) {
		this.screen4 = screen4;
		updated.setLive(true);
		updated.start();
	}
	
	public Canal getRmiChannel() {
		return rmiChannel;
	}

	public void setRmiChannel(Canal rmiChannel) {
		this.rmiChannel = rmiChannel;
	}
	
	/**
	 * Finish sensor pooling thread if alive. Wait as far as the end of pooling thread.
	 * Detach screen4 member from the distant canal.
	 */
	public void finalize(){
		updated.setLive( false );
		while( updated.isLive() );
		try {
			getRmiChannel().detach( getScreen4() );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Distant canal.
	 */
	private Canal rmiChannel = null;
	
	/**
	 * Screen to attach on distant canal.
	 */
	private Screen screen4;
	
	/**
	 * Sensor pooling thread on distant sensor.
	 */
	private checkUpdate updated;
	
	private static final long serialVersionUID = 4625659440726061848L;
	
}