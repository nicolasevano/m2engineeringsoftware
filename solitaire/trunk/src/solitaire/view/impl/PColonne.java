package solitaire.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import solitaire.controler.ICColonne;
import solitaire.controler.IControlCarteRetournable;
import solitaire.controler.impl.CColonne;
import solitaire.listener.RetournerCarteListener;
import solitaire.stringloader.IConfigurationLoader;
import solitaire.view.IPColonne;
import solitaire.view.IPTasDeCartes;
import solitaire.view.IUpdateString;
import solitaire.view.IViewDoubleTas;

public class PColonne extends JScrollPane implements IViewDoubleTas, IPColonne,IUpdateString{
	
	public PColonne(IPTasDeCartes v, IPTasDeCartes c){
		JPanel inside = new JPanel();
		inside.setLayout( /*new GridLayout( 2,1 )*/new BoxLayout(inside, BoxLayout.Y_AXIS) );
		( ( PTasDeCartes ) c ).setPreferredSize( new Dimension( PCarte.largeur + 15, PCarte.hauteur + 50  ) );
		( ( PTasDeCartes ) c ).setSize( new Dimension( PCarte.largeur + 15, PCarte.hauteur + 50  ) );
		( ( PTasDeCartes ) v ).setPreferredSize( new Dimension( PCarte.largeur + 15, PCarte.hauteur + 200  ) );
		( ( PTasDeCartes ) v ).setSize( new Dimension( PCarte.largeur + 15, PCarte.hauteur + 200  ) );
		( ( PTasDeCartes ) v ).scrollRectToVisible( ( ( PTasDeCartes ) v ).getBounds() );
		inside.add( ( ( PTasDeCartes ) c ) );
		inside.add( ( ( PTasDeCartes ) v ) );
		inside.setVisible(true);
		inside.setPreferredSize(new Dimension(PCarte.largeur + 10, PCarte.hauteur + 200));
		this.getViewport().add(inside);
		c.setDxDy(0, 5);
		v.setDxDy(0, 18);
		this.up = c;
		this.bottom = v;
		this.setPreferredSize( new Dimension( PCarte.largeur + 25, PCarte.hauteur + 350 ) );
		this.setSize(new Dimension( PCarte.largeur + 25, PCarte.hauteur + 350 ) );
		this.setBackground( Color.cyan );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPColonne#activerRetournerCarteListener()
	 */
	public void activerRetournerCarteListener(){
		( ( PTasDeCartes ) up ).addMouseListener( retournCarteListener );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPColonne#desactiverRetournerCarteListener()
	 */
	public void desactiverRetournerCarteListener(){
		( ( PTasDeCartes ) up ).removeMouseListener( retournCarteListener );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPColonne#setControl(solitaire.controler.CColonne)
	 */
	public void setControl(ICColonne control) {
		this.control = control;
		retournCarteListener = new RetournerCarteListener( ( IViewDoubleTas ) this );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPColonne#getControl()
	 */
	@Override
	public IControlCarteRetournable getControl(){
		return ( IControlCarteRetournable )control;
	}
	
	@Override
	public void updateString(){
		Properties property = configuration.getProperties();
		( ( PTasDeCartes ) up ).setToolTipText(property.getProperty("colonne.cachee.tooltip", "cliquez pour retourner une carte dans le tas de carte visible de cette colonne s'il est vide"));
		( ( PTasDeCartes ) bottom ).setToolTipText(property.getProperty("colonne.visible.tooltip","cliquez pour retourner une carte dans le tas de carte visible de cette colonne s'il est vide"));
	}
	
	public void setConfiguration(IConfigurationLoader configuration) {
		this.configuration = configuration;
	}
	
	private ICColonne control;
	
	private MouseListener retournCarteListener;
	
	private IPTasDeCartes up;
	private IPTasDeCartes bottom;
	private IConfigurationLoader configuration;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
