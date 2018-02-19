package arcanoTpong;

import java.util.ArrayList;
import java.util.Arrays;

public class Moteur {
	private Brique inGBriques [][];
	private ArrayList <Balle> inGBalles;
	private Raquette inGRaquettes [];
	
	private int chrono;
	private boolean gameOver;
	private boolean pause;
	
	private int largeurBrique=80;
	private int hauteurBrique=30;
	
	int nBriquesX;
	int nBriquesY;
	
	public Moteur(int nRaquettes, int lZoneJeu, int hZoneJeu){
		this.chrono=0;
		this.gameOver=false;
		this.pause=false;
		
		inGRaquettes= new Raquette [nRaquettes];
		inGBalles= new ArrayList <Balle>();
		
		this.nBriquesX=(int)(lZoneJeu/largeurBrique);
		this.nBriquesY=(int)(hZoneJeu/hauteurBrique/3);
		
		
		this.inGBriques = new Brique [nBriquesX][nBriquesY];
		for(int i=0; i<nBriquesY ;i++){
			for(int j=0; j<nBriquesX ;j++){
				this.inGBriques[j][i]=new Brique(1, 1, j*largeurBrique, i*hauteurBrique, largeurBrique, hauteurBrique); //Valeurs de variables arbitraires juste pour tester 
				//x= j*largeur de brique; y= i*hauteur de brique 
			}
		}
		
		for(int i=0; i<nRaquettes ;i++){
			this.inGRaquettes[i] = new Raquette(lZoneJeu/2,hZoneJeu);
		}
		addBall(new Balle(lZoneJeu/2,hZoneJeu/2));
	}
	
	public Moteur(int nRaquettes, int lZoneJeu, int hZoneJeu, int nBriquesX, int nBriquesY){
		this.chrono=0;
		this.gameOver=false;
		this.pause=false;
		
		inGRaquettes= new Raquette [nRaquettes];
		inGBalles= new ArrayList <Balle>();
		
		this.nBriquesX=nBriquesX;
		this.nBriquesY=nBriquesY;
		
		
		this.inGBriques = new Brique [nBriquesX][nBriquesY];
		for(int i=0; i<nBriquesY ;i++){
			for(int j=0; j<nBriquesX ;j++){
				this.inGBriques[j][i]=new Brique(1, 1, j*largeurBrique, i*hauteurBrique, largeurBrique, hauteurBrique); //Valeurs de variables arbitraires juste pour tester 
				//x= j*largeur de brique; y= i*hauteur de brique 
			}
		}
		
		for(int i=0; i<nRaquettes ;i++){
			this.inGRaquettes[i] = new Raquette(lZoneJeu/2,hZoneJeu);
		}
		addBall(new Balle(lZoneJeu/2,hZoneJeu/2));
	}
	//*************
	public ArrayList<Brique> getInGBriquesClean(){
		ArrayList <Brique> result = new ArrayList <Brique> ();
		for(int i=0; i<this.inGBriques.length ;i++){
			for(int j=0; j<this.inGBriques[i].length ;j++){
				if(this.inGBriques[i][j].getResistanece()>0)
					result.add(this.inGBriques[i][j]);
			}
		}
		return result;
	}
	
	public ArrayList<Balle> getInGBalles(){
		return inGBalles;
	}
	
	public ArrayList <Raquette> getInGRaquettesArrayListe() {
		return new ArrayList<>(Arrays.asList(inGRaquettes));
	}
	
	public Raquette[] getInGRaquettes() {
		return inGRaquettes;
	}
	
	//***************
	
	
	public Brique killBrique(int i, int j, Raquette raquette){
		raquette.addScore( this.inGBriques [i][j].kill() );
		return this.inGBriques [i][j];
	}
	
	public void killBall(Balle balle){
		inGBalles.remove(balle);
	}
	
	public void addBall(Balle balle){
		inGBalles.add(balle) ;
	}
	
	public void reviveBrique(int i, int j, Brique brique){
		this.inGBriques [i][j] = brique;
	}


	


}
