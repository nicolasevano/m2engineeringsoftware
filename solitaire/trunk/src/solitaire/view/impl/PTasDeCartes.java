package solitaire.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;

import javax.swing.JLabel;
import javax.swing.JPanel;

import solitaire.controler.ICCarte;
import solitaire.controler.ICTasDeCartes;
import solitaire.controler.impl.CTasDeCartes;
import solitaire.listener.DragAndDropTasListener;
import solitaire.stringloader.IConfigurationLoader;
import solitaire.view.IPTasDeCartes;

public class PTasDeCartes extends JPanel implements IPTasDeCartes{

	public PTasDeCartes(String nom, ICTasDeCartes control){
		label = new JLabel( nom );
		this.control = control;
		this.add( label );
		this.setLayout( null );
		PCarte.initDimensions();
		this.setPreferredSize( new Dimension( PCarte.largeur + 10, PCarte.hauteur + 20  ) );
		defaultColor = this.getBackground();
		//dadc = new DragAndDropCarte( this );
		dadtac = new DragAndDropTasListener( this );
	}

	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#setDxDy(int, int)
	 */
	public void setDxDy( int dx,int dy ){
		this.dx = dx;
		this.dy = dy;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#empiler(solitaire.view.PCarte)
	 */
	public void empiler( PCarte c ){
		
		c.setLocation( this.xCount,this.yCount );
		this.add( c, 0 );
		this.xCount += dx;
		this.yCount += dy;
		repaint();
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#depiler(solitaire.view.PCarte)
	 */
	public void depiler(PCarte c)throws Exception{
		
		this.remove( c );
		this.xCount -= dx;
		this.yCount -= dy;
		repaint();
		
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#getTransferData(java.awt.datatransfer.DataFlavor)
	 */
    @Override
    public Object getTransferData (DataFlavor flavor) {
       Object result = null ;
       if (flavor.isMimeTypeEqual (DataFlavor.javaJVMLocalObjectMimeType)) {
 	     result = this ;
       }
       return ( result ) ;
    }

    /* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#getTransferDataFlavors()
	 */
    @Override
    public DataFlavor [] getTransferDataFlavors () {
       DataFlavor data [] = new DataFlavor [1] ;
       try {
 	     data [0] = new DataFlavor (DataFlavor.javaJVMLocalObjectMimeType) ;
       } catch (java.lang.ClassNotFoundException e) {
       }
       return (data) ;
    }

    /* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#isDataFlavorSupported(java.awt.datatransfer.DataFlavor)
	 */
    @Override
    public boolean isDataFlavorSupported (DataFlavor flavor) {
       boolean result = false ;
       if (flavor.isMimeTypeEqual (DataFlavor.javaJVMLocalObjectMimeType)) {
 	     result = true ;
       }
       return (result) ;
    }
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#getControl()
	 */
	public ICTasDeCartes getControl() {
		return control;
	}

	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#setControl(solitaire.controler.CTasDeCartes)
	 */
	public void setControl(ICTasDeCartes control) {
		this.control = control;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#c2p_debutDnDKO()
	 */
	public void c2p_debutDnDKO(){
		dadtac.dadc_debutDnDKO();
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#c2p_debutDnDOK(solitaire.controler.ICCarte)
	 */
	public void c2p_debutDnDOK( ICCarte cc ){
		dadtac.dadc_debutDnDOK( cc );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#c2p_debutDnDOK(solitaire.controler.ICTasDeCartes)
	 */
	public void c2p_debutDnDOK( ICTasDeCartes tc ){
		dadtac.dadc_debutDnDOK( tc );
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#c2p_finDnDInvalide()
	 */
	public void c2p_finDnDInvalide(){
		dadtac.dadc_finDnDInvalide();
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#c2p_finDnDValide()
	 */
	public void c2p_finDnDValide(){
		dadtac.dadc_finDnDValide();
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#getDefaultColor()
	 */
	public Color getDefaultColor(){
		return defaultColor;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#setDefaultColor(java.awt.Color)
	 */
	public void setDefaultColor( Color defaultColor ){
		this.defaultColor = defaultColor;
	}
	
	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#isOrigine()
	 */
	public boolean isOrigine(){
		return origine;
	}

	/* (non-Javadoc)
	 * @see solitaire.view.IPTasDeCartes#setOrigine(boolean)
	 */
	public void setOrigine(boolean origine) {
		this.origine = origine;
	}
	
	public void setConfiguration(IConfigurationLoader configuration) {
		this.configuration = configuration;
	}
	
	@Override
	public void updateString(){
		//Nothing to do
	}
	//private DragAndDropCarte dadc;
	private DragAndDropTasListener dadtac;
	private int dx;
	private int dy;
	private int xCount;
	private int yCount;
	
	
	protected IConfigurationLoader configuration;
	private JLabel label;
	//access to control of this presentation 
	private ICTasDeCartes control;
	//default backgroud color
	private Color defaultColor;
	
	boolean origine;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
