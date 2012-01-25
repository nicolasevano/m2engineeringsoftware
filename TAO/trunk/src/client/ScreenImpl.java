package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sensor.EntryVersion;


import canal.CallableServant;

public class ScreenImpl extends JPanel implements Screen {
	
	
	/**
	 * public Screen implementation constructor
	 * @param number integer screen id
	 */
	public ScreenImpl( int number){
		this.id = number;
		setLayout(new GridLayout(2,2));
		this.add( new JLabel("sensor value:") );
		this.add( new JLabel( "version:" ) );
		screenValue = new JLabel( "0" );
		screenValue.setPreferredSize( new Dimension( 50, 50 ) );
		screenValue.setSize( new Dimension( 50, 50 ) );
		this.add(screenValue);
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
		JFrame containerScreen = new JFrame( "screen " + id );
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
	 * @param value CallableServant outputCallable.
	 */
	@Override
	public void update(CallableServant outputCallable) {
		// TODO Auto-generated method stub
		//screenValue.setText( String.valueOf( value ) );
		System.out.println("screen get subject notification!");
		ScheduledFuture<EntryVersion> f1 = outputCallable.getValue();
		while( !f1.isDone() );
		try {
			if( getLastOne() != null && f1.get().getKey() < getLastOne().getKey() ){
				screenValue.setText( "" + getLastOne().getValue() );
				version.setText("" + getLastOne().getKey());
			} else {
				screenValue.setText( "" + f1.get().getValue() );
				version.setText("" + f1.get().getKey());
				setLastOne( f1.get() );
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	static private synchronized EntryVersion getLastOne(){
		return ScreenImpl.lastOne;
	}
	
	static private synchronized void setLastOne( EntryVersion newLastOne ){
		ScreenImpl.lastOne = newLastOne;
	}
	
	/**
	 * screen label for sensor value
	 */
	private JLabel screenValue;
	
	/**
	 * screen label version number
	 */
	private JLabel version;
	
	/**
	 * current screen id
	 */
	private int id;
	
	/**
	 * last one sensor value version shared
	 */
	private static EntryVersion lastOne;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
