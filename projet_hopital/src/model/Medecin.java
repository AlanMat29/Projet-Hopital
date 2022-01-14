package model;

public class Medecin extends Compte{

	private int salle;
	
	public Medecin(Integer id,String login,String password, int salle) {
		super(id,login,password);
		this.salle=salle;
	}

	public Medecin(String login,String password, int salle) {
		super(login,password);
		this.salle=salle;
		
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	
	@Override
	public String toString() {
		return "Medecin [salle=" + salle + ", getId()=" + getId() + ", getLogin()=" + getLogin() + ", getPassword()="
				+ getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

	
}

