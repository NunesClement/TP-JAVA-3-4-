package tp1;

public class Pokemon {
	private String nom;
	private String type; 
	private int niveau;
	private Boolean diurne = true;
	private String nomDonne;//renommer le pokemon
	private Joueur monJoueur;
//	private Joueur joueurNoman;// afin de savoir qui a renommer le pokemon
	private int appetit;
	private int loyaute;
	private int satisfaction;
	private int hp;
	private int hp_restant;
	private Attaque[] sesAttaques;
	
	//Constructeur
	public Pokemon(String monNom,String montype,int monNiveau, Boolean typeDiurne, int appetit, int loyaute, int satisfaction,int hp,int hp_restant, Attaque[] sesAttaques){
		this(monNom,montype,monNiveau,typeDiurne,null,null,appetit,loyaute,satisfaction,hp,hp_restant,sesAttaques);
	}
	
	//Constructeur Pokemon une fois Capture
	public Pokemon(String monNom,String montype,int monNiveau, Boolean typeDiurne, String monNomDonne, Joueur monJoueur , int appetit, int loyaute, int satisfaction, int hp,int hp_restant,Attaque[] sesAttaques2){
		this.nom = monNom;
		this.type = montype;
		this.niveau = monNiveau;
		this.diurne = typeDiurne;
		this.nomDonne = monNomDonne;
		this.monJoueur = monJoueur;
		this.appetit = appetit;
		this.loyaute = loyaute;
		this.satisfaction = satisfaction;
		this.hp = hp;
		this.hp_restant = hp_restant;
		this.sesAttaques= new Attaque[4];
		for (int i = 0; i < sesAttaques2.length; i++) {
			if (sesAttaques2[i]!=null) 
				this.addAttaque(sesAttaques2[i]);
		}
	}
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp_restant() {
		return hp_restant;
	}

	public void setHp_restant(int hp_restant) {
		this.hp_restant = hp_restant;
	}

