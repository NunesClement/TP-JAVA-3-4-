package tp1;

public class Joueur {
	
	private String nom;
	private String prenom;
	private int age;
	//Tableau des pokemons possédés par le joueur
	private Pokemon tabPokemon[];
	private Nourriture caisseNourriture[];
	
	public Joueur (String nom, String prenom, int age, Pokemon tabPokemon[]){
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.tabPokemon = tabPokemon;
		this.caisseNourriture = new Nourriture[10];
	}
	public boolean verifiePlace() {
		boolean place = false;
		int i = 0;
		int indexPlace;
		for(i=0;i<this.caisseNourriture.length;i++) {
			if(this.caisseNourriture[i]==null)
				place = true;
		}
		return place;
	}
	public void lacherNourriture(int index){
		caisseNourriture[index]=null;
	}
	public void ajoutNourriture(Nourriture nourritureTrouve) {
		int i = 0;
		
			if(this.verifiePlace()==true) {
				for (i=0; i< caisseNourriture.length;i++) {
					
					if(caisseNourriture[i]==null) {
						caisseNourriture[i]=nourritureTrouve;
						
						break;
					}
				}
				
			}
			else {
					System.out.println("Vous n'avez plus de place");
			}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Nourriture[] getCaisseNourriture() {
		return caisseNourriture;
	}
	public void setCaisseNourriture(Nourriture[] caisseNourriture) {
		this.caisseNourriture = caisseNourriture;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setTabPokemon(Pokemon[] tabPokemon) {
		this.tabPokemon = tabPokemon;
	}
	public String getNom() {
		return this.nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public Pokemon[] getTabPokemon() {
		return this.tabPokemon;
	}
	public void capturer(Pokemon pokemoncapturer){
		boolean capture = false;
		int i = 0;
		
		if(pokemoncapturer.getMonJoueur() != null){
			System.out.println("Vous ne pouvez pas capturer un pokemon qui a deja un maitre.");
		}
		else {
			while(!capture && i < this.tabPokemon.length) {
				if(this.tabPokemon[i] == null) {
					this.tabPokemon[i] = pokemoncapturer;
					pokemoncapturer.setMonJoueur(this);
					pokemoncapturer.estCapture();
					capture = true;
				}
				i++;
			}
			if(!capture) {
				System.out.println("Vous n avez pas pu capturer le pokemon " + pokemoncapturer + " car vous avez deja 5 Pokemons");
			}
		}
	}
	public void liberer(Pokemon pokemoncapturer) {
		boolean liberer = false;
		int i = 0;
		while(!liberer && i<this.tabPokemon.length) {
			if(this.tabPokemon[i] == pokemoncapturer) {
				this.tabPokemon[i] = null;
				pokemoncapturer.setNomDonne(null);
				pokemoncapturer.setMonJoueur(null);
				pokemoncapturer.estLibere();
				liberer = true;
			}
			i++;
		}
		if(!liberer) {
			System.out.println("Vous netes pas le maitre de ce pokemon : vous ne pouvez pas le nommer !");
		}
	}
	public void nommer(Pokemon pokemonnommer, String newNom) {
		if(pokemonnommer.getMonJoueur() == this) {

			pokemonnommer.setMonJoueur(this);}
		else {
			System.out.println("Vous netes pas le maitre de ce pokemon : vous ne pouvez donc pas le nommer !");
		}
	}
	public void donner(Pokemon pokemondonner , Joueur autreJoueur) {
		boolean donne = false;
		int i = 0;
		while(!donne && i<this.tabPokemon.length) {
			if(this.tabPokemon[i] == pokemondonner) {
				int j = 0;
				while(!donne && j< autreJoueur.tabPokemon.length) {
					if(autreJoueur.tabPokemon[j] == null) {
						this.tabPokemon[j] = null;
						autreJoueur.tabPokemon[j] = pokemondonner;
						pokemondonner.setMonJoueur(autreJoueur);
						donne = true;
					}
					j++;
				}
				if(! donne) {
					System.out.println("Vous netes pas le maitre de ce pokemon : vous ne pouvez donc pas le donner");
				}
			}
		i++;
		}
		if(!donne) {
			System.out.println("Vous netes pas le maitre de ce pokemon : vous ne pouvez donc pas le donner");
		}
	}
	
	public void echanger(Pokemon pokemonchange, Joueur autreJoueur, Pokemon autrePokemon) {
		boolean echange = false;
		int i = 0;
		while(!echange && i <this.tabPokemon.length) {
			if (this.tabPokemon[i] == pokemonchange) {
				int j = 0;
				while(!echange && j<autreJoueur.tabPokemon.length) {
					if(autreJoueur.tabPokemon[j]== autrePokemon) {
						tabPokemon[i] = autrePokemon;
						autreJoueur.tabPokemon[j] = pokemonchange;
						pokemonchange.setMonJoueur(autreJoueur);
						autrePokemon.setMonJoueur(this);
						echange = true;
					}
			   j++;
		}
		if(!echange) {
			System.out.println("Vous ne pouvez pas echange ce pokemon avec " + autreJoueur.prenom + " puisque " + autreJoueur.nom + " n est pas le maitre du pokemon que vous souhaitez !");
		}
	}
	i++;
	}
		if(!echange) {
			System.out.println("Vous ne pouvez pas echange ce pokemon avec " + autreJoueur.prenom + " puisque " + autreJoueur.nom + " n est pas le maitre du pokemon que vous souhaitez !");
		}
  }
	
}