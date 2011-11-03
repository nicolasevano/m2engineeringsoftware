package metronome.view;

import java.util.Map;
import java.util.TreeMap;

import metronomelogic.Horloge;
import metronomelogic.command.Command;

public class HorlogeSimulate implements Horloge {

	@Override
	public void activerAprésDélai( Command cmd, double périodeEnSecondes ) {
		// TODO Auto-generated method stub
		new ActiverAprésDélai( cmd, périodeEnSecondes );
	}

	@Override
	public void activerPeriodiquement( Command cmd, double périodeEnSecondes ) {
		// TODO Auto-generated method stub
		threads.put( cmd.getName(), new ActiverPeriodiquement( cmd, périodeEnSecondes ) );
		System.out.println("add command: " + cmd.getName());
		System.out.println("delay is: " + périodeEnSecondes);
	}

	@Override
	public void désactiver(Command cmd) {
		// TODO Auto-generated method stub
		if( threads.get( cmd.getName() ) != null ){
			threads.get( cmd.getName() ).setMarche( false );
			System.out.println("remove command name: " + cmd.getName());
			threads.remove( cmd.getName() );
		}
	}

	class ActiverPeriodiquement extends Thread{
		ActiverPeriodiquement( Command cmd,double périodeEnSecondes ){
			this.delay =  (long) (Double.valueOf( périodeEnSecondes ) * 1000);
			System.out.println("delay in ms is: " + delay);
			this.command = cmd;
			this.start();
		}
		
		public void run(){
			while( isMarche() ){
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				command.execute();
			}
		}
		
		public Command getCommand() {
			return command;
		}

		public void setCommand(Command command) {
			this.command = command;
		}
		
		public boolean isMarche() {
			return marche;
		}

		public void setMarche(boolean marche) {
			this.marche = marche;
		}
		
		private boolean marche = true;
		
		private long delay;
		
		private Command command;

	}
	
	class ActiverAprésDélai extends Thread{
		ActiverAprésDélai( Command cmd, double périodeEnSecondes ){
			this.delay =  (long) (Double.valueOf( périodeEnSecondes ) * 100);
			this.command = cmd;
			this.start();
		} 
		
		public void run(){
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			command.execute();
		}
		
		public Command getCommand() {
			return command;
		}

		public void setCommand(Command command) {
			this.command = command;
		}
		
		private long delay;
		
		private Command command;
	}
	
	private Map <String,ActiverPeriodiquement> threads = 
		new TreeMap<String,ActiverPeriodiquement>();
}
