package projet_poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionRendezVous {

    private static final Scanner scanner = new Scanner(System.in);

    private List<RendezVous> rendezVousList = new ArrayList<>();

    public void lancerApplication() {
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); 
            switch (choix) {
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
                    quitterApplication();
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 7);
    }

    private void afficherMenu() {
        System.out.println("**Gestion des rendez-vous pour les visites de biens immobiliers**");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Ajouter un rendez-vous");
        System.out.println("2. Afficher tous les rendez-vous");
        System.out.println("3. Afficher un rendez-vous par un nom");
        System.out.println("4. Modifier un rendez-vous");
        System.out.println("5. Supprimer un rendez-vous");
        System.out.println("6. supprimer un rendez-vous par un nom");
        System.out.println("7. Quitter l'application");
        System.out.println("----------------------------------------------------------");
        System.out.print("Votre choix : ");
        
        
    }

    private void ajouterRendezVous() {
        System.out.println("**Ajout d'un rendez-vous**");
        System.out.println("-------------------------");

        System.out.print("Nom du client : ");
        String nomClient = scanner.nextLine();
        
        System.out.print("prenom du client : ");
        String prenomClient = scanner.nextLine();

        System.out.print("Date du rendez-vous (AAAA-MM-JJ) : ");
        LocalDate dateRdv = LocalDate.parse(scanner.nextLine());

        System.out.print("Heure du rendez-vous (HH:MM) : ");
        LocalTime heureRdv = LocalTime.parse(scanner.nextLine());

        System.out.print("Adresse du bien : ");
        String adresseBien = scanner.nextLine();
        
        System.out.print("numero telephone du client : ");
        int numTelephone = scanner.nextInt();
        

        RendezVous rendezVous = new RendezVous(nomClient,prenomClient, dateRdv, heureRdv, adresseBien,numTelephone);
        rendezVousList.add(rendezVous);

        System.out.println("Rendez-vous ajouté avec succès !");
        
        
    }
    

    private void afficherTousLesRendezVous() {
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
    private void afficheParNomPrenomNum() {
        System.out.println("**le nom du client que vous souhaitez afficher ces rendez-vous**");
        System.out.println("---------------------------------");

        System.out.print("Nom du client : ");
        String nomClient = scanner.nextLine();
        
        System.out.print("Prenom du client : ");
        String prenomClient = scanner.nextLine();
        
        System.out.print("Numero telephone du client : ");
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

    private void modifierRendezVous() {
        System.out.println("**Modification d'un rendez-vous**");
        System.out.println("-------------------------");

        if (rendezVousList.isEmpty()) {
            System.out.println("Aucun rendez-vous n'a été enregistré.");
            return;
        }

        System.out.print("Numéro du rendez-vous à modifier (1-" + rendezVousList.size() + ") : ");
        int numRdv = scanner.nextInt();
        scanner.nextLine(); 

        RendezVous rendezVousAModifier = rendezVousList.get(numRdv - 1);
        System.out.print("Nouveau nom du client : ");
        String nouveauNomClient = scanner.nextLine();
        
        System.out.print("Nouveau prenom du client : ");
        String nouveauPrenomClient = scanner.nextLine();
        
        System.out.print("Nouvelle date du rendez-vous (AAAA-MM-JJ) : ");
        LocalDate nouvelleDateRdv = LocalDate.parse(scanner.nextLine());

        System.out.print("Nouvelle heure du rendez-vous (HH:MM) : ");
        LocalTime nouvelleHeureRdv = LocalTime.parse(scanner.nextLine());

        System.out.print("Nouvelle adresse du bien : ");
        String nouvelleAdresseBien = scanner.nextLine();
        
        System.out.print("Nouveau numero de telephone : ");
        int nouveauNumTelephone = scanner.nextInt();

        rendezVousAModifier.setNomClient(nouveauNomClient);
        rendezVousAModifier.setPrenomClient(nouveauPrenomClient);
        rendezVousAModifier.setDateRdv(nouvelleDateRdv);
        rendezVousAModifier.setHeureRdv(nouvelleHeureRdv);
        rendezVousAModifier.setAdresseBien(nouvelleAdresseBien);
        rendezVousAModifier.setNumTelephone(nouveauNumTelephone);

        System.out.println("Rendez-vous modifié avec succès !");
        }

        private void supprimerRendezVous() {
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
        private void supprimeParNomPrenomNum() {
            System.out.println("**le nom du client que vous souhaitez supprimer ces rendez-vous**");
            System.out.println("---------------------------------------------");

            System.out.print("Nom du client : ");
            String nomClient = scanner.nextLine();
            System.out.print("Prenom du client : ");
            String prenomClient = scanner.nextLine();
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
            }
        }

        private void quitterApplication() {
        System.out.println("**Au revoir !**");
        }

        }
