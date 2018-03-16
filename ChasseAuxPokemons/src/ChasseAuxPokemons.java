import tp1.Joueur;
import tp1.Nourriture;
import tp1.Pokemon;
import tp1.Gourmandise;
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

		
		//Les joueurs
		
		final Joueur joueur1 = new Joueur("Durant","Sachat",20,new Pokemon[5]);
		final Joueur joueur2 = new Joueur("Dupont","Pierre",20, new Pokemon[5]);
		// Jean capture un pokemon qu'il nomme "Rascal " et le donne à Gabrielle
		joueur1.capturer(p1);
		
		
		final Nourriture Nourriture1 = new Nourriture(35,"Tartiflette",new String[30]);
		final Nourriture Nourriture2 = new Nourriture(10,"Ratatouille",new String[30]);
		// la nourriture
		final Nourriture tartiflette = new Nourriture(35,"tartiflette", new String[] {"DRAGON", "FEU", "COMBAT", "EAU", "ELECTRIQUE"});
		final Nourriture ratatouille = new Nourriture(10, "ratatouille", new String[] {"PLANTE", "EAU", "VOL", "FEU", "NORMAL", "ELECTRIQUE", "COMBAT"}); 
		
		final Gourmandise barreChocolatee = new Gourmandise(30,"barreChocolatee",new String[] {"PLANTE"},2,50,50);

		final Nourriture carotte = new Nourriture(2, "carotte", new String[] {"PLANTE", "TERRE", "VOL"});
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
		}
	}
}