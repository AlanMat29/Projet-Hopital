package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Patient;

public class DAOPatient implements IDAO<Patient, Integer> {
	
	@Override
	public Patient findById(Integer id) {
		Patient p = null;
		try
		{
			// On fait notre requête
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from patient where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			// On cherche dans les informations reçuent dans notre requête
			while (rs.next())
			{
				p = new Patient(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"));

			}
			
			rs.close();
			ps.close();
			conn.close();


		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return p;
	}
	
	
	@Override
	public void insert(Patient p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO patient (nom, prenom) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());

			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				p.setId(rs.getInt(1));
			}

			
			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
		
	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Patient o) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}


}
