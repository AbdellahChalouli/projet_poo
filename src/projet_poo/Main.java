package projet_poo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


	
	public static void addClient(List<Client> clients, Scanner scanner) {
	    // Demande à l'utilisateur de saisir les informations du client
	   
	    System.out.print("Nom du client : ");
	    String nom = scanner.nextLine();

	    System.out.print("Prénom du client : ");
	    String prenom = scanner.nextLine();

	    System.out.print("Type du client : ");
	    String typeClient = scanner.nextLine();

	    

	    System.out.print("Numéro du client : ");
	    int num = Integer.parseInt(scanner.nextLine()); // Lecture du numéro du client

	    // Création d'un nouveau client avec les informations saisies
	    Client client = new Client( nom, prenom, typeClient, num);

	    // Boucle pour saisir les interactions du client
	    while (true) {
	        System.out.println("Veuillez saisir les informations de l'interaction  :");
	        System.out.print("ID de l'interaction : ");
	        int idInteraction = Integer.parseInt(scanner.nextLine());

	        System.out.print("Type de l'interaction : ");
	        String typeInteraction = scanner.nextLine();

	       
	        System.out.print("Description de l'interaction : ");
	        String description = scanner.nextLine();

	        // Création d'une nouvelle interaction avec les informations saisies
	        Interaction interaction = new Interaction(idInteraction, typeInteraction, description);

	        // Ajout de l'interaction à la liste des interactions du client
	        client.addInteraction(interaction);

	        // Vérifie si l'utilisateur veut ajouter une autre interaction
	        System.out.println("Voulez-vous ajouter une autre interaction ? (oui/non)");
	        String response = scanner.nextLine().toLowerCase();
	        if (!response.equals("oui")) {
	            break; // Sortie de la boucle si la réponse n'est pas "oui"
	        }
	    }

	    // Ajout du client à la liste des clients
	    clients.add(client);

	    System.out.println("Le client " + nom + " " + prenom + " avec le numéro " + num + " a été ajouté avec succès.");
	}
	
	public static void addInteractionToClient(List<Client> clients, Scanner scanner) {
        // Demander à l'utilisateur le nom, prénom et numéro du client
        System.out.println("Veuillez saisir le nom du client :");
        String nom = scanner.nextLine();

        System.out.println("Veuillez saisir le prénom du client :");
        String prenom = scanner.nextLine();

        System.out.println("Veuillez saisir le numéro du client :");
        int num = Integer.parseInt(scanner.nextLine());

        // Recherche du client dans la liste des clients
        for (Client client : clients) {
            if (client.getNom().equalsIgnoreCase(nom) &&
                client.getPrenom().equalsIgnoreCase(prenom) &&
                client.getnum() == num) {
                // Si le client est trouvé, demander à l'utilisateur de saisir les informations de l'interaction
                System.out.println("Veuillez saisir les informations de l'interaction :");
                System.out.print("ID de l'interaction : ");
                int idInteraction = Integer.parseInt(scanner.nextLine());

                System.out.print("Type de l'interaction : ");
                String typeInteraction = scanner.nextLine();

                

                System.out.print("Description de l'interaction : ");
                String description = scanner.nextLine();

                // Création de l'interaction
                Interaction interaction = new Interaction(idInteraction, typeInteraction,  description);

                // Ajout de l'interaction au client
                client.addInteraction(interaction);

                System.out.println("L'interaction a été ajoutée avec succès pour le client " + nom + " " + prenom + " avec le numéro " + num);
                return;
            }
        }

        // Si le client n'est pas trouvé
        System.out.println("Le client " + nom + " " + prenom + " avec le numéro " + num + " n'a pas été trouvé.");
    }
	
	
	public static void removeClient(List<Client> clients, Scanner scanner) {
        // Demander à l'utilisateur le nom, prénom et numéro du client à supprimer
        System.out.println("Veuillez saisir le nom du client :");
        String nom = scanner.nextLine();

        System.out.println("Veuillez saisir le prénom du client :");
        String prenom = scanner.nextLine();

        System.out.println("Veuillez saisir le numéro du client :");
        int num = Integer.parseInt(scanner.nextLine());

        // Recherche du client à supprimer
        boolean clientFound = false;
        for (Client client : clients) {
            if (client.getNom().equalsIgnoreCase(nom) &&
                    client.getPrenom().equalsIgnoreCase(prenom) &&
                    client.getnum() == num) {
                clients.remove(client); // Suppression du client
                System.out.println("Le client " + nom + " " + prenom + " avec le numéro " + num + " a été supprimé avec succès.");
                clientFound = true;
                break;
            }
        }

        // Si aucun client correspondant n'a été trouvé
        if (!clientFound) {
            System.out.println("Le client " + nom + " " + prenom + " avec le numéro " + num + " n'a pas été trouvé.");
        }
        
        // Demander à l'utilisateur de revenir au menu principal
        System.out.println("Appuyez sur Entrée pour revenir au menu principal.");
        scanner.nextLine(); // Attendre que l'utilisateur appuie sur Entrée
	}
	
	public static void displayClients(List<Client> clients) {
        if (clients.isEmpty()) {
            System.out.println("La liste des clients est vide.");
        } else {
            System.out.println("Liste des clients :");
            for (Client client : clients) {
                System.out.println("Nom : " + client.getNom());
                System.out.println("Prénom : " + client.getPrenom());
                System.out.println("Numéro : " + client.getnum());
                System.out.println("---------------------");
            }
        }
    }
    public static void editClient(List<Client> clients, Scanner scanner) {
        // Demande à l'utilisateur d'entrer le nom, prénom et numéro du client à modifier
        System.out.println("Veuillez saisir le nom du client :");
        String nom = scanner.nextLine();

        System.out.println("Veuillez saisir le prénom du client :");
        String prenom = scanner.nextLine();

        System.out.println("Veuillez saisir le numéro du client :");
        int num = Integer.parseInt(scanner.nextLine());

        // Recherche du client à modifier
        for (Client client : clients) {
            if (client.getNom().equalsIgnoreCase(nom) &&
                client.getPrenom().equalsIgnoreCase(prenom) &&
                client.getnum() == num) {
                
                System.out.println("Saisissez les nouvelles informations pour le client :");
                
               

                System.out.print("Nouveau nom du client : ");
                String nouveauNom = scanner.nextLine();
                client.setNom(nouveauNom);

                System.out.print("Nouveau prénom du client : ");
                String nouveauPrenom = scanner.nextLine();
                client.setPrenom(nouveauPrenom);

                System.out.print("Nouveau type du client : ");
                String nouveauTypeClient = scanner.nextLine();
                client.setTypeClient(nouveauTypeClient);

               
                System.out.print("Nouveau numéro du client : ");
                int nouveauNum = Integer.parseInt(scanner.nextLine());
                client.setnum(nouveauNum);

                System.out.println("Les informations du client ont été modifiées avec succès.");
                return;
            }
        }
        System.out.println("Le client " + nom + " " + prenom + " avec le numéro " + num + " n'a pas été trouvé.");
    }
        
    
    public static void displayInteractions(List<Client> clients, Scanner scanner) {
        while (true) {
            // Demander à l'utilisateur le nom, prénom et numéro du client
            System.out.println("Veuillez saisir le nom du client (ou tapez 'quit' pour revenir au menu principal) :");
            String nom = scanner.nextLine();
            if (nom.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Veuillez saisir le prénom du client :");
            String prenom = scanner.nextLine();

            System.out.println("Veuillez saisir le numéro du client :");
            int num = Integer.parseInt(scanner.nextLine());
            
            // Parcourir la liste des clients pour trouver le client spécifié
            boolean clientFound = false;
            for (Client client : clients) {
                if (client.getNom().equalsIgnoreCase(nom) &&
                    client.getPrenom().equalsIgnoreCase(prenom) &&
                    client.getnum() == num) {
                    // Afficher les interactions du client
                    List<Interaction> interactions = client.getInteractions();
                    if (interactions.isEmpty()) {
                        System.out.println("Ce client n'a pas encore d'interactions enregistrées.");
                    } else {
                        System.out.println("Interactions du client " + nom + " " + prenom + " avec le numéro " + num + " :");
                        for (Interaction interaction : interactions) {
                            System.out.println("ID de l'interaction : " + interaction.getIdInteraction());
                            System.out.println("Type de l'interaction : " + interaction.getTypeInteraction());
                            
                            System.out.println("Description de l'interaction : " + interaction.getdescription());
                            System.out.println();
                        }
                    }
                    clientFound = true;
                    break; // Sortir de la boucle une fois le client trouvé
                }
            }
            
            // Si aucun client correspondant n'est trouvé
            if (!clientFound) {
                System.out.println("Aucun client trouvé avec le nom " + nom + ", le prénom " + prenom + " et le numéro " + num + ".");
            }
        }
    }
    public static List<Bien_Immobilier> rechercherBiens1(List<Bien_Immobilier> tabBien, Scanner scanner) {
        List<Bien_Immobilier> resultats = new ArrayList<>();

        // Demander à l'utilisateur les critères de recherche
        System.out.println("Recherche préférance de client :");
        System.out.print("Type de bien (laissez vide pour tous les types) : ");
        String typeRecherche = scanner.nextLine();
        System.out.print("Prix maximum (laissez vide pour ignorer) : ");
        double prixMaxRecherche = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer le retour à la ligne restant
        System.out.print("Superficie minimum (laissez vide pour ignorer) : ");
        double superficieMinRecherche = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer le retour à la ligne restant
        System.out.print("Type de interaction (location,achat...) (laissez vide pour tous les types) : ");
       
        // Parcourir tous les biens immobiliers pour les comparer avec les critères de recherche
        for (Bien_Immobilier bien : tabBien) {
            if ((typeRecherche.isEmpty() || bien.getType().equalsIgnoreCase(typeRecherche)) &&
                (prixMaxRecherche == 0 || bien.getPrix() <= prixMaxRecherche) &&
                (superficieMinRecherche == 0 || bien.getSuperficie() >= superficieMinRecherche)
                
               
                ) {
                // Le bien correspond aux critères de recherche, l'ajouter à la liste des résultats
                resultats.add(bien);
            }
        }

        return resultats;
    }
    
    
 // Méthode pour afficher les biens immobiliers
    public static void afficherBiens1(List<Bien_Immobilier> tabBien) {
    	if(tabBien.isEmpty()) {
    		System.out.println("votre liste est vide ! ");
    	}
    	 for (Bien_Immobilier bien : tabBien) {
             System.out.println("ID: " + bien.getId());
             System.out.println("Type: " + bien.getType());
             System.out.println("Superficie: " + bien.getSuperficie());
             System.out.println("Prix: " + bien.getPrix());
             System.out.println("Localisation: " + bien.getLocalisation());
             System.out.println("Paiement: " + bien.getPaiement());
             System.out.println("Nom de l'agent: " + bien.getNomAgent());
             System.out.println("Nombre d'étages: " + bien.getNbétages());
             System.out.println("Nombre de pièces: " + bien.getNbpièces());
             System.out.println("etat " + bien.getetat());
             System.out.println("Description: " + bien.getDescription());
             System.out.println("typedeinteraction: " + bien.gettypedeinteraction());
             System.out.println();
    	 }
    }
    
    public static void ajoutImmobilier1(List<Bien_Immobilier> tabBien, Scanner scanner) {
        Random random = new Random();


    System.out.println("Ajout d'un nouveau bien immobilier :");

    // Demander les informations pour chaque bien immobilier
    System.out.print("Type : ");
    String type = scanner.nextLine();

    System.out.print("Superficie : ");
    double superficie = scanner.nextDouble();
    scanner.nextLine(); // Pour consommer le retour à la ligne restant

    System.out.print("Prix : ");
    double prix = scanner.nextDouble();
    scanner.nextLine(); // Pour consommer le retour à la ligne restant

    System.out.print("Localisation : ");
    String localisation = scanner.nextLine();

    System.out.print("Paiement : ");
    String paiement = scanner.nextLine();

    System.out.print("Description : ");
    String description = scanner.nextLine();

    System.out.print("Nom de l'agent : ");
    String nomAgent = scanner.nextLine();
    
    System.out.print("Nombre d'étages : ");
    int nbEtages = scanner.nextInt();
    scanner.nextLine(); // Pour consommer le retour à la ligne restant

    System.out.print("Nombre de pièces : ");
    int nbPieces = scanner.nextInt();
    scanner.nextLine(); // Pour consommer le retour à la ligne restant

    System.out.print("etat : ");
    String etat = scanner.nextLine();
   
    System.out.print("inter : ");
    String typedeinteraction   = scanner.nextLine();
    
   
    // Générer un ID aléatoire
    int id = random.nextInt(1000);
    
    // Créer un nouvel objet Bient_Immobilier et l'ajouter à la liste
    Bien_Immobilier bien;
  if (type.equalsIgnoreCase("terrain")) {
	   bien = new Bien_Immobilier(id, type, superficie, prix, localisation, paiement, description, nomAgent, 0, 0,etat, typedeinteraction);   
    }
  else {
       bien = new Bien_Immobilier(id, type, superficie, prix, localisation, paiement, description, nomAgent, nbEtages, nbPieces,etat, typedeinteraction);
  } 
    tabBien.add(bien);
    System.out.println("id = "+bien.getId());

    } 

    public static void ajoutImmobilier(List<Bien_Immobilier> tabBien, Scanner scanner) {
        Random random = new Random();


    System.out.println("Ajout d'un nouveau bien immobilier :");

    // Demander les informations pour chaque bien immobilier
    System.out.print("Type : ");
    String type = scanner.nextLine();

    System.out.print("Superficie : ");
    double superficie = scanner.nextDouble();
    scanner.nextLine(); // Pour consommer le retour à la ligne restant

    System.out.print("Prix : ");
    double prix = scanner.nextDouble();
    scanner.nextLine(); // Pour consommer le retour à la ligne restant

    System.out.print("Localisation : ");
    String localisation = scanner.nextLine();

    System.out.print("Paiement : ");
    String paiement = scanner.nextLine();

    System.out.print("Description : ");
    String description = scanner.nextLine();

    System.out.print("Nom de l'agent : ");
    String nomAgent = scanner.nextLine();
    
    System.out.print("Nombre d'étages : ");
    int nbEtages = scanner.nextInt();
    scanner.nextLine(); // Pour consommer le retour à la ligne restant

    System.out.print("Nombre de pièces : ");
    int nbPieces = scanner.nextInt();
    scanner.nextLine(); // Pour consommer le retour à la ligne restant

    // Générer un ID aléatoire
    int id = random.nextInt(1000);
    
    // Créer un nouvel objet Bient_Immobilier et l'ajouter à la liste
    Bien_Immobilier bien;
  if (type.equalsIgnoreCase("terrain")) {
	   bien = new Bien_Immobilier(id, type, superficie, prix, localisation, paiement, description, nomAgent, 0, 0);   
    }
  else {
       bien = new Bien_Immobilier(id, type, superficie, prix, localisation, paiement, description, nomAgent, nbEtages, nbPieces);
  } 
    tabBien.add(bien);
    System.out.println("id = "+bien.getId());

    
}
       

// Méthode pour rechercher des biens immobiliers en fonction des critères spécifiés par l'utilisateur
public static List<Bien_Immobilier> rechercherBiens(List<Bien_Immobilier> tabBien, Scanner scanner) {
List<Bien_Immobilier> resultats = new ArrayList<>();

// Demander à l'utilisateur les critères de recherche
System.out.println("Recherche de biens immobiliers :");
System.out.print("Type de bien (laissez vide pour tous les types) : ");
String typeRecherche = scanner.nextLine();
System.out.print("Prix maximum (laissez vide pour ignorer) : ");
double prixMaxRecherche = scanner.nextDouble();
scanner.nextLine(); // Pour consommer le retour à la ligne restant
System.out.print("Superficie minimum (laissez vide pour ignorer) : ");
double superficieMinRecherche = scanner.nextDouble();
scanner.nextLine(); // Pour consommer le retour à la ligne restant

// Parcourir tous les biens immobiliers pour les comparer avec les critères de recherche
for (Bien_Immobilier bien : tabBien) {
    if ((typeRecherche.isEmpty() || bien.getType().equalsIgnoreCase(typeRecherche)) &&
        (prixMaxRecherche == 0 || bien.getPrix() <= prixMaxRecherche) &&
        (superficieMinRecherche == 0 || bien.getSuperficie() >= superficieMinRecherche)) {
        // Le bien correspond aux critères de recherche, l'ajouter à la liste des résultats
        resultats.add(bien);
    }
}

return resultats;
}


public static void modifierBien(List<Bien_Immobilier> tabBien , Scanner scanner) {

// Demander à l'utilisateur l'ID du bien immobilier à modifier
System.out.print("Entrez l'ID du bien immobilier à modifier : ");
int idRecherche = scanner.nextInt();
scanner.nextLine(); // Pour consommer le retour à la ligne restant

// Rechercher le bien immobilier avec l'ID spécifié
Bien_Immobilier bienTrouve = null;
for (Bien_Immobilier bien : tabBien) {
    if (bien.getId() == idRecherche) {
        bienTrouve = bien;
        break;
    }
}

// Vérifier si le bien immobilier a été trouvé
if (bienTrouve != null) {
    // Afficher les informations actuelles du bien immobilier
    System.out.println("Nouvelle informations du bien immobilier :");
    
    System.out.println("Nouveau type : ");
    String nouveauType = scanner.nextLine();
    bienTrouve.setType(nouveauType);
    
    System.out.println("Nouvelle superficie : ");
   double nouvelleSuperficie = scanner.nextDouble();
    bienTrouve.setSuperficie(nouvelleSuperficie);
    
    System.out.println("Nouveau prix : ");
    double nouveauPrix = scanner.nextDouble();
    bienTrouve.setPrix(nouveauPrix);
    
    System.out.println("Nouvelle localisation: ");
    String nouvelleLocalisation = scanner.nextLine();
    scanner.nextLine();
    bienTrouve.setLocalisation(nouvelleLocalisation);
     
    System.out.println("Nouvelle méthode de paiment : ");
    String nouveauPaiment = scanner.nextLine();
    bienTrouve.setPaiement(nouveauPaiment);
    
    System.out.println("Nouvelle description : ");
    String nouvelleDescription = scanner.nextLine();
    bienTrouve.setDescription(nouvelleDescription);
    
    System.out.println("Nouveau agent : ");
    String nouveauAgent = scanner.nextLine();
    bienTrouve.setNomAgent(nouveauAgent);
               
    System.out.println("Le bien immobilier a été modifié avec succès !");
} else {
    System.out.println("Aucun bien immobilier trouvé avec cet ID.");
    return;
}


}

// Méthode pour supprimer un bien immobilier en fonction de son ID
public static void supprimerBien(List<Bien_Immobilier> tabBien, int id) {
Iterator<Bien_Immobilier> iterator = tabBien.iterator();
while (iterator.hasNext()) {
    Bien_Immobilier bien = iterator.next();
    if (bien.getId() == id) {
        iterator.remove();
        System.out.println("Le bien immobilier avec l'ID " + id + " a été supprimé.");
        return;
    }
}
System.out.println("Aucun bien immobilier trouvé avec l'ID " + id + ".");
}


// Méthode pour affecter les biens immobiliers aux agents immobiliers
public static void affecterBiensAuxAgents(List<Bien_Immobilier> tabBien, List<Agent_Immobilier> tabAgent) {
for (Bien_Immobilier bien : tabBien) {
    for (Agent_Immobilier agent : tabAgent) {
        if (bien.getNomAgent().equals(agent.getNom())) {
            agent.ajouterBien(bien);
        }
    }
}
}

// Méthode pour afficher les biens immobiliers
public static void afficherBiens(List<Bien_Immobilier> tabBien) {
if(tabBien.isEmpty()) {
	System.out.println("votre liste est vide ! ");
}
 for (Bien_Immobilier bien : tabBien) {
     System.out.println("ID: " + bien.getId());
     System.out.println("Type: " + bien.getType());
     System.out.println("Superficie: " + bien.getSuperficie());
     System.out.println("Prix: " + bien.getPrix());
     System.out.println("Localisation: " + bien.getLocalisation());
     System.out.println("Paiement: " + bien.getPaiement());
     System.out.println("Nom de l'agent: " + bien.getNomAgent());
     System.out.println("Nombre d'étages: " + bien.getNbétages());
     System.out.println("Nombre de pièces: " + bien.getNbpièces());
     System.out.println("Description: " + bien.getDescription());
     System.out.println();
 }
}



// Méthode pour afficher les biens immobiliers
public static void ajouterAgentsImmobilier(List<Agent_Immobilier> listeAgents, Scanner scanner) {
       System.out.println("Ajout d'un nouvel agent immobilier :");
       System.out.print("Entrez le nom de l'agent immobilier : ");
       String nom = scanner.nextLine();
       System.out.print("Entrez le prénom de l'agent immobilier : ");
       String prenom = scanner.nextLine();
       System.out.print("Entrez l'expérience de l'agent immobilier (en années) : ");
       int experience = scanner.nextInt();
       scanner.nextLine(); // Pour consommer la fin de ligne après nextInt()
      
       // Création d'un nouvel agent immobilier avec les informations saisies
       Agent_Immobilier nouvelAgent = new Agent_Immobilier(nom, prenom, experience);
       
       // Ajout de l'agent immobilier à la liste
       listeAgents.add(nouvelAgent);
       
       System.out.println("Agent immobilier ajouté avec succès !");
   }





//Méthode pour afficher les agents immobiliers
   public static void afficherAgents(List<Agent_Immobilier> tabagent) {
   	if(tabagent.isEmpty()) {
   		System.out.println("votre liste est vide ! ");
   	}
   	 for (Agent_Immobilier agent : tabagent) {
            System.out.println("Nom: " + agent.getNom());
            System.out.println("Prenom: " + agent.getPrenom());
            System.out.println("années d'experiences: " + agent.getPeriodeExperience());
            agent.afficherBiensAgent();
   	 }
   }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


static int i = 0;
static int j;
public static List<TransactionV> creerTransactionVendeur(List<TransactionV> transactionVendeur, List<Client> clients, List<Bien_Immobilier> tabBien, Scanner scanner) {

String nomClient = "";
String prenomClient = "";
int ImmobileID = 0;
int numTelephone = 0;

boolean trouve = false;

System.out.println( "Entrez vos informations personnelles: " );
do{
System.out.println("Le nom: ");
nomClient = scanner.next();

System.out.println("Le prénom: ");
prenomClient = scanner.next();

System.out.println("Le numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());
i = 0;

do{
if ( !clients.get(i).getNom().equals(nomClient) || !clients.get(i).getPrenom().equals(prenomClient) || clients.get(i).getnum() != numTelephone ) {
i ++;
}else { trouve = true;  
j = i;}
}
while ( i < clients.size() && trouve == false );

if ( trouve == false ) { 
System.out.println( "Les données que vous avez saisies ne sont pas enregistrées" );
}
}
while ( trouve == false );


String type;
do {
System.out.println("Type de la transaction (Location ou Vente): ");
type = scanner.next();
}
while (!type.equals("Location") && !type.equals("Vente"));


trouve = false;
do {
System.out.println("ID de l'immobilier: ");
ImmobileID = Integer.parseInt(scanner.next());

i = 0;
do {
if ( tabBien.get(i).getId() != ImmobileID ) {
i ++;
}else { trouve = true; }
}
while ( i < tabBien.size() && trouve == false );
}
while ( trouve = false ); 



System.out.println("Prix de transaction: ");
Double prix = scanner.nextDouble();


System.out.println("Délai de transaction: ");
String dateDelai = scanner.next();


TransactionV tran =  new TransactionV ( nomClient, prenomClient, numTelephone, type, ImmobileID, prix, dateDelai );
clients.get(j).getTransactionV().add(tran);

System.out.println("La transaction de type " + type + " dans laquelle le client " + nomClient + " " + prenomClient + " à acheté à l'agence a été ajoutée avec succès.");


return clients.get(j).getTransactionV();

}








///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static List<TransactionA> creerTransactionAcheteur(List<TransactionA> transactionAcheteur, List<Client> clients, List<Bien_Immobilier> tabBien, Scanner scanner) {

String nomClient = "";
String prenomClient = "";
int ImmobileID = 0;
int numTelephone = 0;

boolean trouve = false;

System.out.println( "Entrez vos informations personnelles: " );
do{
System.out.println("Le nom: ");
nomClient = scanner.next();

System.out.println("Le prénom: ");
prenomClient = scanner.next();

System.out.println("Le numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());
i = 0;

do{
if ( !clients.get(i).getNom().equals(nomClient) || !clients.get(i).getPrenom().equals(prenomClient) || clients.get(i).getnum() != numTelephone ) {
i ++;
}else { trouve = true;  
j = i;}
}
while ( i < clients.size() && trouve == false );

if ( trouve == false ) { 
System.out.println( "Les données que vous avez saisies ne sont pas enregistrées" );
}
}
while ( trouve == false );


trouve = false;
do {
System.out.println("ID de l'immobilier: ");
ImmobileID = Integer.parseInt(scanner.next());

i = 0;
do {
if ( tabBien.get(i).getId() != ImmobileID ) {
i ++;
}else { trouve = true; }
}
while ( i < tabBien.size() && trouve == false );
}
while ( trouve = false ); 



System.out.println("Prix de transaction: ");
Double prix = scanner.nextDouble();



TransactionA tran =  new TransactionA ( nomClient, prenomClient, numTelephone, ImmobileID, prix );
clients.get(j).getTransactionA().add(tran);

System.out.println("La transaction dans laquelle le client " + nomClient + " " + prenomClient + " a vendu à l'agence a été ajoutée avec succès.");


return clients.get(j).getTransactionA();

}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static List<TransactionV> AjouterPaiementEchéance ( List<Client> clients, Scanner scanner) {


String nomClient = "";
String prenomClient = "";
int numTelephone = 0;

boolean trouve = false;
do {
System.out.println("Le nom: ");
nomClient = scanner.next();

System.out.println("Le prénom: ");
prenomClient = scanner.next();

System.out.println("Le numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());
i = 0;
do {
if ( !clients.get(i).getNom().equals(nomClient) || !clients.get(i).getPrenom().equals(prenomClient) || clients.get(i).getnum() != numTelephone ) {
i ++;
}else { trouve = true;  j = i;}
}
while ( i < clients.size() && trouve == false );
}
while ( trouve = false );

int reponse;
do {
System.out.println("Veuillez saisir le numéro de transaction: "); 
reponse = Integer.parseInt (scanner.next());
}
while ( reponse > clients.get(j).getTransactionV().size() );

reponse--;

System.out.println("Donner les nouvelles informations: ");
System.out.println("Paiement: ");
double paiement = scanner.nextDouble();

System.out.println("Date d'échéance: ");
String datePaiement = scanner.next();

Paiements newPai = new Paiements(paiement, datePaiement);

List<Paiements> oldList = clients.get(j).getTransactionV().get(reponse).getPaiements();
oldList.add(newPai);
clients.get(j).getTransactionV().get(reponse).setPaiements(oldList);


System.out.println("Le montant de paiement " + paiement + " et la date d'échéance " + datePaiement + " ont été enregistrés avec succès pour le clients acheteur " + nomClient + " " + prenomClient );


return clients.get(j).getTransactionV();
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void afficherTransactionVendeur( List<Client> clients, Scanner scanner) {


String nomClient = "";
String prenomClient = "";
int numTelephone = 0;

boolean trouve = false;
do {
System.out.println("Le nom: ");
nomClient = scanner.next();

System.out.println("Le prénom: ");
prenomClient = scanner.next();

System.out.println("Le numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());
i = 0;
do {
if ( !clients.get(i).getNom().equals(nomClient) || !clients.get(i).getPrenom().equals(prenomClient) || clients.get(i).getnum() != numTelephone ) {
i ++;
}else { trouve = true;  j = i;}
}
while ( i < clients.size() && trouve == false );
}
while( trouve = false );

for( i=0; i<clients.get(j).getTransactionV().size(); i++){
clients.get(j).getTransactionV().get(i).afficherVendeur(i);
System.out.println("**************************");
} 

}











///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void afficherTransactionAcheteur( List<Client> clients, Scanner scanner) {


String nomClient = "";
String prenomClient = "";
int numTelephone = 0;

boolean trouve = false;
do {
System.out.println("Le nom: ");
nomClient = scanner.next();

System.out.println("Le prénom: ");
prenomClient = scanner.next();

System.out.println("Le numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());
i = 0;
do {
if ( !clients.get(i).getNom().equals(nomClient) || !clients.get(i).getPrenom().equals(prenomClient) || clients.get(i).getnum() != numTelephone ) {
i ++;
}else { trouve = true;  j = i;}
}
while ( i < clients.size() && trouve == false );

}
while( trouve = false );




for( i=0; i<clients.get(j).getTransactionA().size(); i++){
clients.get(j).getTransactionA().get(i).afficherAcheteur(i);
System.out.println("**************************");

} 


}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static  List<TransactionV> modifierTransactionVendeur ( List<Client> clients, List<Bien_Immobilier> tabBien, Scanner scanner ) {


String nomClient = "";
String prenomClient = "";
int ImmobileID = 0;
int numTelephone = 0;

boolean trouve = false;
do {
System.out.println("Veillez saisir vos encients informations: ");
System.out.println("Le nom: ");
nomClient = scanner.next();

System.out.println("Le prénom: ");
prenomClient = scanner.next();

System.out.println("Le numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());

for ( i=0; i<clients.size(); i++ ) {
if ( clients.get(i).getNom().equals(nomClient) && clients.get(i).getPrenom().equals(prenomClient) && numTelephone == clients.get(i).getnum() ) {
System.out.println("Veillez saisir vos nouvelles informations: ");
System.out.println("Nouveau nom: ");
nomClient = scanner.next();

System.out.println("Nouveau prénom: ");
prenomClient = scanner.next();

System.out.println("Nouveau numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());

clients.get(i).setNom(nomClient);
clients.get(i).setPrenom(prenomClient);
clients.get(i).setnum(numTelephone);

trouve = true;
j = i;
i = clients.size();

}
}
if ( trouve == false ) {
System.out.println("Vos informations saisies ne sont pas enregistrées");					
}
}
while ( trouve == false );


int reponse;
do {
System.out.println("Veuillez saisir le numéro de transaction que vous voulez modifier: "); 
reponse = Integer.parseInt (scanner.next());
}
while ( reponse > clients.get(j).getTransactionV().size() );
reponse--;



String type;
do {
System.out.println("Nouveau type (Location ou Vente): ");
type = scanner.next();
}
while (!type.equals("Location") && !type.equals("Vente"));




trouve = false;
do {
System.out.println("ID de l'immobilier: ");
ImmobileID = Integer.parseInt(scanner.next());

i = 0;
do {
if ( tabBien.get(i).getId() != ImmobileID ) {
i ++;
}else { trouve = true; }
}while ( i < tabBien.size() && trouve == false );			
}while ( trouve = false );


System.out.println("Nouveau prix de transaction: ");
Double prix = scanner.nextDouble();


System.out.println("Nouveau délai de transaction: ");
String dateDelai = scanner.next();


TransactionV newtran =  new TransactionV (nomClient, prenomClient, numTelephone, type, ImmobileID, prix, dateDelai);
List<Paiements> oldList = clients.get(j).getTransactionV().get(reponse).getPaiements();

clients.get(j).getTransactionV().remove(reponse);
clients.get(j).getTransactionV().add(reponse, newtran);
clients.get(j).getTransactionV().get(reponse).setPaiements(oldList);


return clients.get(j).getTransactionV();


}








///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static  List<TransactionA> modifierTransactionAcheteur ( List<Client> clients, List<Bien_Immobilier> tabBien, Scanner scanner) {


String nomClient = "";
String prenomClient = "";
int ImmobileID = 0;
int numTelephone = 0;

boolean trouve = false;
do {
System.out.println("Veillez saisir vos encients informations: ");
System.out.println("Le nom: ");
nomClient = scanner.next();

System.out.println("Le prénom: ");
prenomClient = scanner.next();

System.out.println("Le numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());

for ( i=0; i<clients.size(); i++ ) {
if ( clients.get(i).getNom().equals(nomClient) && clients.get(i).getPrenom().equals(prenomClient) && numTelephone == clients.get(i).getnum() ) {
System.out.println("Veillez saisir vos nouvelles informations: ");
System.out.println("Nouveau nom: ");
nomClient = scanner.next();

System.out.println("Nouveau prénom: ");
prenomClient = scanner.next();

System.out.println("Nouveau numéro de téléphone: ");
numTelephone = Integer.parseInt(scanner.next());

clients.get(i).setNom(nomClient);
clients.get(i).setPrenom(prenomClient);
clients.get(i).setnum(numTelephone);

trouve = true;
j = i;
i = clients.size();

}

}
if ( trouve == false ) {
System.out.println("Vos informations saisies ne sont pas enregistrées");					
}
}
while ( trouve == false );



int reponse;
do {
System.out.println("Veuillez saisir le numéro de transaction que vous voulez modifier: "); 
reponse = Integer.parseInt (scanner.next());
}
while ( reponse > clients.get(j).getTransactionA().size() );
reponse--;




trouve = false;
do {
System.out.println("ID de l'immobilier: ");
ImmobileID = Integer.parseInt(scanner.next());

i = 0;
do {
if ( tabBien.get(i).getId() != ImmobileID ) {
i ++;
}else { trouve = true; }
}while ( i < tabBien.size() && trouve == false );	
}while ( trouve = false );



System.out.println("Nouveau prix de transaction: ");
Double prix = scanner.nextDouble();




TransactionA newtran =  new TransactionA (nomClient, prenomClient, numTelephone, ImmobileID, prix);
clients.get(j).getTransactionA().add(reponse, newtran);


return clients.get(j).getTransactionA();


}
private static final Scanner scanner = new Scanner(System.in);
private static List<RendezVous> rendezVousList = new ArrayList<>();
private static void ajouterRendezVous() {
    System.out.println("**Ajout d'un rendez-vous**");
    System.out.println("-------------------------");

    System.out.print("Nom du client : ");
    String nomClient = scanner.next();
    
    System.out.print("prenom du client : ");
    String prenomClient = scanner.next();

    System.out.print("Date du rendez-vous (AAAA-MM-JJ) : ");
    LocalDate dateRdv = LocalDate.parse(scanner.next());

    System.out.print("Heure du rendez-vous (HH:MM) : ");
    LocalTime heureRdv = LocalTime.parse(scanner.next());

    System.out.print("Adresse du bien : ");
    String adresseBien = scanner.next();
    
    System.out.print("numero telephone du client : ");
    int numTelephone = scanner.nextInt();
    

    RendezVous rendezVous = new RendezVous(nomClient,prenomClient, dateRdv, heureRdv, adresseBien,numTelephone);
    rendezVousList.add(rendezVous);
    
    System.out.println(" _________________________________ ");
    System.out.println("|                                 | ");
    System.out.println("|Rendez-vous ajouté avec succès ! | ");
    System.out.println("|_________________________________|");
    System.out.println("                                   ");
    
    
    
}


private static void afficherTousLesRendezVous() {
    System.out.println("**Liste des rendez-vous**");
    System.out.println("-------------------------");

    if (rendezVousList.isEmpty()) {
        System.out.println("Aucun rendez-vous n'a été enregistré.");
    } else {
        for (RendezVous rendezVous : rendezVousList) {
            System.out.println("-------------------------");
            System.out.println("Nom du client : " + rendezVous.getNomClient());
            System.out.println("Prenom du client : " + rendezVous.getPrenomClient());
            System.out.println("Date : " + rendezVous.getDateRdv());
            System.out.println("Heure : " + rendezVous.getHeureRdv());
            System.out.println("Adresse du bien : " + rendezVous.getAdresseBien());
            System.out.println("numero de telephone du client : " + rendezVous.getNumTelephone());
        }
    }
}
private static void afficheParNomPrenomNum() {
    System.out.println("**donner les informations du client que vous souhaitez afficher ces rendez-vous**");
    System.out.println("---------------------------------");

    System.out.print("Nom du client : ");
    String nomClient = scanner.next();
    
    System.out.print("Prénom du client : ");
    String prenomClient = scanner.next();
    
    System.out.print("Numéro téléphone du client : ");
    int numTelephone = scanner.nextInt();

    List<RendezVous> rendezVousParNom = new ArrayList<>();
    for (RendezVous rvpn : rendezVousList) {
        if (rvpn.getNomClient().equalsIgnoreCase(nomClient)
        		&& rvpn.getPrenomClient().equalsIgnoreCase(prenomClient) 
        		&& rvpn.getNumTelephone()==numTelephone) {
            rendezVousParNom.add(rvpn);
        }
    }

    if (rendezVousParNom.isEmpty()) {
        System.out.println("Aucun rendez-vous n'a été trouvé pour ce nom et ce prenom et ce telephone.");
    } else {
        for (RendezVous rvpn : rendezVousParNom) {
            System.out.println("-------------------------");
            System.out.println("Nom du client : " + rvpn.getNomClient());
            System.out.println("Prenom du client : " + rvpn.getPrenomClient());
            System.out.println("Date : " + rvpn.getDateRdv());
            System.out.println("Heure : " + rvpn.getHeureRdv());
            System.out.println("Adresse du bien : " + rvpn.getAdresseBien());
            System.out.println("numero de telephone du client : " + rvpn.getNumTelephone());
        }
     }
    }
private static void modifierRendezVous() {
    System.out.println("**Modification d'un rendez-vous**");
    System.out.println("-------------------------");

    if (rendezVousList.isEmpty()) {
        System.out.println("Aucun rendez-vous n'a été enregistré.");
        return;
    }


    System.out.print("nom du client a modifier: ");
    String nomClient = scanner.next();
    
    System.out.print(" prénom du client a modifier : ");
    String prenomClient = scanner.next();

    System.out.print("numéro de téléphone du client a modifier: ");
    int numTelephone = scanner.nextInt();
    
    
    for (RendezVous rvam : rendezVousList) {
        if (rvam.getNomClient().equalsIgnoreCase(nomClient)
        		&& rvam.getPrenomClient().equalsIgnoreCase(prenomClient) 
        		&& rvam.getNumTelephone()==numTelephone) {

            System.out.print("Nouvelle date du rendez-vous (AAAA-MM-JJ) : ");
            LocalDate nouvelleDateRdv = LocalDate.parse(scanner.next());
            rvam.setDateRdv(nouvelleDateRdv);

            System.out.print("Nouvelle heure du rendez-vous (HH:MM) : ");
            LocalTime nouvelleHeureRdv = LocalTime.parse(scanner.next());
            rvam.setHeureRdv(nouvelleHeureRdv);

            System.out.print("Nouvelle adresse du bien : ");
            String nouvelleAdresseBien = scanner.next();
            rvam.setAdresseBien(nouvelleAdresseBien);
            
            System.out.println(" _________________________________ ");
            System.out.println("|                                 | ");
            System.out.println("|Rendez-vous modifié avec succès ! | ");
            System.out.println("|_________________________________|");
            System.out.println("                                   ");
            
            
            
            
        }
        else {
        	 System.out.println("Aucun rendez-vous n'a été trouvé pour ce nom et ce prenom et ce telephone.");
        }
    }
    
    }

    private static void supprimerRendezVous() {
    System.out.println("**Suppression d'un rendez-vous**");
    System.out.println("-------------------------");

    if (rendezVousList.isEmpty()) {
    System.out.println("Aucun rendez-vous n'a été enregistré.");
    return;
    }

    System.out.print("Numéro du rendez-vous à supprimer (1-" + rendezVousList.size() + ") : ");
    int numRdv = scanner.nextInt();
    scanner.nextLine(); 

    rendezVousList.remove(numRdv - 1);

    System.out.println("Rendez-vous supprimé avec succès !");
    }
    private static void supprimeParNomPrenomNum() {
        System.out.println("**le nom du client que vous souhaitez supprimer ces rendez-vous**");
        System.out.println("---------------------------------------------");

        System.out.print("Nom du client : ");
        String nomClient = scanner.next();
        System.out.print("Prenom du client : ");
        String prenomClient = scanner.next();
        System.out.print("Numero telephone du client : ");
        int numTelephone = scanner.nextInt();

        int nombreSupprimes = 0;
        for (int i = rendezVousList.size() - 1; i >= 0; i--) {
            RendezVous rendezVous = rendezVousList.get(i);
            if (rendezVous.getNomClient().equalsIgnoreCase(nomClient)
            		&& rendezVous.getPrenomClient().equalsIgnoreCase(prenomClient) 
            		&& rendezVous.getNumTelephone()==numTelephone) {
                rendezVousList.remove(i);
                nombreSupprimes++;
            }
        }

        if (nombreSupprimes == 0) {
            System.out.println("Aucun rendez-vous n'a été trouvé pour ce nom.");
        } else {
            System.out.println(nombreSupprimes + " rendez-vous ont été supprimés pour ce nom et ce prenom et ce telephone.");
        }}

    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Client> clients = new ArrayList<>();
        List<Bien_Immobilier> tabBien = new ArrayList<>();
        List<Agent_Immobilier> tabAgent = new ArrayList<>();
        List<TransactionV> transactionVendeur = new ArrayList<>();
        List<TransactionA> transactionAcheteur = new ArrayList<>();
        
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1- Gestion des clients");
            System.out.println("2- Gestion des biens immobiliers");
            System.out.println("3- Gestion des transactions");
            System.out.println("4- Gestion des rendez-vous");
            System.out.println("5- Quitter l'application");
            System.out.println("---------------------------------");
            System.out.print("Votre choix : ");
            
            int mainChoice = Integer.parseInt(scanner.nextLine());

            switch (mainChoice) {
                case 1:
                    manageClients(scanner, clients);
                    break;
                case 2:
                    manageImmobilier(scanner, tabBien, tabAgent);
                    break;
                case 3:
                    manageTransactions(scanner, clients, tabBien, transactionVendeur, transactionAcheteur);
                    break;
                case 4:
                    manageAppointments(scanner);
                    break;
                case 5:
                    System.out.println("Merci d'avoir utilisé notre application. Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private static void manageClients(Scanner scanner, List<Client> clients) {
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Supprimer un client");
            System.out.println("3. Modifier un client");
            System.out.println("4. Afficher historique interactions des clients");
            System.out.println("5. Ajouter interaction pour un client précis");
            System.out.println("6. Afficher les informations des clients");
            System.out.println("7. Retourner au menu principal");
            System.out.println("---------------------------------");
            System.out.print("Votre choix : ");
            
            int clientChoice = Integer.parseInt(scanner.nextLine());

            switch (clientChoice) {
                case 1:
                    addClient(clients, scanner);
                    break;
                case 2:
                    removeClient(clients, scanner);
                    break;
                case 3:
                    editClient(clients, scanner);
                    break;
                case 4:
                    displayInteractions(clients, scanner);
                    break;
                case 5:
                    addInteractionToClient(clients, scanner);
                    break;
                case 6:
                    displayClients(clients);
                    break;
                case 7:
                    return; // Retourner au menu principal
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private static void manageImmobilier(Scanner scanner, List<Bien_Immobilier> tabBien, List<Agent_Immobilier> tabAgent) {
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1. Ajouter un bien immobilier");
            System.out.println("2. Modifier un bien immobilier");
            System.out.println("3. Rechercher des biens immobiliers");
            System.out.println("4. Supprimer des biens immobiliers");
            System.out.println("5. Ajouter un agent immobilier");
            System.out.println("6. Affecter des biens à des agents");
            System.out.println("7. Afficher les biens immobiliers");
            System.out.println("8. Afficher les agents immobiliers");
            System.out.println("9. Retourner au menu principal");
            System.out.println("---------------------------------");
            System.out.print("Votre choix : ");
            
            int immobilierChoice = Integer.parseInt(scanner.nextLine());

            switch (immobilierChoice) {
                case 1:
                    do {
                        ajoutImmobilier1(tabBien, scanner);
                        System.out.print("Voulez-vous ajouter un autre bien immobilier ? (oui/non) : ");
                    } while (scanner.nextLine().equalsIgnoreCase("oui"));
                    break;
                case 2:
                    modifierBien(tabBien, scanner);
                    break;
                case 3:
                    List<Bien_Immobilier> resultatsRecherchebien = rechercherBiens(tabBien, scanner);
                    System.out.println("Résultat de recherche :");
                    afficherBiens(resultatsRecherchebien);
                    break;
                case 4:
                    System.out.print("Entrez l'ID du bien immobilier à supprimer : ");
                    int idSuppression = scanner.nextInt();
                    supprimerBien(tabBien, idSuppression);
                    System.out.println("Élément supprimé");
                    break;
                case 5:
                    do {
                        ajouterAgentsImmobilier(tabAgent, scanner);
                        System.out.print("Voulez-vous ajouter un autre agent immobilier ? (oui/non) : ");
                    } while (scanner.nextLine().equalsIgnoreCase("oui"));
                    break;
                case 6:
                    affecterBiensAuxAgents(tabBien, tabAgent);
                    for (Agent_Immobilier agent : tabAgent) {
                        System.out.println(agent);
                    }
                    break;
                case 7:
                    afficherBiens(tabBien);
                    break;
                case 8:
                    afficherAgents(tabAgent);
                    break;
                case 9:
                    return; // Retourner au menu principal
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private static void manageTransactions(Scanner scanner, List<Client> clients, List<Bien_Immobilier> tabBien, List<TransactionV> transactionVendeur, List<TransactionA> transactionAcheteur) {
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1. Créer une transaction où l'agence est le vendeur");
            System.out.println("2. Créer une transaction où l'agence est l'acheteur");
            System.out.println("3. Ajouter un paiement & échéance");
            System.out.println("4. Afficher la liste des transactions où l'agence est le vendeur");
            System.out.println("5. Afficher la liste des transactions où l'agence est l'acheteur");
            System.out.println("6. Modifier une transaction où l'agence est le vendeur");
            System.out.println("7. Modifier une transaction où l'agence est l'acheteur");
            System.out.println("8. Retourner au menu principal");
            System.out.println("---------------------------------");
            System.out.print("Votre choix : ");
            
            int transactionChoice = Integer.parseInt(scanner.nextLine());

            switch (transactionChoice) {
                case 1:
                    transactionVendeur = creerTransactionVendeur(transactionVendeur, clients, tabBien, scanner);
                    break;
                case 2:
                    transactionAcheteur = creerTransactionAcheteur(transactionAcheteur, clients, tabBien, scanner);
                    break;
                case 3:
                    transactionVendeur = AjouterPaiementEchéance(clients, scanner);
                    break;
                case 4:
                    afficherTransactionVendeur(clients, scanner);
                    break;
                case 5:
                    afficherTransactionAcheteur(clients, scanner);
                    break;
                case 6:
                    transactionVendeur = modifierTransactionVendeur(clients, tabBien, scanner);
                    break;
                case 7:
                    transactionAcheteur = modifierTransactionAcheteur(clients, tabBien, scanner);
                    break;
                case 8:
                    return; // Retourner au menu principal
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private static void manageAppointments(Scanner scanner) {
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1. Ajouter un rendez-vous");
            System.out.println("2. Afficher tous les rendez-vous");
            System.out.println("3. Afficher un rendez-vous par nom, prénom et numéro de téléphone");
            System.out.println("4. Modifier un rendez-vous");
            System.out.println("5. Supprimer un rendez-vous");
            System.out.println("6. Supprimer un rendez-vous par nom, prénom et numéro de téléphone");
            System.out.println("7. Retourner au menu principal");
            System.out.println("---------------------------------");
            System.out.print("Votre choix : ");
            
            int appointmentChoice = Integer.parseInt(scanner.nextLine());

            switch (appointmentChoice) {
                case 1:
                    ajouterRendezVous();
                    break;
                case 2:
                    afficherTousLesRendezVous();
                    break;
                case 3:
                    afficheParNomPrenomNum();
                    break;
                case 4:
                    modifierRendezVous();
                    break;
                case 5:
                    supprimerRendezVous();
                    break;
                case 6:
                    supprimeParNomPrenomNum();
                    break;
                case 7:
                    return; // Retourner au menu principal
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }}

