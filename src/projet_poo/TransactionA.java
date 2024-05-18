package projet_poo;

public class TransactionA {
	
	private String nomClient;
	 private String prenomClient;
	 private int numTelephone;
	 private int ImmobileID;
	 private double prix;



 // Constructeurs

public TransactionA(String nomClient, String prenomClient, int numTelephone, int immobileID, double prix) {
	this.nomClient = nomClient;
	this.prenomClient = prenomClient;
	this.numTelephone = numTelephone;
	ImmobileID = immobileID;
	this.prix = prix;
}


 // Getters & Setters


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



public int getImmobileID() {
	return ImmobileID;
}



public void setImmobileID(int immobileID) {
	ImmobileID = immobileID;
}



public double getPrix() {
	return prix;
}



public void setPrix(double prix) {
	this.prix = prix;
}


public void afficherAcheteur(int i) {
	 System.out.println("Transaction num : " + i+1);			    
	    System.out.print("Nom de client: ");
	    System.out.println(this.nomClient);
	    
	    
	    System.out.print("Prenom de client: ");
	    System.out.println(this.prenomClient);
	    
	    
	    System.out.print("Numero de telephone: ");
	    System.out.println(this.numTelephone);
	    
	    
	    
		System.out.print("ID de l'immobilier: ");
	    System.out.println(this.ImmobileID);
	   
	    
		System.out.print("Prix de transaction: ");
	    System.out.println(this.prix);

}

}
