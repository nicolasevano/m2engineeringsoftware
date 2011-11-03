package metronome.view;

import metronomelogic.EmetteurSonore;

//
// Fr�d�ric Boulanger
// Sup�lec - D�partement Informatique
// 3 rue Joliot-Curie
// 91192 Gif-sur-Yvette cedex, France
//
// frederic.boulanger@supelec.fr
//

/*! \mainpage Un exemple simple de production de son en Java
 *
 * Cet exemple ne contient qu'une seule classe et montre comment :
 * \li obtenir une ligne audio pour produire un son
 * \li g�n�rer les �chantillons sonores en respectant le format attendu par la ligne
 * \li transmettre les �chantillons � la ligne et attendre qu'elle ait fini de les jouer.
 *
 *
 */
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;


/**
 * Cette classe permet de jouer un son sinuso�dal simple de fr�quence
 * et de dur�e donn�e. La cr�ation des �chantillons sonores fonctionne
 * pour des �chantillons cod�s sur un ou sur deux octets.
 */
public class EmetteurSonoreSimulate implements EmetteurSonore {

	  /**
	   * Joue un son sinuso�dal de fr�quence et de dur�e donn�s sur une ligne audio.
	   * @param freq est la fr�quence du son en Hertz
	   * @param duree est la dur�e du son en millisecondes
	   * @param line est la ligne audio sur laquelle le son doit �tre jou�
	   */
	  public static void jouer(double freq, long duree, SourceDataLine line) {
	    // Format de son utilis� par la ligne
	    AudioFormat fmt = line.getFormat();
	    // On r�cup�re la fr�quence d'�chantillonnage de la ligne
	    float sampleRate = fmt.getSampleRate();
	    // ainsi que la taille du tampon utilis� par cette ligne
	    int bufsize = line.getBufferSize();
	    // la taille des �chantillons
	    int sampleSize = fmt.getSampleSizeInBits();
	    int nbOctets = 0;  // nombre d'octets par �chantillon
	    int maxVal = 0;    // valeur maximal d'un �chantillon
	    if (sampleSize == 8) {
	      nbOctets = 1;    // 8 bits => 1 octet, max = 127
	      maxVal = 0x7F;
	    } else if (sampleSize == 16) {
	      nbOctets = 2;    // 16 bits => 2 octets, max = 32767
	      maxVal = 0x7FFF;
	    } else {
	      throw new Error("# Nombre de bits par �chantillon non support� : " + sampleSize);
	    }
	    // Ordre des octets dans un �chantillon
	    boolean bigEndian = fmt.isBigEndian();
	    // Le nombre d'�chantillons � g�n�rer est le produit de la dur�e 
	    // en secondes par la fr�quence d'�chantillonnage en Hertz
	    int nbEchantillons = (int)Math.ceil((double)duree / 1000 * sampleRate);
	    // On alloue un tableau d'octets de la taille du tampon de la ligne
	    byte audiosamples[] = new byte[bufsize];
	    int i = 0;
	    while (i < nbEchantillons) {
	      // on g�n�re les �chantillons et on les transmet � la ligne tampon 
	      // par tampon, ce qui est plus efficace.
	      int j = 0;
	      while ((j < bufsize) && (i < nbEchantillons)) {
	        // sample donne la valeur de l'�chantillon en double avec amplitude
	        // -1,0/1.0, on la multiplie par maxVal pour obtenir la valeur pour la ligne
	        int val = (int)(maxVal * sample(i++, freq, sampleRate));
	        if (nbOctets == 1) {
	          // Un seul octet : il suffit de le mettre dans le tableau
	          audiosamples[j++] = (byte)val;
	        } else if (bigEndian) {
	          // deux octets en big endian : on met l'octet de poids fort en premier
	          audiosamples[j++] = (byte)((val & 0xFF00) >> 8);
	          audiosamples[j++] = (byte)(val & 0x00FF);
	        } else {
	          // deux octets en little endian : on met l'octet de poids faible en premier
	          audiosamples[j++] = (byte)(val & 0x00FF);
	          audiosamples[j++] = (byte)((val & 0xFF00) >> 8);
	        }
	      }
	      // on transmet le tampon � la ligne
	      line.write(audiosamples, 0, j);
	    }
	  }

