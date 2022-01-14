package model;

import java.time.LocalDate;

public class Visite {

	
	private int numero;
	private Integer idPatient;
	private Integer idMedecin;
	private int prix;
	private int salle;
	private LocalDate dateVisite;
	
	
	public Visite(int numero, Integer idPatient, Integer idMedecin, int prix, int salle, LocalDate dateVisite) {
		super();
		this.numero = numero;
		this.idPatient = idPatient;
		this.idMedecin = idMedecin;
		this.prix = prix;
		this.salle = salle;
		this.dateVisite = dateVisite;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Integer getIdPatient() {
		return idPatient;
	}


	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}


	public Integer getIdMedecin() {
		return idMedecin;
	}


	public void setIdMedecin(Integer idMedecin) {
		this.idMedecin = idMedecin;
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
