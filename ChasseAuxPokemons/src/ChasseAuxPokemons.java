import tp1.Joueur;
import tp1.Nourriture;
import tp1.Pokemon;
import tp1.Gourmandise;
import tp1.Potionmagique;
import java.util.Scanner;

public class ChasseAuxPokemons {

	public static void main(String[] args) {

		//Elles ne compileront pas car il n'y a plus le booleen "diurne ou nocturne"
		
		final Pokemon p1 = new Pokemon("Piplup","EAU",5, true, 50,0,50);
		final Pokemon p2 = new Pokemon("Rowlet","PLANTE",10, false, 50,0,50);
		final Pokemon p3 = new Pokemon("Totodile","EAU",8, true, 50,0,50);
		final Pokemon p4 = new Pokemon("Aflamanoir","FEU",7, true, 50,0,50);
		final Pokemon p5 = new Pokemon("Bétochef","COMBAT",7, true, 50,0,50);
		final Pokemon p6 = new Pokemon("Elektek","ELECTRIQUE",7, true, 50,0,50);
		final Pokemon p7 = new Pokemon("Boumata","DRAGON",7, true, 50,0,50);
		final Pokemon p8 = new Pokemon("Salameche","FEU",7, true, 50,0,50);
		final Pokemon p9 = new Pokemon("Bulbizarre","PLANTE",7, true, 50,0,50);
		final Pokemon p10 = new Pokemon("Carapuce","EAU",7, true, 50,0,50);
		//Les joueurs
		
		final Joueur joueur1 = new Joueur("Durant","Sachat",20,new Pokemon[5]);
		final Joueur joueur2 = new Joueur("Dupont","Pierre",20, new Pokemon[5]);
		// Jean capture un pokemon qu'il nomme "Rascal " et le donne à Gabrielle
		joueur1.capturer(p1);
		final Joueur joueur3 = new Joueur("Morales","Andrea",20,new Pokemon[5]);
		final Joueur joueur4 = new Joueur("Zeña","Carla",20, new Pokemon[5]);
		final Nourriture carotte = new Nourriture(2, "carotte", new String[] {"PLANTE", "TERRE", "VOL"});
		final Nourriture nourriture1 = new Nourriture(35,"Tartiflette",new String[30]);
		final Nourriture nourriture2 = new Nourriture(10,"Ratatouille",new String[30]);
		// la nourriture
		final Nourriture tartiflette = new Nourriture(35,"tartiflette", new String[] {"DRAGON", "FEU", "COMBAT", "EAU", "ELECTRIQUE"});
		final Nourriture ratatouille = new Nourriture(10, "ratatouille", new String[] {"PLANTE", "EAU", "VOL", "FEU", "NORMAL", "ELECTRIQUE", "COMBAT"}); 
		
		//La compatibilite n'est pas terminée
		final Gourmandise barreChocolatee = new Gourmandise(20,"Barre Chocolatee",new String[] {"PLANTE"},10,7,5);
		final Potionmagique mojito = new Potionmagique(0,"mojito",new String[] {"FEU"});
		
		joueur1.capturer(p1);
		joueur1.capturer(p2);
		joueur1.capturer(p4);
		joueur1.donner(p1, joueur2);
		joueur1.donner(p2, joueur3);
		joueur2.regarderPokemon(p1);
		joueur3.regarderPokemon(p2);
		
		joueur2.ajoutNourriture(tartiflette);
		joueur2.ajoutNourriture(carotte);
		joueur2.ajoutNourriture(barreChocolatee);
		joueur2.afficheCaisseNourriture();
		joueur2.ajoutNourriture(mojito);
		joueur3.ajoutNourriture(ratatouille);
		joueur3.ajoutNourriture(mojito);
		joueur3.afficheCaisseNourriture();
		System.out.println(p2.getAppetit());
		joueur2.nourrir(p1, 2);//On le donne de la nourriture qui n'est pas compatible
		joueur3.nourrir(p1, 2);//On essaye de nourrir un pokemon qui ne  lui appartient pas
		joueur2.nourrir(p1, 4);//On utilise une caisse qui contient null
		joueur3.nourrir(p2, 0);//On donne de la nourriture compatible au pokemon qui lui appartient 
		System.out.println(p2.getAppetit());
		joueur3.afficheCaisseNourriture();//On a bien verifié que la nourriture  a bien disparu après de  faire manger au pokemon
		
		Scanner lecteur = new Scanner(System.in);
		System.out.println("entrer votre nom");
		String nomJoueur = lecteur.nextLine();
		System.out.println("entrer votre prenom");
		String prenomJoueur = lecteur.nextLine();
		System.out.println("Quelle age avez vous");
		int ageJoueur = lecteur.nextInt();
		String reponse;
		int rep;
		int rep2;
		final Joueur joueur = new Joueur(nomJoueur,prenomJoueur,ageJoueur,new Pokemon[5]);
		System.out.println("Bonjour "+joueur.getPrenom()+" et bienvenue dans le merveilleux monde des pokemons");
		joueur.capturer(p9);
		joueur.capturer(p2);
		joueur.capturer(p3);
		String continuer;
		do {
			System.out.println("voulez vous observez vos pokemons oui/non");
			do{
				reponse = lecteur.nextLine();
			}while (!(reponse.equals("oui") || reponse.equals("non")));
			System.out.println("moi oui");
			if(reponse.equals("oui")) {			
				joueur.affichePokemon();
				System.out.println("quelle pokemon voulez vous voir");
				rep = lecteur.nextInt();
				joueur.regarderPokemon(joueur.getPokemon(rep-1)); //attention non fonctionnnel
				System.out.println("voulez vous observez votre caisse de nourriture oui/non");
				do{
					reponse = lecteur.nextLine();
				}while (!(reponse.equals("oui") || reponse.equals("non")));
				if(reponse.equals("oui")) 
					joueur.afficheCaisseNourriture();
				System.out.println("voulez vous nourriture un de vos pokemon oui/non");
				do{
					reponse = lecteur.nextLine();
				}while (!(reponse.equals("oui") || reponse.equals("non")));
				if(reponse.equals("oui")) {
					System.out.println("quelle pokemon nourrir puis avec quelle nourriture saisir index");
					joueur.affichePokemon();
					rep = lecteur.nextInt();
					joueur.afficheCaisseNourriture();
					rep2 = lecteur.nextInt();
					joueur.nourrir(joueur.getPokemon(rep-1),rep2);// attention pas de verif et affichage non opti
				}
				Nourriture n = carotte.genAlea();
			if (n == null) {
					System.out.println("Vous n'avez rien trouve. Si vous voulez vous arreter, tapez << stop >> . Sinon, tapez << non >> .");
				reponse = lecteur.next();
				while (!reponse.equals("non") && reponse.equals("stop")) {
					System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
					reponse = lecteur.next();
				}
			}
			else {
				do {
					System.out.println(" voulez vous le prendre oui / non ");
					reponse = lecteur.next();
				}while (!(reponse.equals("oui") || reponse.equals("non")));
				if (reponse.equals("oui")) {
					joueur.ajoutNourriture(n);
				}
			}
			}
			do{
				System.out.println("voulez vous continuez");
				continuer = lecteur.nextLine();
			}while (!(reponse.equals("oui") || reponse.equals("non")));	
					
		}while (continuer.equals("oui"));
	/*	mojito.estMangee(p2);
		barreChocolatee.estMangee(p2);
		
		mojito.estMangee(p4);
		barreChocolatee.estMangee(p4);*/

		/*final Nourriture carotte = new Nourriture(2, "carotte", new String[] {"PLANTE", "TERRE", "VOL"});
				System.out.println(carotte);
				for (int i = 0; i < 10; i++) {
					System.out.println(tartiflette.genAlea());
					System.out.println(ratatouille.genAlea());
				}
				Scanner lecteur = new Scanner(System.in);
				System.out.println("");
				String reponse = "";
				while (!reponse.equals("stop")) {
					Nourriture n = carotte.genAlea();
					if (n == null) {
						System.out.println("Vous n'avez rien trouve. Si vous voulez vous arreter, tapez << stop >> . Sinon, tapez << non >> .");
					reponse = lecteur.next();
				while (!reponse.equals("non") && reponse.equals("stop")) {
					System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
					reponse = lecteur.next();
				}
				} else {
					System.out.println("Vous avez trouve un(e) " + n.getIngredient() + ".");
					System.out.println("Voulez vous la prendre ? << oui / non / stop>>");
					reponse = lecteur.next();
				while (!reponse.equals("oui") && !reponse.equals("non") && !reponse.equals("stop")) {
					System.out.println("Repetez votre choix s.v.p. Il faut taper << oui >>, << non >> ou << stop >>");
					reponse = lecteur.next();
				}
				if (reponse.equals("oui")) {
					System.out.println("Vous avez pris le/la " +
					n.getIngredient() + ".");
					System.out.println("Voulez-vous vous arreter ? Tapez << stop >>. Sinon, tapez << non >>");
					reponse = lecteur.next();
					while (!reponse.equals("non") && !reponse.equals("stop")) {
						if (reponse.equals("stop")) {
							System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
							reponse = lecteur.next();
						}
					}
				}
				while(p7.getAppetit()!=0){
					System.out.println();
					System.out.println(p7.getAppetit());
					p7.mange(carotte);
					System.out.println(p7.getAppetit());
				}
			}	
		}*/
	}
}