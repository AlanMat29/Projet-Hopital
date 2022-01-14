package test;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.DAOVisite;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;


public class App {

	static Compte connect = null;
	static LinkedList<Patient> fileAttente = new LinkedList();
	
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

	

public static void main(String[] args) {



	menuPrincipal();


}

public static void menuPrincipal() {
	
	System.out.println("Appli hoptial");
	System.out.println("Choisir un menu");
	System.out.println("1 - Se connecter");
	System.out.println("2 - Fermer l'appli");

	int choix = saisieInt("Choisir un menu");

	switch(choix) 
	{
	case 1 : connexion();break;
	case 2 : System.exit(0);break;
	}

	menuPrincipal();

}


public static void connexion() {

	System.out.println("Connexion");
	String login = saisieString("Saisir votre login");
	String password = saisieString("Saisir votre password");
	
	Compte connected = seConnecter(login, password);

	if(connected instanceof Medecin) {
		int salle = saisieInt("Choisir une salle (1/2)");
		if (salle==1 ||salle==2) {
		menuMedecin();}
	}
	else if(connected instanceof Secretaire) {menuSecretaire();}
	else if(connected ==null) 
	{
		System.out.println("Identifiants invalides !");
	}
	menuPrincipal();}



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
	case 1 : UpdateListVisite();break; //update list <attente>(visite)  dans l'ordre de visite et affiche nouveau patient
	case 2 : showListDattente();break; //affiche list  <attente>(visite) , précision concernant le prochain patient
	case 3 : insertVisite();break;
	case 4 : connected=null;break;
		}

	menuMedecin();

}

}
public static void  UpdateListVisite() {
	
	List<Visite> salledattente = DAOVisite.class.findAll();
	string a = salledattente.poll();
	for ( Visite 
}


