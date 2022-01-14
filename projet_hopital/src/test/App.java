package test;

import java.util.LinkedList;
import java.util.Scanner;

import dao.DAOCompte;
import dao.DAOPatient;
import dao.DAOVisite;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;


public class App { 

	static Compte connected = null;
	static LinkedList<Patient> fileAttente = new LinkedList();
	static DAOCompte daoC = new DAOCompte();
	static DAOPatient daoP = new DAOPatient();
	static DAOVisite daoV = new DAOVisite();


	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}



	// La connexion

	public static void menuUtilisateur() {

		System.out.println("Menu utilisateur");
		System.out.println("1 - Se connecter Medecin");
		System.out.println("2 - Se conncter Secretaire");
		System.out.println("3 - Fermer l'appli");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : connexion();break;
		case 3 : System.exit(0);break;
		}
		menuUtilisateur();
	}
	
	public static void connexion() {

		System.out.println("Connexion");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected= daoC.seConnecter(login, password);

		if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Choisir une salle (1/2)");
			if (salle==1 ||salle==2) {
			//int salle = saisieInt("Salle 1 ou 2 ?");
				((Medecin) connected).setSalle(salle);
				menuMedecin();
			}
		}
		else if(connected instanceof Secretaire) {menuSecretaire();}
		else if(connected ==null) 
		{
			System.out.println("Identifiants invalides !");
		}
		menuUtilisateur();
	}


	// Les operations de la secretaire

	public static void menuSecretaire() {

		System.out.println("Menu secretaire");
		System.out.println("1 - Ajouter un patient ï¿½ file d'attente");
		System.out.println("2 - Afficher la file d'attente");
		System.out.println("3 - Partir en pause");
		System.out.println("4 - Partir en pause");
		System.out.println("5 -Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : ajouterPatient();break;
		case 2 : showAllFile();break;
		case 3 : partirEnPause();break;
		case 4 : break;
		case 5 : connected=null; menuUtilisateur();break;
		}
		menuSecretaire();
	}


	public static void partirEnPause() {
		//Partir en pause = Serialize fileAttente dans fileAttente.txt
		//fileAttente.clear();
		
	}

	

	
	public static void ajouterPatient() {

		int id = saisieInt("Saisir un identifiant");
		Patient p = daoP.findById(id);	
		
		if (p==null) {
			System.out.println("Id inconnu");
			System.out.println("Veuillez vous enregistrer");
			String nom = saisieString("Saisir nom");
			String prenom = saisieString("Saisir prenom");
			 p= new Patient(nom,prenom);
			daoP.insert(p);
		}
		
		fileAttente.add(p);

	}
	
	

	
	public static void showAllFile() {
		for(Patient p : fileAttente)
		{
			System.out.println(p);
		}
	}


	
	
	public static void menuMedecin() {

		System.out.println("Menu Medecin");
		System.out.println("Choisir un menu");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - Afficher la file d'attente");
		System.out.println("3 - Sauvegarder mes visites");
		System.out.println("4 - Se déconnecter");
		
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : recevoirPatient();break; //update list <attente>(visite)  dans l'ordre de visite et affiche nouveau patient
		case 2 : showAllFile();break; //affiche list  <attente>(visite) , précision concernant le prochain patient
		case 3 : insertVisite();break;
		case 4 : connected=null;menuUtilisateur();break;
			}

		menuMedecin();

	}

	public static void insertVisite() {
		//insert daoV les visites du medecin connecté
	}

	
	
	public static void  recevoirPatient() {
		//Recup le 1er patient de la fileAttene;
		//New Visite();
		//add visite dans le medecin
		//Si +10 visites insertVisite(); => visites.clear();
		
	}


	
	public static void main(String[] args) { 	
		
		menuUtilisateur();
	} 
}
