package projet_poo;

public class préférances{
    // Attributs
    private String nom;
    private String prenom;
    private int num;
    private double prixMax;
    private double superficieMin;
    private String type;
    private String typeDeInteraction;

    // Constructeur
    public préférances(String nom, String prenom, int num, double prixMax, double superficieMin, String type, String typeDeInteraction) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.prixMax = prixMax;
        this.superficieMin = superficieMin;
        this.type = type;
        this.typeDeInteraction = typeDeInteraction;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(double prixMax) {
        this.prixMax = prixMax;
    }

    public double getSuperficieMin() {
        return superficieMin;
    }

    public void setSuperficieMin(double superficieMin) {
        this.superficieMin = superficieMin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDeInteraction() {
        return typeDeInteraction;
    }

    public void setTypeDeInteraction(String typeDeInteraction) {
        this.typeDeInteraction = typeDeInteraction;
    }
}


