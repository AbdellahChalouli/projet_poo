package projet_poo;


import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;
public class main_Immobilier {
	// Méthode pour ajouter des biens immobiliers :
	
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

	    public static void main(String[] args) {
	    	 // Création d'une liste de biens immobiliers et une liste d'agents immobiliers
	        List<Bien_Immobilier> tabBien = new ArrayList<>();
	        List<Agent_Immobilier> tabAgent = new ArrayList<>();

	        Scanner scanner = new Scanner(System.in);
	        int choix;

	        do {
	            System.out.println("Menu :");
	            System.out.println("1. Ajouter un bien immobilier");
	            System.out.println("2. Modifier un bien immobilier");
	            System.out.println("3. Rechercher des biens immobiliers");
	            System.out.println("4. Supprimer des biens immobiliers");
	            System.out.println("5. Affecter des biens à des agents");
	            System.out.println("6. Afficher les biens immobiliers");
	            System.out.println("7. Quitter le programme");
	            System.out.print("Votre choix : ");
	            choix = scanner.nextInt();
	            scanner.nextLine(); // Pour consommer le retour à la ligne restant

	            switch (choix) {
	                case 1:
	                	do {
	                        ajoutImmobilier(tabBien, scanner);
	                     
	                        System.out.print("Voulez-vous ajouter un autre bien immobilier ? (oui/non) : ");
	                    } while (scanner.nextLine().equalsIgnoreCase("oui"));
	                    break;
	                case 2:
	                    modifierBien(tabBien, scanner);
	                    break;
	                case 3:
	                    List<Bien_Immobilier> resultatsRecherche = rechercherBiens(tabBien, scanner);
	                    System.out.println("resultat de recherche :");
	                    afficherBiens(resultatsRecherche);
	                    break;
	                case 4:
	                    System.out.print("Entrez l'ID du bien immobilier à supprimer : ");
	                    int idSuppression = scanner.nextInt();
	                    supprimerBien(tabBien, idSuppression);
	                    System.out.println("élément supprimer ");
	                    break;
	                case 5:
	                    affecterBiensAuxAgents(tabBien, tabAgent);
	                    for(Agent_Immobilier agent :tabAgent) {
	                       System.out.println(agent);
	                    }
	                    break;
	                case 6:
	                    afficherBiens(tabBien);
	                    break;
	                case 7:
	                    System.out.println("Programme terminé.");
	                    break;
	                default:
	                    System.out.println("Choix invalide.");
	            }
	        } while (choix != 7);

	        scanner.close();
	    }

	    }
