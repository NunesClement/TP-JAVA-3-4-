package tp1;

public class AttaquePhysique extends Attaque{

	public AttaquePhysique(String nom, int power, int acc, int pp) {
		super(nom, power, acc, pp);
	}
	
	@Override
	public boolean estCompatible(Pokemon p) {
		return true;
	}
	
	@Override
	public void utiliser(Pokemon pokemon_attaquant, Pokemon victime) {
		int numero;
		numero = (int) (Math.random() * 100) + 1;
		if(pokemon_attaquant.getHp()>=victime.getHp()) {
			if(numero<this.getAcc()) {
			victime.setHp_restant(victime.getHp_restant()-this.power);
			victime.estBlesse(pokemon_attaquant.getHp());		
			this.pp--;
		 }
	   }
	}
}
