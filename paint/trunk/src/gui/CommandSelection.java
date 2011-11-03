package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import command.Command;
import command.RemoveDessinCmd;
import command.ReplaceDessin;
import command.ResizeSelection;
import command.Zoom;

public class CommandSelection extends JPanel{

	public CommandSelection( Editeur currentEditeur ){
		this.editeur = currentEditeur;
		setLayout( new GridLayout( 1,4 ) );
		
		moveSelection = new JButton( " Deplacer " );
		moveSelection.setMnemonic( KeyEvent.VK_P );
		
		moveSelection.addActionListener( new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
				 currentCommand = new ReplaceDessin();
				 currentCommand.setPlan( ( JPanel ) editeur.getZoneDessin() );
				 ( ( ZoneDeDessin )editeur.getZoneDessin() ).setCurrentCommand( currentCommand );
			 }
		 });
		
		removeSelection = new JButton( " Supprimer " );
		removeSelection.setMnemonic( KeyEvent.VK_I );
		
		removeSelection.addActionListener( new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
				 currentCommand = new RemoveDessinCmd();
				 currentCommand.setPlan( ( JPanel ) editeur.getZoneDessin() );
				 ( ( ZoneDeDessin )editeur.getZoneDessin() ).setCurrentCommand( currentCommand );
			 }
		 });
		
		zoomSelection = new JButton( " Zoom " );
		zoomSelection.setMnemonic( KeyEvent.VK_Z );
		
		zoomSelection.addActionListener( new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
				 currentCommand = new Zoom();
				 currentCommand.setWheelMouse( true );
				 currentCommand.setPlan( ( JPanel ) editeur.getZoneDessin() );
				 ( ( ZoneDeDessin )editeur.getZoneDessin() ).setCurrentCommand( currentCommand );
			 }
		 });
		
		resizeSelection = new JButton( " Redimentioner " );
		resizeSelection.setMnemonic( KeyEvent.VK_M );
		resizeSelection.addActionListener( new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 if( !( currentCommand instanceof ResizeSelection ) ){
					 currentCommand = new ResizeSelection( resizeSelection );
					 currentCommand.setPlan( ( JPanel ) editeur.getZoneDessin() );
					 ( ( ZoneDeDessin )editeur.getZoneDessin() ).setCurrentCommand( currentCommand );
				 } else if( ( ( ZoneDeDessin ) currentCommand.getPlan() ).getSelected() != null ){
					 ( ( ResizeSelection ) currentCommand ).endResize();
				 }
			 }
		 });
		
		add( removeSelection );
		add( resizeSelection );
		add( zoomSelection );
		add( moveSelection );
	}
	
	private Command currentCommand;
	
	private JButton removeSelection;
	
	private JButton resizeSelection;
	
	private JButton zoomSelection;
	
	private JButton moveSelection;
	
	private Editeur editeur;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