		//Getters and setters
		public String getNom() {
	        return this.nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getType() {
	        return this.type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public int getNiveau() {
	        return this.niveau;
	    }

	    public void setNiveau(int niveau) {
	        this.niveau = niveau;
	    }

	    public Boolean getDiurne() {
	        return diurne;
	    }

	    public void setDiurne(Boolean diurne) {
	        this.diurne = diurne;
	    }

	    public String getNomDonne() {
	        return nomDonne;
	    }

	    public void setNomDonne(String nomDonne) {
	        this.nomDonne = nomDonne;
	    //    this.joueurNoman = this.monJoueur;
	        if (null == this.nomDonne) {
	        	this.monteLoyaute(10);
	        }
	        else {
	        	this.baisseLoyaute(10);
	        }

	    }

	    public Attaque[] getSesAttaques() {
			return sesAttaques;
		}

		public void setSesAttaques(Attaque[] sesAttaques) {
			this.sesAttaques = sesAttaques;
		}

		public Joueur getMonJoueur() {
	        return this.monJoueur;
	    }

	    public void setMonJoueur(Joueur monJoueur) {
	        this.monJoueur = monJoueur;
	    }
	    public int getAppetit() {
	    	return this.appetit;
	    }
	    public int getLoyaute() {
	    	return this.loyaute;
	    }
	    public int getSatisfaction() {
	    	return this.satisfaction;
	    }
	    public void setAppetit(int appetit) {
	    	this.appetit = appetit;
	    }
	    public void setLoyaute(int loyaute) {
	    	this.loyaute = loyaute;
	    }
	    public void setSatisfaction(int satisfaction) {
	    	this.satisfaction = satisfaction;
	    }
	    
	public String toString(){
		if (monJoueur != null) {
			if (this.nomDonne != null){
				return (this.nomDonne + " est un pokemon du genre" + this.nom + ", du type " + this.type + ", qui a le niveau " + this.niveau + ". Ce pokemon appartient a " + monJoueur.getNom() + " " + monJoueur.getPrenom() + ". Il/Elle a un appetit de " + this.appetit + ", un niveau de satisfaction de " + this.satisfaction + " et une loyaute aupres son maitre de " + this.loyaute + " Points de vie "+ this.hp + ".");
			}
			else {
				return ("Voici un pokemon du genre " + this.nom + ", du type " + this.type + ", qui a le niveau " + this.niveau + ". Ce pokemon appartient a " + this.monJoueur.getNom() + " " + this.monJoueur.getPrenom() + ". Il/Elle a un appetit de " + this.appetit + ", un niveau de satisfaction de " + this.satisfaction + " et une loyaute aupres son maitre de " + this.loyaute +" Points de vie "+ this.hp+ ".");
			}
			} else {
				return "Voici un pokemon du genre " + this.nom + ", du type " + this.type + ", qui a le niveau " + this.niveau + ". Ce pokemon n'a pas encore de maitre. Il/Elle a un appetit de " + this.appetit + " une satisfaction de " + this.satisfaction + " et une loyaute de " + this.loyaute + " Points de vie "+ this.hp + ".";
			}
	}
	
	//Methode dire bonjour
	public void direBonjour(String periode){
		if (periode.equals("jour"))
			if(this.diurne){
				System.out.println(this.nom + " dit bonjour !");
			}
			else{
				System.out.println("zzZZ !");
			}
		else{
			if(!this.diurne){
				System.out.println(this.nom + " dit bonjour !");
			}
			else{
				System.out.println("zzZZ !");
			}		
		}
	}
	public void estCapture() {
		this.loyaute = 0;
		if (this.satisfaction > 10) {
			this.satisfaction = 10;
		}
		if (this.appetit > 10) {
			this.appetit = 10;
		}
	}
	public void estLibere() {
		if (this.loyaute > 10) {
			this.baisseSatisfaction(this.loyaute - 10);
		}
			this.loyaute = 0;
		}
		public void baisseAppetit(int difference) {
			this.appetit = this.appetit - difference;
		if (this.appetit < 0) {
			this.appetit = 0;
			}
		}
		public void monteAppetit(int difference) {
		this.appetit = this.appetit + difference;
		if (this.appetit > 100) {
				this.appetit = 100;
			}
		}
		public void baisseSatisfaction(int difference) {
			this.satisfaction = this.satisfaction - difference;
			if (this.satisfaction < 0) {
				this.satisfaction = 0;
			}
		}
		public void monteSatisfaction(int difference) {
			this.satisfaction = this.satisfaction + difference;
		if (this.satisfaction > 100) {
			this.satisfaction = 100;
			}
		}
		public void baisseLoyaute(int difference) {
			this.loyaute = this.loyaute - difference;
			if (this.loyaute < 0) {
				this.loyaute = 0;
			}
		}
		public void monteLoyaute(int difference) {
			this.loyaute = this.loyaute + difference;
			if (this.loyaute > 100) {
				this.loyaute = 100;
			}
		}
		public void mange(Nourriture nourriture)
		{
			if (nourriture.estCompatible(this.type) )
				nourriture.estMangee(this);
			else 
				System.out.println("type du Pokemon pas compatible avec nourriture");
		}
		public void addAttaque(Attaque a){
			for (int i = 0; i < sesAttaques.length; i++) {
				if(sesAttaques[i]==null && a.estCompatible(this) )
					this.sesAttaques[i] = a;
			}
		}
		public void removeAttaque(int index){
			if (index >= sesAttaques.length-1 && index <=0)
				sesAttaques[index]=null;
			else 
				System.out.println("index non compris dans intervalle");
		}
		public void regarderAttaque(){
			for (int i = 0; i < sesAttaques.length; i++) {
				if (sesAttaques[i]!=null) {
					System.out.println(i + sesAttaques[i].toString() + sesAttaques[i].getPp_restant());
				}	
			}
		}
		public void resetAttaque() {
			for(int i = 0; i<sesAttaques.length;i++) {
				sesAttaques[i].resetRepetition();
			}
		}
		public boolean sestEvanoui() {
			boolean zero = false;
			if(this.hp ==0) {
				return zero;
			}
			return zero;
		}
		public void estBlesse(int domage) {
			if(this.sestEvanoui() != true) {
				this.hp = this.hp - domage;
			}
			else {
				System.out.println("Le pokemon ne peux pas prendre plus de dommage");
			}
		}
		public void utiliseAttaque(int index, Pokemon victime) {
			if(this.sestEvanoui() != true && index > 0 && index < sesAttaques.length && sesAttaques[index] != null) {
				
			}
		}
}