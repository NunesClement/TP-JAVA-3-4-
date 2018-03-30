package tp1;

public class AttaqueSpecial extends Attaque{
	
	public AttaqueSpecial(String nom, String[] type_compatible, int power, int acc, int pp) {
		super(nom, type_compatible, power, acc, pp);
		
	}
	@Override
	public boolean estCompatible(Pokemon p) {
	boolean rep=false;
	int i=0;
		while (rep && i<=Constant.LIST_TYPEPOKEMON.length) {
			if(p.getType().equals(Constant.LIST_TYPEPOKEMON[i]))
				rep=true;
			i++;	
		}
		return rep;
	}
	
	@Override
	public void utiliser(Pokemon pokemon_attaquant, Pokemon victime) {
		if(pokemon_attaquant.getHp()>=victime.getHp()){
			if(this.estCompatible(victime)){
				victime.setHp_restant(victime.getHp_restant()-this.power);
				victime.estBlesse(pokemon_attaquant.getHp());
				this.pp--;
		      }
			}
	}
}
