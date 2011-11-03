package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import command.Command;

public class DessinMotionListener extends MouseMotionAdapter {
	//motionCircle( e.getPoint() );
	public void mouseDragged(MouseEvent e){
		if( currentCommand != null ){
			currentCommand.execute( e.getPoint() );
		}
	}
	
	public Command getCurrentCommand() {
		return currentCommand;
	}

	public void setCurrentCommand(Command currentCommand) {
		this.currentCommand = currentCommand;
	}
	
	private Command currentCommand;
}
