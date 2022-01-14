package model;

import java.time.LocalDate;

public class Visite {

	
	private int numero;
	private Patient patient;
	private Medecin medecin;
	private int prix;
	private int salle;
	private LocalDate dateVisite;
	
	public Visite(int numero, Patient patient, Medecin medecin) {
		this.numero = numero;
		this.patient = patient;
		this.medecin = medecin;
		this.prix = 20;
		this.salle = medecin.getSalle();
		this.dateVisite = LocalDate.now();
	}

	
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getSalle() {
		return salle;
	}


	public void setSalle(int salle) {
		this.salle = salle;
	}


	public LocalDate getDateVisite() {
		return dateVisite;
	}


	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}


	@Override
	public String toString() {
		return "Visite [numero=" + numero + ", idPatient=" + idPatient + ", idMedecin=" + idMedecin + ", prix=" + prix
				+ ", salle=" + salle + ", dateVisite=" + dateVisite + "]";
	}

	
}	
