package projet_poo;

public class Interaction {

    private int idInteraction;
   
    private String typeInteraction;
    
    private String description;
    

    // Constructeurs

    public Interaction() {
    }

    public Interaction(int idInteraction, String typeInteraction, String description) {
        this.idInteraction = idInteraction;
       
        this.typeInteraction = typeInteraction;
       
        this.description = description;
        
    }

    // Getters et setters

    public int getIdInteraction() {
        return idInteraction;
    }

    public void setIdInteraction(int idInteraction) {
        this.idInteraction = idInteraction;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

  

    public String getTypeInteraction() {
        return typeInteraction;
    }

    public void setTypeInteraction(String typeInteraction) {
        this.typeInteraction = typeInteraction;
    }

 
}