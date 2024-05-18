package projet_poo;

import java.util.ArrayList;
import java.util.List;

public class TransactionV {
	
	private String nomClient;
    private String prenomClient;
    private int numTelephone;
    private String type;
    private int ImmobileID;
    private double prix;
    private String dateDelai;
    private List<Paiements> paiements;
    

    
    // Constructeur
    
    
    public TransactionV (String nomClient, String prenomClient, int numTelephone, String type, int ImmobileID, double prix, String dateDelai) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.numTelephone = numTelephone;
    	this.type = type;
    	this.ImmobileID = ImmobileID;
    	this.prix = prix;
    	this.dateDelai = dateDelai;
    	this.paiements = new ArrayList<Paiements>();
    }




	//Getters & Setters


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getPrenomClient() {
		return prenomClient;
	}


	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}


	public int getNumTelephone() {
		return numTelephone;
	}


	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getImmobileID() {
		return ImmobileID;
	}

	public void setImmobileID(int immobileID) {
		ImmobileID = immobileID;
	}


	public String getDateDelai() {
		return dateDelai;
	}

	public void setDateDelai(String dateDelai) {
		this.dateDelai = dateDelai;
	}


	public double getPrix() {
		return prix;
	}

	
	public void setPrix(double prix) {
		this.prix = prix;
	}


	public List<Paiements> getPaiements() {
		return paiements;
	}


	public void setPaiements(List<Paiements> paiements) {
		this.paiements = paiements;
	}

	
	
	
	public void afficherVendeur(int i) {
		
	        System.out.println("Transaction num : " + i+1);			    
		    System.out.print("Nom de client: ");
		    System.out.println(this.nomClient);
		    
		    
		    System.out.print("Prenom de client: ");
		    System.out.println(this.prenomClient);
		    
		    
		    System.out.print("Numero de telephone: ");
		    System.out.println(this.numTelephone);
		    
		    
		    System.out.print("Type de transaction: ");
		    System.out.println(this.type);
		    
		    
			System.out.print("ID de l'immobilier: ");
		    System.out.println(this.ImmobileID);
		   
		    
			System.out.print("Prix de transaction: ");
		    System.out.println(this.prix);

		    
			System.out.print("Delai de transaction: ");
		    System.out.println(this.dateDelai);

		    
		    if ( !this.paiements.isEmpty() ) {
		    	
		    	 for ( int j=0; j<this.paiements.size(); j++) {
		    		 int n = j+1;
		    		 
		    		 System.out.println("Paiement échelonné num " + n + ":");
		    		 System.out.print("Paiement: ");
					 System.out.println(this.paiements.get(j).getPaiement());
					    
					    
			         System.out.print("Date d'échéance: ");
				     System.out.println(this.paiements.get(j).getDatePaiement());
		    	 }
		    }
		   
	}
	
    
    
 
}

