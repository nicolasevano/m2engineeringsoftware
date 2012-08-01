package com.sodifrance.jsf;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;

public class Traitement {

	public boolean isTraitement() {
		return traitement;
	}

	public void setTraitement(boolean traitement) {
		this.traitement = traitement;
	}

	public String getTypeCourbe() {
		return typeCourbe;
	}

	public void setTypeCourbe(String typeCourbe) {
		this.typeCourbe = typeCourbe;
	}

	public void setLargeurs(SelectItem[] largeurs) {
		this.largeurs = largeurs;
	}

	public SelectItem[] getLargeurs() {
		return largeurs;
	}

	private SelectItem[] largeurs = {
			new SelectItem(200, "200"),
			new SelectItem(250, "250"),
			new SelectItem(300, "300"),
			new SelectItem(350, "350"),
			new SelectItem(400, "400"),
			new SelectItem(450, "450"),
			new SelectItem(500, "500")
	};

	public int getLargeurVignette() {
		return largeurVignette;
	}

	public void setLargeurVignette(int largeurVignette) {
		this.largeurVignette = largeurVignette;
	}

	public BufferedImage getVignette() {
		return vignette;
	}

	public BufferedImage getHistogramme() {
		return histogramme;
	}

//	public BufferedImage getZoom() {
//		
//		System.out.println( "x begin point: " + ( centreZoomX - ( /*largeurVignette*/image.getWidth() / this.largeurVignette ) ) );
//	System.out.println( "y begin point: " + ( centreZoomY - ( /*hauteur*/image.getHeight() / this.hauteur ) ) );
//		System.out.println( "Largeur: " + /*largeurVignette*/image.getWidth() / this.largeurVignette );
//		System.out.println( "Hauteur: " + /*hauteur*/ image.getHeight() / this.hauteur );
//		int xBeginPoint = centreZoomX - ( /*largeurVignette*/image.getWidth() / this.largeurVignette );
//		int yBeginPoint = centreZoomY - ( /*hauteur*/image.getHeight() / this.hauteur );
//		if( xBeginPoint < 0 ) xBeginPoint = 0;
//		if( yBeginPoint < 0 ) yBeginPoint = 0;
//		return image.getSubimage( xBeginPoint, 
//								  yBeginPoint, 
//								  largeurVignette, 
//								  hauteur );
//		
//	}
	
	 public BufferedImage getZoom() {
		 
		 int xbegin = ( ( centreZoomX-largeurVignette/2 ) < 0 )? 0 : centreZoomX-largeurVignette / 2; 
		 int ybegin = ( ( centreZoomY-hauteur/2 ) < 0 )? 0 : centreZoomY-hauteur / 2;
		 xbegin = ( xbegin > largeurVignette )? largeurVignette - 1 : xbegin; 
		 ybegin = ( ybegin > hauteur )? hauteur - 1 : ybegin;
		 System.out.println( "xbegin:" + xbegin );
		 System.out.println( "ybegin: " + ybegin );
		 return image.getSubimage(xbegin, ybegin, largeurVignette /*this.image.getWidth()*/, hauteur /*this.image.getHeight()*/ );
		 
	 }

	public BufferedImage getRetouche() {
		return retouche;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		if (!nomFichier.equals(this.nomFichier)) {
			this.nomFichier = nomFichier;
			try {
				image = ImageIO.read(new URL("file:///"+nomFichier));
				retailler();
				calculerHistogramme();
				centreZoomX = image.getWidth()/2;
				centreZoomY = image.getHeight()/2;
				retouche();
			} 
			catch (IOException ex) {}  
		}
	}

	public int getLargeur() { return image==null ? 0 : image.getWidth(); }

	public int getHauteur() { return image==null ? 0 : image.getHeight(); }

	public int getContraste() {
		return contraste;
	}

	public void setContraste(int contraste) {
		this.contraste = contraste;
	}

	public void setIntensité(int intensité) {
		this.intensité = intensité;
	}

	public int getIntensité() {
		return intensité;
	}

	public boolean isPrésente() { return image!=null; }

	private void retailler() {
		double ratio = (double)largeurVignette/image.getWidth();
		vignette = new BufferedImage((int)(image.getWidth()*ratio), (int)(image.getHeight()*ratio), image.getType());
		AffineTransform retailler = AffineTransform.getScaleInstance(ratio, ratio);
		int interpolation = AffineTransformOp.TYPE_BICUBIC;
		AffineTransformOp retaillerImage = new AffineTransformOp(retailler, interpolation);
		retaillerImage.filter(image, vignette);      
	}   

	private void calculerHistogramme() {
		hauteur = vignette.getHeight();
		rouges = new int[256];
		verts = new int[256];
		bleus = new int[256];      
		récupérerRVB();
		tracerHistogrammes();      
	}   

	private void récupérerRVB() {
		Raster trame = vignette.getRaster();
		ColorModel modèle = vignette.getColorModel();
		for (int y=0; y<vignette.getHeight(); y++)
			for (int x=0; x<vignette.getWidth(); x++) {
				Object données = trame.getDataElements(x, y, null);
				rouges[modèle.getRed(données)]++;
				verts[modèle.getGreen(données)]++;
				bleus[modèle.getBlue(données)]++;
			}           
	}

