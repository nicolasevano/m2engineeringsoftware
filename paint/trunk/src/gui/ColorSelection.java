package gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorSelection extends JPanel{
	public ColorSelection(Editeur currentEdit){
		 
		 this.currentEditeur = currentEdit;
		 this.setLayout( new GridLayout(1,2) );
		 buildShapeColorSelection();
		 buildBackgoundColorSelection();
	}
	
	private void buildShapeColorSelection(){
		JPanel shapeColors = new JPanel();
		shapeColors.setLayout( new GridLayout( 11,1 ) );
		shapeColors.add(new JLabel("Couleur de dessin:"));
		setColorCheckBox(switchOrange, Color.ORANGE,"orange",false,shapeColors);
		setColorCheckBox(switchYellow, Color.YELLOW,"jaune",false,shapeColors);
		setColorCheckBox(switchBlue, Color.BLUE,"bleu",true,shapeColors);
		setColorCheckBox(switchCyan, Color.CYAN,"cyan",false,shapeColors);
		setColorCheckBox(switchRed, Color.RED,"rouge",false,shapeColors);
		setColorCheckBox(switchBlack, Color.BLACK,"noire",false,shapeColors);
		setColorCheckBox(switchGray, Color.DARK_GRAY,"gris",false,shapeColors);
		setColorCheckBox(switchGreen, Color.GREEN,"vert",false,shapeColors);
		setColorCheckBox(switchMagenta, Color.MAGENTA,"magenta",false,shapeColors);
		setColorCheckBox(switchWhite, Color.WHITE,"blanc",false,shapeColors);
		this.add(shapeColors);
	}
	
	private void buildBackgoundColorSelection(){
		JPanel backGroundColors = new JPanel();
		backGroundColors.setLayout( new GridLayout( 11,1 ) );
		backGroundColors.add(new JLabel("Couleur de fond:"));
		Checkbox toSet = null;
		setColorCheckBoxBackGround(toSet, Color.ORANGE,"orange",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.YELLOW,"jaune",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.BLUE,"bleu",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.CYAN,"cyan",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.RED,"rouge",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.BLACK,"noire",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.DARK_GRAY,"gris",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.GREEN,"vert",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.MAGENTA,"magenta",false,backGroundColors);
		setColorCheckBoxBackGround(toSet, Color.WHITE,"blanc",true,backGroundColors);
		this.add(backGroundColors);
	}
	
	private void setColorCheckBox(Checkbox toAdd, final Color colorRef,String label,boolean selected,JPanel used){
		JPanel tmpPanel;
		JPanel tmpColorPanel;
		toAdd = new Checkbox(label, cbg, selected);
		toAdd.addItemListener( new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				//AbstractButton abstractButton = (AbstractButton)arg0.getSource();
		        int state = arg0.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		        	(( ZoneDeDessin )currentEditeur.getZoneDessin()).setCurrentColor(colorRef);
		        }
			} 
		 });
		
		tmpPanel = new JPanel();
		tmpPanel.setLayout( new GridLayout( 1,2 ) );
		tmpPanel.add( toAdd );
		tmpColorPanel = new JPanel();
		tmpColorPanel.setSize(50,50);
		tmpColorPanel.setPreferredSize( new Dimension( 50,50 ) );
		tmpColorPanel.setBackground(colorRef);
		tmpPanel.add( tmpColorPanel );
		used.add(tmpPanel);
	}
	
	private void setColorCheckBoxBackGround(Checkbox toAdd, final Color colorRef,String label,boolean selected,JPanel used){
		JPanel tmpPanel;
		JPanel tmpColorPanel;
		toAdd = new Checkbox(label, cbgBackgroud, selected);
		toAdd.addItemListener( new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				//AbstractButton abstractButton = (AbstractButton)arg0.getSource();
		        int state = arg0.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		        	(( ZoneDeDessin )currentEditeur.getZoneDessin()).setBackground(colorRef);
		        }
			} 
		 });
		
		tmpPanel = new JPanel();
		tmpPanel.setLayout( new GridLayout( 1,2 ) );
		tmpPanel.add( toAdd );
		tmpColorPanel = new JPanel();
		tmpColorPanel.setSize(50,50);
		tmpColorPanel.setPreferredSize( new Dimension( 50,50 ) );
		tmpColorPanel.setBackground(colorRef);
		tmpPanel.add( tmpColorPanel );
		used.add(tmpPanel);
	}
	
	JFrame getJFrameParent(Container possibleJFrame){
		return (JFrame) ( ( possibleJFrame.getParent() != null )? 
				getJFrameParent( possibleJFrame.getParent() ): possibleJFrame );
	}
	
	private Checkbox switchOrange;
	
	private Checkbox switchBlue;
	
	private Checkbox switchYellow;
	
	private Checkbox switchRed; 
	
	private Checkbox switchCyan;
	
	private Checkbox switchBlack;
	
	private Checkbox switchGray;
	
	private Checkbox switchGreen;
	
	private Checkbox switchMagenta;
	
	private Checkbox switchWhite;
	
	CheckboxGroup cbg = new CheckboxGroup();
	
	CheckboxGroup cbgBackgroud = new CheckboxGroup();
	
	private IEditeur currentEditeur; 
	
	//private Command currentCommand;
	
	private static final long serialVersionUID = 1L;
}
