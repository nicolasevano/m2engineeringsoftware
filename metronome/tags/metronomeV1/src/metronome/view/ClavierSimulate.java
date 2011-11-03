package metronome.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import metronomelogic.Clavier;

public class ClavierSimulate extends JPanel implements Clavier {

	ClavierSimulate(View view){
		this.presenteClavier = view;
		keyStart = new JButton( "Start" );
		keyStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenteClavier.getControler().start();
			}
			
		});
		add( keyStart );
		keyStop = new JButton( "Stop" );
		keyStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenteClavier.getControler().stop();
			}
			
		});
		add( keyStop );
		keyInc = new JButton( "Inc" );
		keyInc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenteClavier.getControler().incTempo();
			}
			
		});
		add ( keyInc );
		keyDec = new JButton( "Dec" );
		keyDec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenteClavier.getControler().decTempo();
			}
			
		});
		add( keyDec );
	}
	
	@Override
	public boolean touchePressée(int key) {
		boolean result = keyPresseds[ key ];
		keyPresseds[ key ] = false;
		return result;
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
	
	private View presenteClavier; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