	private void tracerHistogrammes() {
		histogramme = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_ARGB);
		dessin = histogramme.createGraphics();
		Rectangle2D rectangle = new Rectangle2D.Double(0, 0, largeur-1, hauteur-1);
		dessin.setPaint(Color.yellow);
		dessin.fill(rectangle);      
		changerAxes();
		if (rouge) {
			dessin.setPaint(new Color(1F, 0F, 0F, 0.7F));
			tracerHistogramme(rouges);
		}
		if (vert) {
			dessin.setPaint(new Color(0F, 1F, 0F, 0.7F));
			tracerHistogramme(verts);
		}
		if (bleu) {
			dessin.setPaint(new Color(0F, 0F, 1F, 0.7F));
			tracerHistogramme(bleus);
		}
	}

	private void changerAxes() {
		dessin.translate(0, hauteur);
		double surfaceImage = vignette.getWidth()*vignette.getHeight();
		double surfaceHistogramme = histogramme.getWidth()*histogramme.getHeight();
		dessin.scale(1, -surfaceHistogramme/surfaceImage/3);
	}   

	private void tracerHistogramme(int[] couleur) {
		for (int i=0; i<255; i++) 
			dessin.drawLine(i, 0, i, couleur[i]);              
	}  

	private void retouche() {
		int[] courbeInitiale = new int[256];
		byte[] courbe = new byte[256];
		for (int i=0; i<256; i++) {
			courbeInitiale[i] = (int) (i+intensité*Math.sin(i*Math.PI/255)-contraste*Math.sin(i*2*Math.PI/255));
			if (courbeInitiale[i]<0) courbe[i] = (byte)0;
			else if (courbeInitiale[i]>255) courbe[i] = (byte)255;
			else courbe[i] = (byte)courbeInitiale[i];
		}
		retouche = new BufferedImage(vignette.getWidth(), vignette.getHeight(), vignette.getType());
		ByteLookupTable table = new ByteLookupTable(0, courbe);
		LookupOp opération = new LookupOp(table, null);
		opération.filter(vignette, retouche);
	}

	public void changeHistogramme(ValueChangeEvent evt) {
		typeCourbe = (String)evt.getNewValue();
		rouge = typeCourbe.equals("rouge") || typeCourbe.equals("toutes");
		vert = typeCourbe.equals("vert") || typeCourbe.equals("toutes");
		bleu = typeCourbe.equals("bleu") || typeCourbe.equals("toutes");
		tracerHistogrammes();
	}

	public void changeLargeur(ValueChangeEvent evt) {
		largeurVignette = (Integer)evt.getNewValue();
		retailler();
		calculerHistogramme();
		retouche();
	}

//	public void changerCentreZoom(ActionEvent evt) {
//		FacesContext ctx = FacesContext.getCurrentInstance();
//		String clientId = evt.getComponent().getClientId( ctx );
//		Map<String,String> requête = ctx.getExternalContext().getRequestParameterMap();
//		int x = Integer.parseInt( ( String ) requête.get( clientId+".x" ) );
//		int y = Integer.parseInt( ( String ) requête.get( clientId+".y" ) ); 
//		centreZoomX = /*( image.getWidth() < largeurVignette )? ( image.getWidth() * x ) / largeurVignette : */( largeurVignette * x ) / image.getWidth();
//		System.out.println( "centreZoomX: " + centreZoomX );
//		centreZoomY = /*( image.getHeight() < hauteur )? ( image.getHeight() * y ) / hauteur : */( hauteur * y ) / image.getHeight();
//		System.out.println( "centreZoomY: " + centreZoomY );
//	}
	
//	public void changerCentreZoom(ActionEvent evt) {
//		FacesContext ctx = FacesContext.getCurrentInstance();
//		String clientId = evt.getComponent().getClientId(ctx);
//		Map requête = ctx.getExternalContext().getRequestParameterMap();
//		int x = Integer.parseInt((String)requête.get(clientId+".x"));
//		int y = Integer.parseInt((String)requête.get(clientId+".y")); 
//		centreZoomX = image.getWidth()*x/largeurVignette;
//		System.out.println( "centreZoomX: " + centreZoomX );
//		centreZoomY = image.getHeight()*y/hauteur;    
//		System.out.println( "centreZoomY: " + centreZoomY );
//	}

	public void changerCentreZoom(ActionEvent evt) {
	      FacesContext ctx = FacesContext.getCurrentInstance();
	      String clientId = evt.getComponent().getClientId(ctx);
	      Map<String,String> requête = ctx.getExternalContext().getRequestParameterMap();
	      int x = Integer.parseInt((String)requête.get(clientId+".x"));
	      int y = Integer.parseInt((String)requête.get(clientId+".y")); 
	      centreZoomX = image.getWidth()*x/largeurVignette;
	      centreZoomY = image.getHeight()*y/hauteur;  
	      ctx.renderResponse(); // ligne à rajouter
	   }
	
	public void changeTraitement(ValueChangeEvent evt) {
		traitement = (Boolean) evt.getNewValue();
	}

	public void changeIntensité(ValueChangeEvent evt) {
		intensité = (Integer) evt.getNewValue();
		retouche();
	}

	public void changeContraste(ValueChangeEvent evt) {
		contraste = (Integer) evt.getNewValue();
		retouche();
	}  

	private String nomFichier;
	private BufferedImage image;
	private BufferedImage vignette;
	private BufferedImage histogramme;
	private BufferedImage retouche;
	private int centreZoomX, centreZoomY;
	private int largeurVignette = 400;
	private int[] rouges;
	private int[] verts;
	private int[] bleus;
	private int largeur = 256;
	private int hauteur;
	private Graphics2D dessin;
	private String typeCourbe = "toutes";
	private int intensité;
	private int contraste;

	private boolean traitement;
	private boolean rouge = true;
	private boolean vert = true;
	private boolean bleu = true;
}
