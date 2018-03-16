package tp1;
import java.lang.Math;

public class Nourriture {
	
	protected int apport;
	protected String nomIngredient;
	protected String[] compatibilite; //Devra être uniforme à 30
	public int frequence;
	
	public Nourriture(int apport, String nomIngredient, String[] compatibilite) {
		this.apport = apport;
		this.nomIngredient = nomIngredient;
		this.compatibilite = compatibilite;
		this.frequence = 30;
	}
	public Nourriture(int apport, String nomIngredient, String[] compatibilite, int frequence) {
		this.apport = apport;
		this.nomIngredient = nomIngredient;
		this.compatibilite = compatibilite;
		this.frequence = frequence;
	}
	public String toString(){
			String compatibilite = this.compatibilite[0]; // le String compatibilites met les elements du tableau compatibilites
			
			// dans un String ou les elements sont mis en ordre.
			for (int i = 1; i < this.compatibilite.length; ++i) {
				compatibilite = compatibilite + ", " + this.compatibilite[i];
			}
			return ("nourriture " + this.nomIngredient + ", soulage l'appetit par " + this.apport + " et peut etre mangee par les types prochains de pokemons : " + compatibilite + ". Elle apparait avec un frequence " +
			this.frequence);
	}
	public String getIngredient() {
		return this.nomIngredient;
	}
	public boolean estCompatible(String type) {
		for (int i = 0; i < this.compatibilite.length; i++) {
		if (type.equals(this.compatibilite[i]))
			return true;
		}
			return false;
	}

	
	public Nourriture genAlea() {
		if (Math.round(100 * Math.random()) < this.frequence)
		return new Nourriture(this.apport, this.nomIngredient, this.compatibilite);
		else
		return null;
	}
	
	public void estMangee(Pokemon mangeur ){
		if (mangeur.getAppetit() > this.apport)
			mangeur.setAppetit(mangeur.getAppetit()-this.apport);
		else 
			mangeur.setAppetit(0);
	} 
}