package metronome.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import metronomelogic.Clavier;
import metronomelogic.controler.Controler;

public class ClavierSimulate extends JPanel implements Clavier {

	ClavierSimulate(){
		keyStart = new JButton( "Start" );
		//keyStart.addActionListener(new ActionListener() {
			
		//	@Override
		//	public void actionPerformed(ActionEvent e) {
				//presenteClavier.getControler().start();
		//		System.out.println(e.getActionCommand());
		//		if( e.getID() == MouseEvent.MOUSE_PRESSED){
		//			keyPresseds[View.KEY_START] = true;
		//		} else {
		//			keyPresseds[View.KEY_START] = false;
		//		}
		//	}
			
		//});
		keyStart.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println( ( ( ButtonModel ) arg0.getSource() ).getActionCommand() );
				ButtonModel model = ( ( JButton ) arg0.getSource() ).getModel();
				if( /*"Start".equals( ( ( JButton ) arg0.getSource() ).getActionCommand() )*/model.isPressed()){
					keyPresseds[View.KEY_START] = true;
				} else {
					keyPresseds[View.KEY_START] = false;
				}
			}
		});
		add( keyStart );
		keyStop = new JButton( "Stop" );
		//keyStop.addActionListener(new ActionListener() {
			
		//	@Override
		//	public void actionPerformed(ActionEvent e) {
				//presenteClavier.getControler().stop();
		//		System.out.println(e.getActionCommand());
		//		if( e.getID() == MouseEvent.MOUSE_PRESSED){
		//			keyPresseds[View.KEY_STOP] = true;
		//		} else {
		//			keyPresseds[View.KEY_STOP] = false;
		//		}
		//	}
		
		//});
		keyStop.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
				ButtonModel model = ( ( JButton ) arg0.getSource() ).getModel();
				if( /*"Stop".equals( ( ( JButton ) arg0.getSource() ).getActionCommand() )*/model.isPressed() ){
					keyPresseds[View.KEY_STOP] = true;
				} else {
					keyPresseds[View.KEY_STOP] = false;
				}
			}
		});
		add( keyStop );
		keyInc = new JButton( "Inc" );
		//keyInc.addActionListener(new ActionListener() {
			
		//	@Override
		//	public void actionPerformed(ActionEvent e) {
				//presenteClavier.getControler().incTempo();
		//		System.out.println(e.getActionCommand());
		//		if( e.getID() == MouseEvent.MOUSE_PRESSED){
		//			keyPresseds[View.KEY_INC] = true;
		//		} else {
		//			keyPresseds[View.KEY_INC] = false;
		//		}
		//	}
			
		//});
		keyInc.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				ButtonModel model = ( ( JButton ) arg0.getSource() ).getModel();
				if( /*"Inc".equals( ( ( JButton ) arg0.getSource() ).getActionCommand() )*/model.isPressed() ){
					keyPresseds[View.KEY_INC] = true;
				} else {
					keyPresseds[View.KEY_INC] = false;
				}
			}
		});
		add ( keyInc );
		keyDec = new JButton( "Dec" );
		//keyDec.addActionListener(new ActionListener() {
			
		//	@Override
		//	public void actionPerformed(ActionEvent e) {
				//presenteClavier.getControler().decTempo();
		//		System.out.println(e.getActionCommand());
		//		if( e.getID() == MouseEvent.MOUSE_PRESSED){
		//			keyPresseds[View.KEY_DEC] = true;
		//		} else {
		//			keyPresseds[View.KEY_DEC] = false;
		//		}
		//	}
			
		//});
		keyDec.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				ButtonModel model = ( ( JButton ) arg0.getSource() ).getModel();
				if( /*"Dec".equals( ( ( JButton ) arg0.getSource() ).getActionCommand() )*/model.isPressed() ){
					keyPresseds[View.KEY_DEC] = true;
				} else {
					keyPresseds[View.KEY_DEC] = false;
				}
			}
		});
		add( keyDec );
	}
	
	@Override
	public boolean touchePressée(int key) {
		//boolean result = keyPresseds[ key ];
		//keyPresseds[ key ] = false;
		return keyPresseds[ key ];
	}
	
	//No use in this implementation
	private boolean [] keyPresseds = new boolean[]{
			false,
			false,
			false,
			false,
			false,
	};
	
	private JButton keyStart;
	
	private JButton keyStop;
	
	private JButton keyInc;
	
	private JButton keyDec;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
