package projet_poo;

import java.util.ArrayList;
import java.util.List;

public class Agent_Immobilier {
	 // Attributs
    private String nom;
    private String prenom;
    private int Experience; // en années
    private List<Bien_Immobilier> biens;

    // Constructeur
    public Agent_Immobilier(String nom, String prenom, int periodeExperience) {
        this.nom = nom;
        this.prenom = prenom;
        this.Experience = periodeExperience;
        this.biens = new ArrayList<>();
    }
    
 // Getters et Setters
    
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

    public int getPeriodeExperience() {
        return Experience;
    }

    public void setPeriodeExperience(int periodeExperience) {
        this.Experience = periodeExperience;
    }

    public List<Bien_Immobilier> getBiens() {
        return biens;
    }

    public void setBiens(List<Bien_Immobilier> biens) {
        this.biens = biens;
    }

    // Méthode pour ajouter un bien immobilier à l'agent
    
    public void ajouterBien(Bien_Immobilier bien) {
        biens.add(bien);
    }

    // Méthode pour afficher les biens immobiliers de l'agent
    public void afficherBiensAgent() {
        System.out.println("Biens immobiliers de l'agent " + prenom + " " + nom + ":");
        for (Bien_Immobilier bien : biens) {
            System.out.println(bien.getDescription());
        }
    }

    
}
