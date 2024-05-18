package projet_poo;
public class Paiements {

	private double paiement;
	private String datePaiement;
	
	
	
	// constructeurs
	public Paiements () {};
	
	public Paiements ( double paiement, String datePaiement) {
		this.paiement = paiement;
		this.datePaiement = datePaiement;
	}

	
	
	
	//Getters & Setters
	public double getPaiement() {
		return paiement;
	}

	public void setPaiement(double paiement) {
		this.paiement = paiement;
	}

	public String getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(String datePaiement) {
		this.datePaiement = datePaiement;
	}
	
}
