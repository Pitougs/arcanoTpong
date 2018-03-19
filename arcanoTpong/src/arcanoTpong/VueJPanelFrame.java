package arcanoTpong;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueJPanelFrame extends JPanel{
	
	private int hauteurInit=800;//valeur par default
	private int largeurInit=1200; 
	
	
	protected static BufferedImage Brique;
	protected static BufferedImage balle;
	protected static BufferedImage raquette;
	protected static BufferedImage fond;
	
	private JLabel scoreJL;
	private JLabel chronosJL;
	
	protected ArrayList<Brique> briques = new ArrayList<Brique>();
	protected ArrayList<Balle> balles = new ArrayList<Balle>();
	protected ArrayList<Raquette> raquettes = new ArrayList<Raquette>();
	
	
	private GameJPanelGauche gauche;
	private JPanel droit;
	
	private VueJPanel1 jp1;
	
	public VueJPanelFrame(int largeur, int hauteur) {
	
		try {
		      fond = ImageIO.read(new File("imageFond.jpg"));
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		
		this.setLayout(new BorderLayout());
		/*scoreJL = new JLabel("score : ");
	    chronosJL   = new JLabel("temps : ");
	    JPanel top = new JPanel();
	    top.setLayout(new BorderLayout());
	    top.add(scoreJL, BorderLayout.WEST);
	    top.add(chronosJL,   BorderLayout.EAST);
	    this.add(top, BorderLayout.NORTH);*/
	    
		this.gauche = new GameJPanelGauche(hauteur, largeur);
		this.droit = new JPanel();
		this.droit.setSize(100, hauteur);
		this.add(gauche, BorderLayout.WEST);
		this.add(droit, BorderLayout.EAST);
		
		
		jp1 = new VueJPanel1(largeur-200, hauteur, this);
		

		
		
	    
	
	    this.add(jp1, BorderLayout.CENTER);
	}
	
	//////////////////////////////////////////////////////////////////////
		
	public void setScore(int score) {
	scoreJL.setText("score : " + Integer.toString(score));
	}
	
	public void setChronos(int chronos) {
	chronosJL.setText("temps : " + Integer.toString(chronos));
	}
	
	
	public void ajouteBrique(Brique b) {
	briques.add(b);
	}
	
	public void ajouteBalle(Balle b) {
	balles.add(b);
	}
	
	public void ajouteRaquette(Raquette r) {
	raquettes.add(r);
	}
	
	
	public void setListeBriques(ArrayList<Brique> b) {
	this.briques = b;
	}
	
	public void setListeBalles(ArrayList<Balle> b) {
	this.balles = b;
	}
	
	public void setListeRaquettes(ArrayList<Raquette> r) {
	this.raquettes = r;
	}
	
	
	public void enleveBrique(Brique b) {
	this.briques.remove(b);
	}
	
	public void enleveBalle(Balle b) {
	this.balles.remove(b);
	}
	
	public void enleveRaquette(Raquette r) {
	this.raquettes.remove(r);
	}
	
	public ArrayList<Brique> getListeBriques() {
	return this.briques;
	}
	
	public ArrayList<Balle> getListeBalles() {
	return this.balles;
	}
	
	public ArrayList<Raquette> getListeRaquettes() {
	return this.raquettes;
	}
	
	public JPanel getPanel() {
	return this.jp1;
	}
	
	public double getScaleX() {
		return this.jp1.scalex;
	}
	
	public double getScaleY() {
		return this.jp1.scaley;
	}
	
	
	

}
