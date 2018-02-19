package arcanoTpong;

public class Controleur {
	static int lZoneJeu=80*50; 
	static int hZoneJeu=30*20;
	
	static Vue view = new Vue(lZoneJeu,hZoneJeu);
	static Moteur model = new Moteur(1,lZoneJeu,hZoneJeu);
	
	 public static void main(String args[]){
		 
		    for(int i= 0; i<model.getInGRaquettes().length;i++){
		    	view.afficheScore(model.getInGRaquettes()[i].getScore());
		    }
		    
		    view.setListeBriques(model.getInGBriquesClean());
		    view.setListeBalles(model.getInGBalles());
		    view.setListeRaquettes(model.getInGRaquettesArrayListe());
		    /*
		    Brique deadB = model.killBrique(2,1,model.getInGRaquettes()[0]);
		    view.enleveBrique(deadB);
		    */
		    
		    view.afficheScore(model.getInGRaquettes()[0].getScore());
		    
		    
		    
	 }
}
