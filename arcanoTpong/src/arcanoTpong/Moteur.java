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
	
	private int largeurBrique=200;
	private int hauteurBrique=100;
	
	public Moteur(int nBriquesX, int nBriquesY, int nRaquettes){
		this.chrono=0;
		this.gameOver=false;
		this.pause=false;
		
		inGRaquettes= new Raquette [nRaquettes];
		inGBalles= new ArrayList <Balle>();
		
		
		this.inGBriques = new Brique [nBriquesX][nBriquesY];
		for(int i=0; i<nBriquesY ;i++){
			for(int j=0; j<nBriquesX ;j++){
				this.inGBriques[j][i]=new Brique(1, 1, j*largeurBrique, i*hauteurBrique, largeurBrique, hauteurBrique); //Valeurs de variables arbitraires juste pour tester 
				//x= j*largeur de brique; y= i*hauteur de brique 
			}
		}
		
		for(int i=0; i<nRaquettes ;i++){
			this.inGRaquettes[i] = new Raquette();
		}
	
	}
	
	public Brique killBrique(int i, int j, Raquette raquette){
		raquette.addScore( this.inGBriques [i][j].kill() );
		return this.inGBriques [i][j];
	}
	
	public void killBall(Balle balle){
		inGBalles.remove(balle);
	}
	
	public void createBall(Balle balle){
		inGBalles.add(balle) ;
	}
	
	public void reviveBrique(int i, int j, Brique brique){
		this.inGBriques [i][j] = brique;
	}

	public ArrayList <Raquette> getInGRaquettesArrayListe() {
		return new ArrayList<>(Arrays.asList(inGRaquettes));
	}
	
	public Raquette[] getInGRaquettes() {
		return inGRaquettes;
	}
	
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

}
