package model;

public class Medecin extends Compte{

	
	public Medecin(Integer id,String login,String password) {
		super(id,login,password);
	}

	public Medecin(String login,String password) {
		super(login,password);
		
		
	}
	
	
	@Override
	public String toString() {
		return "Medecin [getId()=" + getId() + ", getLogin()=" + getLogin() + ", getPassword()=" + getPassword()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}

