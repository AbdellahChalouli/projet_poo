package projet_poo;

import java.util.ArrayList;
import java.util.List;


public class Client {

    private int idClient;
    private String nom;
    private String prenom;
    private String typeClient;
  
    private int num ;
   
    private List<Interaction> interactions;
    private List<TransactionV> transactionVendeur;
    private List<TransactionA> transactionAcheteur;
    // Constructeurs

    
    public Client( String nom, String prenom, int num  ) {
    	this.nom = nom;
        this.prenom = prenom;
        this.num=num;

    }
    
    public Client() {
    }

    public Client(int idClient, String nom, String prenom, String typeClient,int num ) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.typeClient = typeClient;
        this.num=num;
       
       
        this.interactions = new ArrayList<>();
    }

    // Getters et setters

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public int  getnum() {
        return num;
    }

    public void setnum(int  num) {
        this.num = num;
    }

   

   
    
    public List<TransactionV> getTransactionV() {
		return transactionVendeur;
	}

	public void setTransactionV(List<TransactionV> transactionVendeur) {
		this.transactionVendeur = transactionVendeur;
	}

	public List<TransactionA> getTransactionA() {
		return transactionAcheteur;
	}

	public void setTransactionA(List<TransactionA> transactionAcheteur) {
		this.transactionAcheteur = transactionAcheteur;
	}
	
	
	

	public List<Interaction> getInteractions() {
        return interactions;
    }

    public void addInteraction(Interaction interaction) {
        this.interactions.add(interaction);
    }

    
}

