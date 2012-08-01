package com.sodifrance.jsf;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class Traitement {
   
   public BufferedImage getVignette() {
      return vignette;
   }

   public BufferedImage getHistogramme() {
      return histogramme;
   }

   public String getNomFichier() {
      return nomFichier;
   }

   public void setNomFichier(String nomFichier) {
      this.nomFichier = nomFichier;
       try {
         image = ImageIO.read(new URL("file:///"+nomFichier));
         retailler();
         calculerHistogramme();
      } 
      catch (IOException ex) {}  
   }
   
   public int getLargeur() { return image==null ? 0 : image.getWidth(); }
   
   public int getHauteur() { return image==null ? 0 : image.getHeight(); }
   
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
      rouge = new int[256];
      vert = new int[256];
      bleu = new int[256];      
      récupérerRVB();
      tracerHistogrammes();      
   }   
   
   private void récupérerRVB() {
     Raster trame = vignette.getRaster();
     ColorModel modèle = vignette.getColorModel();
     for (int y=0; y<vignette.getHeight(); y++)
          for (int x=0; x<vignette.getWidth(); x++) {
            Object données = trame.getDataElements(x, y, null);
            rouge[modèle.getRed(données)]++;
            vert[modèle.getGreen(données)]++;
            bleu[modèle.getBlue(données)]++;
          }           
   }
   
   private void tracerHistogrammes() {
      histogramme = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_ARGB);
      dessin = histogramme.createGraphics();
      Rectangle2D rectangle = new Rectangle2D.Double(0, 0, largeur-1, hauteur-1);
      dessin.setPaint(Color.black);
      dessin.fill(rectangle);      
      changerAxes();
      dessin.setPaint(new Color(1F, 0F, 0F, 0.7F));
      tracerHistogramme(rouge);
      dessin.setPaint(new Color(0F, 1F, 0F, 0.7F));
      tracerHistogramme(vert);
      dessin.setPaint(new Color(0F, 0F, 1F, 0.7F));
      tracerHistogramme(bleu);
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
   
   private String nomFichier;
   private BufferedImage image;
   private BufferedImage vignette;
   private BufferedImage histogramme;
   private int largeurVignette = 400;
   private int[] rouge;
   private int[] vert;
   private int[] bleu;
   private int largeur = 256;
   private int hauteur;
   private Graphics2D dessin;
}
