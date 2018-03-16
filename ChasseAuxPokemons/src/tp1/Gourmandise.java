package tp1;

public class Gourmandise extends Nourriture {
	private static int APPORTLOYAUTE = 50;
	private static int APPORTSATISFACTION = 50;
	
	public Gourmandise(int apport, String nomIngredient , String[] compatiblite, int frequence, int APPORTLOYAUTE, int APPORTSATISFACTION){
		super(apport,nomIngredient,compatiblite,frequence);
		this.APPORTLOYAUTE = APPORTLOYAUTE;
		this.APPORTSATISFACTION = APPORTSATISFACTION;
	}
	
	@Override
	public String toString(){
		String toStringSuper = super.toString();
		return ("Ceci est une gourmandise" + toStringSuper);
	}
	
	@Override
	public void estMangee(Pokemon mangeur) {
		if(mangeur.getSatisfaction()<50){
		mangeur.setSatisfaction(mangeur.getSatisfaction()+1);
		}
		if(mangeur.getLoyaute()<50){
		mangeur.setLoyaute(mangeur.getLoyaute()+1);
		}
	}
	
	@Override
	public Gourmandise genAlea() {
		if (Math.round(100 * Math.random()) < this.frequence)
		//Les valeurs sont en protected mais seront accessible via accesseurs, getApport() etc...
		return new Gourmandise(this.apport, this.nomIngredient, this.compatibilite, this.frequence, APPORTLOYAUTE, APPORTSATISFACTION);
		else
		return null;
	}

}