package projet_poo;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class MainTransaction {
			
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
		
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		  public static void main(String[] args) {
		      
			  Scanner scanner = new Scanner(System.in);
			  List<TransactionV> transactionVendeur = new ArrayList<>();
			  List<TransactionA> transactionAcheteur = new ArrayList<>();
		      List<Client> clients = new ArrayList<>();
		      List<Bien_Immobilier> tabBien = new ArrayList<>();

	         
	          
		      while (true) {
		    	  System.out.println("Choisir une option :");
			      System.out.println("1. Créer une transaction ou l'agence est le vendeur");
			      System.out.println("2. Créer une transaction ou l'agence est l'acheteur");
			      System.out.println("3. Ajouter un paiement & échéance");
			      System.out.println("4. Afficher la liste des transactions ou l'agence est le vendeur");
			      System.out.println("5. Afficher la liste des transactions ou l'agence est l'acheteur");
			      System.out.println("6. Modifier une transaction ou l'agence est le vendeur");
			      System.out.println("7. Modifier une transaction ou l'agence est l'acheteur");
			      System.out.println("8. Exit");
			      System.out.println("Votre choix: ");
			          
		          int choix = Integer.parseInt(scanner.next());

			         
			          switch (choix) {
			          case 1:
			        	  transactionVendeur = creerTransactionVendeur( transactionVendeur, clients, tabBien, scanner );
		                    break;
		                    
		                    
			          case 2:
			        	  transactionAcheteur = creerTransactionAcheteur( transactionAcheteur, clients, tabBien, scanner );
			        	  	 break;
			        	  	 
			        	  	 
			          case 3:
			        	  transactionVendeur = AjouterPaiementEchéance ( clients, scanner );
			                  break;
			                  
			                  
			          case 4:
			        	  afficherTransactionVendeur( clients, scanner );
			                  break;
			                 
			                  
			          case 5:
			        	  afficherTransactionAcheteur( clients, scanner );
			        	      break;
			        	      
			        	      
			          case 6:
			        	  transactionVendeur = modifierTransactionVendeur ( clients, tabBien, scanner );                
			        	  break;
			        	  
			        	  
			          case 7:
			        	  transactionAcheteur = modifierTransactionAcheteur ( clients, tabBien, scanner );                
			        	  break;
			        
			                  
		              case 8:
		            	  System.out.println("Quitter le programme. Au revoir!");
		                  System.exit(0);
		            	  break;
			                  
			              default:
			                  System.out.println("Choix invalide! Veuillez choisir un chiffre entre 1 et 8.");
			          }
		      }
		      

		  }

	}