	  /**
	   * Calcule un �chantillon d'un signal sinuso�dal.
	   * @param i est l'indice de l'�chantillon (d�bute � 0)
	   * @param freq est la fr�quence du signal en Hertz
	   * @param rate est la fr�quence d'�chantillonnage en Hertz
	   * @return la valeur de l'�chantillon, comprise en -1.0 et 1.0
	   */
	  public static double sample(int i, double freq, double rate) {
	    // On ram�ne d'abord le temps dans la p�riode [0, 1/freq[
	    double t = Math.IEEEremainder(i/rate, 1/freq);
	    // IEEEremainder nous ram�ne dans [-1/2freq, 1/2freq[, donc
	    // on ajoute 1/freq pour �tre dans [0, 1/freq[
	    if (t < 0) {
	      t += 1 / freq;
	    }
	    // f(t) = sin(wt) = sin(2*pi*freq*t)
	    return Math.sin(2 * Math.PI * freq * t);
	  }

	  public static void main(String args[]) {
	    final float sampleRate = 20500;  // fr�quence d'�chantillonnage
	    final int sampleSize = 8;        // nombre de bits par �chantillon : ici un octet
	    final boolean bigEndian = true;  // ordre des octets dans l'�chantillon (si sampleSize = 16)
	    final boolean signed = true;     // les �chantillons sont sign�s (valeurs de -128 � 127)
	    // Ces param�tres d�finissent un format audio �chantillonn�
	    AudioFormat audiofmt = new AudioFormat(sampleRate, sampleSize, 1, signed, bigEndian);
	    // On va maintenant chercher une ligne audio qui supporte ce format
	    // Une SourceDataLine est une ligne audio qui produit du son. C'est une source pour
	    // le syst�me audio, m�me si du point de vue de notre programme, c'est plut�t un puits.
	    SourceDataLine line = null;
	    try {
	      line = AudioSystem.getSourceDataLine(audiofmt);
	      line.open(audiofmt);  // on ouvre la ligne pour pouvoir y �crire des �chantillons
	    } catch (LineUnavailableException lue) {
	      System.out.println("# Erreur : impossible de trouver une ligne de sortie audio au format :");
	      System.out.println("#          " + audiofmt);
	      System.exit(1);
	    }

	    line.start();  // on active la ligne afin qu'elle transforme les �chantillons en son
	    jouer(180.0, 200, line);  // jouer un la pendant 2 secondes

	    // On attend que la ligne ait fini de jouer les �chantillons
	    line.drain();
	    // Il faut faire un exit car le syst�me audio cr�e un thread qui ne termine pas tout seul.
	    System.exit(0);
	  }
	
	@Override
	public void emettreClic() {
		// TODO Auto-generated method stub
		final float sampleRate = 20500;  // fr�quence d'�chantillonnage
	    final int sampleSize = 8;        // nombre de bits par �chantillon : ici un octet
	    final boolean bigEndian = true;  // ordre des octets dans l'�chantillon (si sampleSize = 16)
	    final boolean signed = true;     // les �chantillons sont sign�s (valeurs de -128 � 127)
	    // Ces param�tres d�finissent un format audio �chantillonn�
	    AudioFormat audiofmt = new AudioFormat(sampleRate, sampleSize, 1, signed, bigEndian);
	    // On va maintenant chercher une ligne audio qui supporte ce format
	    // Une SourceDataLine est une ligne audio qui produit du son. C'est une source pour
	    // le syst�me audio, m�me si du point de vue de notre programme, c'est plut�t un puits.
	    SourceDataLine line = null;
	    try {
	      line = AudioSystem.getSourceDataLine(audiofmt);
	      line.open(audiofmt);  // on ouvre la ligne pour pouvoir y �crire des �chantillons
	    } catch (LineUnavailableException lue) {
	      System.out.println("# Erreur : impossible de trouver une ligne de sortie audio au format :");
	      System.out.println("#          " + audiofmt);
	      System.exit(1);
	    }

	    line.start();  // on active la ligne afin qu'elle transforme les �chantillons en son
	    jouer(180.0, 150, line);  // jouer un la pendant 2 secondes

	    // On attend que la ligne ait fini de jouer les �chantillons
	    line.drain();
	}

}
