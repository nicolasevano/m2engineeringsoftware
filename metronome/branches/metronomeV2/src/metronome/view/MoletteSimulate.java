package metronome.view;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import metronomelogic.Molette;

public class MoletteSimulate extends JPanel implements Molette {

	MoletteSimulate(){
		
		molette = new JSlider( JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT );
		molette.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
			    JSlider source = (JSlider)e.getSource();
			    position = ( Double.valueOf( source.getValue() ) / Double.valueOf( 200 ) );
			    //presenteMolette.notifyBPM();
			}
		});

		//Turn on labels at major tick marks.
		molette.setMajorTickSpacing(50);
		molette.setMinorTickSpacing(25);
		molette.setPaintTicks( true );
		molette.setPaintLabels( true );
		add( molette );
		
	}
	
	@Override
	public double position() {
		
		return position;
		
	}
	
	private static final int FPS_MIN = 0;
	private static final int FPS_MAX = 200;
	private static final int FPS_INIT = 100;    //initial frames per second
	
	private double position = (Double.valueOf(FPS_INIT) / Double.valueOf(200));
	
	private JSlider molette;
	
	@SuppressWarnings("unused")
	private View presenteMolette;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
