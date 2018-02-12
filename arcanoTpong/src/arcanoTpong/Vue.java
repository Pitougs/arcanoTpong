package arcanoTpong;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.*;

public class Vue extends JFrame{
	private JPanel jp;
	private int length=800;
	private int width=800;
	/*private static BufferedImage Brique;
	private static BufferedImage balle;
	private static BufferedImage raquette;*/
	
	private JLabel scoreJL;
	private JLabel chronosJL;
	
	private ArrayList<Brique> briques = new ArrayList<Brique>();
	private ArrayList<Balle> balles = new ArrayList<Balle>();
	private ArrayList<Raquette> raquettes = new ArrayList<Raquette>();
	
	public Vue() {
		super();
		setLayout(new BorderLayout());
		scoreJL = new JLabel("score : ");
	    chronosJL   = new JLabel("temps : ");
	    JPanel top = new JPanel();
	    top.setLayout(new BorderLayout());
	    top.add(scoreJL, BorderLayout.WEST);
	    top.add(chronosJL,   BorderLayout.EAST);
	    getContentPane().add(top, BorderLayout.NORTH);
	    
	    jp = new JPanel(){
	        @Override
	        public void paintComponent(Graphics g){
	          super.paintComponent(g);

	          Graphics2D g2 = (Graphics2D)g;
	          
	          Color briqueColor = new Color(100, 25, 50);
	          
	          for(Brique b : briques) {
	        	  afficheBrique(b.x, b.y, b.largeur, b.hauteur, g2, briqueColor);
	          }
	          for(Balle b : balles) {
	        	  afficheBalle(b.x, b.y, b.largeur, b.hauteur, g2, Color.yellow.darker());
	          }
	          for(Raquette r : raquettes) {
	        	  afficheRaquette(r.x, r.y, r.largeur, r.hauteur, g2, Color.red);
	          }
	        }
	    };
	    
	    jp.setBackground(Color.WHITE);
	    getContentPane().add(jp, BorderLayout.CENTER);
	    setSize(width, length);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
	private void afficheBrique(int x, int y, int width, int height, Graphics2D g2, Color c) {
		
		g2.setColor(c);
		g2.fillRect(x, y, width, height);
		g2.setColor(Color.black);
		g2.drawRect(x, y, width, height);

	}
	
	private void afficheBalle(int x, int y, int width, int height, Graphics2D g2, Color c) {
		g2.setColor(c);
		g2.fillOval(x, y, width, height);

	}
	
	private void afficheRaquette(int x, int y, int width, int height, Graphics2D g2, Color c) {
		g2.setColor(c);
		g2.fillRect(x, y, width, height);
	}
	
	public void afficheScore(int score) {
		scoreJL.setText("score : " + Integer.toString(score));
	}
	
	public void afficheChronos(int chronos) {
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
	
	
	 public static void main(String args[]){
		    Vue v = new Vue();
		    v.afficheScore(45);
		    v.afficheScore(1111111);
		    
		    v.ajouteBrique(new Brique(0,0,10,10,50,50));
		    v.ajouteBalle(new Balle());
		    v.ajouteRaquette(new Raquette());
	 }
	
}
