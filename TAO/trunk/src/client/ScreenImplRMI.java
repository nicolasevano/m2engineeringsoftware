package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sensor.EntryVersion;

import canal.CallableServant;

public class ScreenImplRMI extends JPanel implements Screen, Serializable{

	/**
	 * public Screen implementation constructor
	 * @param number integer screen id
	 */
	public ScreenImplRMI( int id ){
		this.id = id;
		setLayout( new GridLayout( 2,2 ) );
		this.add( new JLabel("sensor value:") );
		this.add( new JLabel( "version:" ) );
		screenValue = new JLabel( "0" );
		screenValue.setPreferredSize( new Dimension( 50, 50 ) );
		screenValue.setSize( new Dimension( 50, 50 ) );
		this.add( screenValue );
		version = new JLabel( "0" );
		version.setPreferredSize( new Dimension( 50, 50 ) );
		version.setSize( new Dimension( 50, 50 ) );
		this.add( version );
		buildFrame();
	}

	/**
	 * Build JFrame that contains the screen id
	 */
	public void buildFrame(){
		JFrame containerScreen = new JFrame( "screen RMI" + id );
		containerScreen.addWindowListener( new Finisher() );
		containerScreen.getContentPane().add( BorderLayout.CENTER, this );
		containerScreen.getContentPane().setPreferredSize( new Dimension( 200,100 ) );
		containerScreen.getContentPane().setSize( new Dimension( 200,100 ) );
		containerScreen.pack();
		containerScreen.setVisible( true );
	}
	
	/**
	 * Close handler on JFrame inner class definition.
	 */
	class Finisher extends WindowAdapter {

		public void windowClosing(WindowEvent e){
			System.exit( 0 );
		}
		
	}
	
	/** 
	 * Update function change displayed value on screen.
	 * @param value int.
	 */
	@Override
	public void update(CallableServant outputCallable) {
		// TODO Auto-generated method stub
		//screenValue.setText( String.valueOf( value ) );
		System.out.println("screen get subject notification RMI!");
		outputCallable.getValue();
		//better wait to do it with a factory
		EntryVersion result = new EntryVersion( -1, -1, -1 );
		System.out.println( "waitting for value" );
		do{
			try {
				
				System.out.println( "one round." );
				result = channel.getRmiChannel().getTicket( id );
				System.out.println( "ticket ready: " + result.getValue() );
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println( "exception" );
				e.printStackTrace();
			} 
			
		} while ( result.getKey() != -1 );
		screenValue.setText( "" + result.getValue() );
	}

	
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	/**
	 * set screen with new sensor version value
	 * @param newOne
	 */
	public void setValue( EntryVersion newOne ){
		screenValue.setText( "" + newOne.getValue() );
		version.setText( "" + newOne.getKey() );
	}
	
	public RMIChannelBridge getChannel() {
		return channel;
	}

	public void setChannel(RMIChannelBridge channel) {
		this.channel = channel;
	}
	
	/**
	 * screen label for sensor value.
	 */
	private JLabel screenValue;
	
	/**
	 * display version number
	 */
	private JLabel version;
	/**
	 * current screen id.
	 */
	private int id;
	
	/**
	 * distant canal.
	 */
	private RMIChannelBridge channel;
	
	private static final long serialVersionUID = 1L;

}