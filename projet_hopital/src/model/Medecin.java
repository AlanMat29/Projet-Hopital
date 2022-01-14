package model;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Compte{
	private int salle;
	private List<Visite> visites=new ArrayList();
	
	public Medecin(Integer id,String login,String password, int salle) {
		super(id,login,password);
		this.salle=salle;
	}
	public Medecin(Integer id,String login,String password) {
		super(id,login,password);
	}
	
	
	public int getSalle() {
		return salle;
	}
	public void setSalle(int salle) {
		this.salle = salle;
	}
	@Override
	public String toString() {
		return "Medecin [salle=" + salle + ", id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	

	
}

