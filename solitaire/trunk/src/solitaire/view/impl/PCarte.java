package solitaire.view.impl;

//-------------------------------------------------------------------------------------

//import solitaire.controle.* ;
import java.awt.* ;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.* ;

import javax.swing.* ;

import solitaire.controler.ICCarte;
import solitaire.controler.impl.CCarte;
import solitaire.view.IPCarte;

//-------------------------------------------------------------------------------------

public class PCarte extends JPanel implements IPCarte{

	//public PCarte (final String chaine, final CCarte controle) {
    public PCarte (final String chaine,CCarte control) {
    	this.control = control;
    	setLayout ( null ) ;
    	setBackground ( Color.yellow ) ;
    	icone = new ImageIcon ( "ressources/" + chaine + ".gif" ) ;
    	face = new JLabel ( icone ) ;
    	add (face) ;
    	face.setLocation ( 0, 0 ) ;
    	face.setSize ( largeur, hauteur ) ;
    	ImageIcon iconeDos = new ImageIcon ( "ressources/bluegreencrisscross.jpg" ) ;
    	dos = new JLabel (iconeDos) ;
    	dos.setSize ( face.getSize () ) ;
    	add (dos) ;
    	dos.setLocation (0, 0) ;
    	setOpaque (false) ;
    	setSize (face.getSize ()) ;
    	setPreferredSize (getSize ()) ;
    }

    /* (non-Javadoc)
	 * @see solitaire.view.impl.IPCarte#setFaceVisible(boolean)
	 */
    public void setFaceVisible ( boolean faceVisible ) {
    	face.setVisible ( faceVisible ) ;
    }

   //public final CCarte getControle () {
       //return (controle) ;
   //}

    /* (non-Javadoc)
	 * @see solitaire.view.impl.IPCarte#paint(java.awt.Graphics)
	 */
    public void paint (Graphics g) {
	super.paint (g) ;
	g.drawRect (0, 0, getWidth () - 1, getHeight () - 1) ;
    }

    /* (non-Javadoc)
	 * @see solitaire.view.impl.IPCarte#getIcone()
	 */
    public ImageIcon getIcone () {
    	return (icone) ;
    }

    public static int largeur ;
    public static int hauteur ;

    public static void initDimensions () {
    	ImageIcon icone = new ImageIcon ("ressources/1C.gif") ;
    	largeur = icone.getIconWidth () ;
    	hauteur = icone.getIconHeight () ;
    }

    public static void main (String args []) {
      initDimensions () ;
      JFrame f = new JFrame ( "Test PCarte" ) ;
      ICCarte control = new CCarte(2,3);
      f.getContentPane ().add ( control.getPresentation()/*new PCarte( "1C", control )*/ ) ;
      f.addWindowListener ( new WindowAdapter () {
	    public void windowClosing (WindowEvent e) {
	       System.exit (0) ;
	    }
	 }) ;
      f.pack () ;
      f.setVisible (true) ;
    }
   
    /* (non-Javadoc)
	 * @see solitaire.view.impl.IPCarte#getControl()
	 */
    public CCarte getControl() {
    	return control;
    }

    /* (non-Javadoc)
	 * @see solitaire.view.impl.IPCarte#getTransferData(java.awt.datatransfer.DataFlavor)
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
	 * @see solitaire.view.impl.IPCarte#getTransferDataFlavors()
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
	 * @see solitaire.view.impl.IPCarte#isDataFlavorSupported(java.awt.datatransfer.DataFlavor)
	 */
    @Override
    public boolean isDataFlavorSupported (DataFlavor flavor) {
       boolean result = false ;
       if (flavor.isMimeTypeEqual (DataFlavor.javaJVMLocalObjectMimeType)) {
 	     result = true ;
       }
       return (result) ;
    }
    
    protected JLabel face ;
    protected JLabel dos ;
    protected ImageIcon icone;
    
    private CCarte control;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

//-------------------------------------------------------------------------------------