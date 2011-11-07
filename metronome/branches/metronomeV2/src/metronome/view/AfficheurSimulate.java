package metronome.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import metronomelogic.Afficheur;

public class AfficheurSimulate extends JPanel implements Afficheur {
	
	AfficheurSimulate(){
		setLayout(new GridLayout(2,3));
		this.add( new JLabel("bpm:") );
		this.add( new JLabel("bpm led:") );
		this.add( new JLabel("tempo led:") );
		tempoScreen = new JLabel( "100" );
		tempoScreen.setPreferredSize( new Dimension( 50, 50 ) );
		tempoScreen.setSize( new Dimension( 50, 50 ) );
		tempoScreen.setBackground( Color.RED );
		this.add( tempoScreen );
		LED1 = new JPanel();
		LED1.setPreferredSize( new Dimension( 50, 50 ) );
		LED1.setSize( new Dimension( 50, 50 ) );
		LED1.setBackground(Color.BLACK);
		this.add(LED1);
		LED2 = new JPanel();
		LED2.setPreferredSize( new Dimension( 50, 50 ) );
		LED2.setSize( new Dimension( 50, 50 ) );
		LED2.setBackground(Color.BLACK);
		this.add(LED2);
	}
	
	@Override
	public void afficherLED(int led) {
		// TODO Auto-generated method stub
		if(led == 1){
			LED1.setBackground( Color.RED );
		} else if(led == 2){
			LED2.setBackground( Color.GREEN );
		}
	}

	@Override
	public void afficherTempo(int tempo) {
		// TODO Auto-generated method stub
		tempoScreen.setText( String.valueOf( tempo ) );
	}

	@Override
	public void etteindreLED(int led) {
		// TODO Auto-generated method stub
		if(led == 1){
			LED1.setBackground( Color.BLACK );
		} else if(led == 2){
			LED2.setBackground( Color.BLACK );
		}
	}
	
	private JLabel tempoScreen;
	
	private JPanel LED1;
	
	private JPanel LED2;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
