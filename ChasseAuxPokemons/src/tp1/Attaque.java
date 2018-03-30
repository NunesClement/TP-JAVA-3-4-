package tp1;

public abstract class Attaque {
	private String  nom;
	private String[] type_compatible;
	private int power;
	private int acc;
	private int pp;
	private int pp_restant;
	
	public Attaque(String nom, String[] type_compatible, int power, int acc, int pp) {
		this.nom = nom;
		this.type_compatible = type_compatible;
		this.power = power;
		this.acc = acc;
		this.pp = pp;
		this.pp_restant = pp;
	}
	
	public Attaque(String nom, int power, int acc, int pp) {
		this(nom, Constant.LIST_TYPEPOKEMON, power, acc, pp);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String[] getType_compatible() {
		return type_compatible;
	}

	public void setType_compatible(String[] type_compatible) {
		this.type_compatible = type_compatible;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getPp_restant() {
		return pp_restant;
	}

	public void setPp_restant(int pp_restant) {
		this.pp_restant = pp_restant;
	}

	public void resetRepetition(){
		pp_restant = pp ;
	}
	public void baisseRepetition(){
		pp_restant--;
	}
	public String toString(){
		String type_compta="";
		int i;
		if (type_compatible.equals(Constant.LIST_TYPEPOKEMON))
			return (nom + power + acc + pp + pp_restant + "compatible avec " + type_compatible);
		else{
			for (i=0;i<type_compatible.length;i++){
				type_compta=type_compatible[i]+type_compta+",";
			}		
			return (nom + power + acc + pp + pp_restant + "compatible avec " + type_compta);
		}
	}
	public void utiliser(Pokemon pokemon_attaquant,Pokemon victime){
		victime.setHp_restant(victime.getHp_restant()-this.power);
		this.pp_restant--;
	}
	
	public abstract boolean estCompatible(Pokemon p);
}
