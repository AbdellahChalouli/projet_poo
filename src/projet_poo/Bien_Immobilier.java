package projet_poo;


public class Bien_Immobilier {
	  
	    // Attributs
	    private int id;
	    private String type;
	    private double superficie;
	    private double prix;
	    private String localisation;
	    private String paiement;
	    private String description;
	    private String nomAgent;
	    int nbpièces, nbétages; //pour les appartement et les villa 
	    String etat;
	    String typedeinteraction;

	    
	    
	    public Bien_Immobilier(int id, String type, double superficie, double prix, String localisation, String paiement,
		String description, String nomAgent, int nbpièces, int nbétages ,String etat ,String typedeinteraction ) {
	super();
	this.id = id;
	this.typedeinteraction=typedeinteraction;
	this.type = type;
	this.superficie = superficie;
	this.prix = prix;
	this.localisation = localisation;
	this.paiement = paiement;
	this.description = description;
	this.nomAgent = nomAgent;
	this.nbpièces = nbpièces;
	this.nbétages = nbétages;
    this.etat=etat;
	    
	    }


	    
	    
	    public Bien_Immobilier(int id, String type, double superficie, double prix, String localisation, String paiement,
		String description, String nomAgent, int nbpièces, int nbétages) {
	super();
	this.id = id;
	this.type = type;
	this.superficie = superficie;
	this.prix = prix;
	this.localisation = localisation;
	this.paiement = paiement;
	this.description = description;
	this.nomAgent = nomAgent;
	this.nbpièces = nbpièces;
	this.nbétages = nbétages;
}

		// Gettersh
	    public String getType() {
	        return type;
	    }
	   
	    public String gettypedeinteraction() {
	        return typedeinteraction;
	    }
	    
	    public String getetat() {
	        return type;
	    }
	    
	    public double getSuperficie() {
	        return superficie;
	    }

	    public double getPrix() {
	        return prix;
	    }

	    public String getLocalisation() {
	        return localisation;
	    }

	    public String getPaiement() {
	        return paiement;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public String getNomAgent() {
	        return nomAgent;
	    }

	    // Setters (si nécessaire)
	    public void setType(String type) {
	        this.type = type;
	    }

	    public void setSuperficie(double superficie) {
	        this.superficie = superficie;
	    }

	    public void setPrix(double prix) {
	        this.prix = prix;
	    }

	    public void setLocalisation(String localisation) {
	        this.localisation = localisation;
	    }

	    public void setPaiement(String paiement) {
	        this.paiement = paiement;
	    }

	    public void settypedeinteraction(String typedeinteraction) {
	        this.typedeinteraction = typedeinteraction;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public void setNomAgent(String nomAgent) {
	        this.nomAgent = nomAgent;
	    }
	    public void setetat(String etat) {
	        this.etat = etat;
	    }
	    public int getNbpièces() {
			return nbpièces;
		}

		public void setNbpièces(int nbpièces) {
			this.nbpièces = nbpièces;
		}

		public int getNbétages() {
			return nbétages;
		}

		public void setNbétages(int nbétages) {
			this.nbétages = nbétages;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	}


