package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompte;
import dao.DAOPatient;
import dao.DAOVisite;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;


public class Test { 

	static Compte connected = null;
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
			//int salle = saisieInt("Salle 1 ou 2 ?");
			//((Medecin) connected).setSalle(salle);
			menuMedecin();
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
		System.out.println("1 - Ajouter un patient � file d'attente");
		System.out.println("2 - Afficher la file d'attente");
		System.out.println("3 - Partir en pause");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : creationFile();break;
		case 2 : showAllFile();break;
		case 3 : System.exit(0);break;
		}
		menuSecretaire();
	}


	//Ajout des patients dans la file d'attente

	public static void fileAttentePatients() {

		int id = saisieInt("Saisir un identifiant");
		daoP.findById();	
		
		if (isId is true) {

		}
		else if (id is false) {
			System.out.println("Id inconnu");
			System.out.println("Veuillez vous enregistrer");
			addPatient();

		}

	}
	
	

	// Pour le menu 2 de la secretaire

	public static void showAllFile() {
		for(Patient p : daoP.findAll())
		{
			System.out.println(p);
		}
	}


	// Pour ajouter un patient

	public static void addPatient() {	

		String nom = saisieString("Saisir nom");
		String prenom = saisieString("Saisir prenom");
		Patient p= new Patient(nom,prenom);

		daoP.insert(p);
		
	}	


	public static void main(String[] args) { 	
		
		menuUtilisateur();
	} 
}
