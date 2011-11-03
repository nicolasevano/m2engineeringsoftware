package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

import command.Command;
import command.DrawCircle;
import command.DrawElipse;
import command.DrawEmptyCircle;
import command.DrawEmptyElipse;
import command.DrawEmptyRectangle;
import command.DrawLeftTriangle;
import command.DrawRectangle;
import command.DrawRightTriangle;
import command.DrawTopTriangle;
import command.DrawTriangle;
import command.ResizeSelection;

public class ShapeSelection extends JPanel {

	public ShapeSelection(Editeur currentEdit){
		
		 this.currentEditeur = currentEdit;
		
		 rectangle = new JButton( "rectangle" );
		 rectangle.setMnemonic(KeyEvent.VK_R);
		 rectangle.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
				currentCommand = new DrawRectangle();
				currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
				(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
			}
			 
		 });
		 circle = new JButton( "cercle" );
		 circle.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_C );
		 
		 circle.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawCircle();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );
		 
		 emptyCircle = new JButton( "empty cercle" );
		 emptyCircle.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_E );
		 
		 emptyCircle.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawEmptyCircle();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );
		 
		 emptyRectangle = new JButton( "empty rectangle" );
		 emptyRectangle.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_T );
		 
		 emptyRectangle.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawEmptyRectangle();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );
		 
		 elipse = new JButton( "elipse" );
		 elipse.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_S );
		 
		 elipse.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawElipse();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );
		 
		 emptyElipse = new JButton( "empty elipse" );
		 emptyElipse.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_S );
		 
		 emptyElipse.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawEmptyElipse();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );
		 
		 triangle = new JButton( "triangle" );
		 triangle.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_G );
		 
		 triangle.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawTriangle();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );
		 
		 leftTriangle = new JButton( "triangle droit" );
		 leftTriangle.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_D );
		 
		 leftTriangle.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawLeftTriangle();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );
		 
		 rightTriangle = new JButton( "triangle gauche" );
		 rightTriangle.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_A );
		 
		 rightTriangle.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawRightTriangle();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );
		 
		 topTriangle = new JButton( "triangle haut" );
		 topTriangle.setMnemonic(/*KeyEvent.VK_D*/ KeyEvent.VK_H );
		 
		 topTriangle.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentCommand != null && currentCommand instanceof ResizeSelection)( ( ResizeSelection ) currentCommand ).endResize();
					currentCommand = new DrawTopTriangle();
					currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
					(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
				}
				 
			 } );

		 
		 //selection = new JButton ( "selection" );
		 //selection.setMnemonic( KeyEvent.VK_S );
		 //selection.addActionListener( new ActionListener(){
		 //	 @Override
		 //	 public void actionPerformed(ActionEvent arg0) {
		 //		 currentCommand = new ReplaceDessin();
		 //		 currentCommand.setPlan( ( JPanel ) currentEditeur.getZoneDessin() );
		 //		 (( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentCommand(currentCommand);
		 //	 }
		 //});
		 
		 setLayout( new GridLayout( 10,1 ) );
		 add( rectangle );
		 add( circle );
		 add( emptyRectangle );
		 add( emptyCircle );
		 add( elipse );
		 add( emptyElipse );
		 add( triangle );
		 add( leftTriangle );
		 add( rightTriangle );
		 add( topTriangle );
		 //add( selection );
	}
	
	JFrame getJFrameParent(Container possibleJFrame){
		return (JFrame) ( ( possibleJFrame.getParent() != null )? 
				getJFrameParent( possibleJFrame.getParent() ): possibleJFrame );
	}
	
	private JButton rectangle;
	
	private JButton circle;
	
	private JButton emptyCircle;
	
	private JButton emptyRectangle;
	
	private JButton elipse;
	
	private JButton emptyElipse;
	
	private JButton triangle;
	
	private JButton leftTriangle;
	
	private JButton rightTriangle;
	
	private JButton topTriangle;
	
	private IEditeur currentEditeur; 
	
	private Command currentCommand;
	
	private static final long serialVersionUID = 1L;
	
}
