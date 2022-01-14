package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import model.Patient;
import model.Visite;

public class DAOVisite implements IDAO<Visite, Integer>{

	@Override
	public Visite findById(Integer id) {


		Visite v = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				v = new Visite(rs.getInt("numero"), rs.getInt("id_patient"), rs.getInt("id_medecin"), rs.getInt("prix"), rs.getInt("salle"), LocalDate.parse(rs.getString("date_visite")));

			}
			
			rs.close();
			ps.close();
			conn.close();


		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return v;
	}


	@Override
	public void insert(Visite v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO visite (numero, id_patient, id_medecin, prix, salle, date_visite) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, v.getNumero());
			ps.setInt(2, v.getIdPatient());
			ps.setInt(2, v.getPrix());
			ps.setInt(2, v.getSalle());
			ps.setString(2, v.getDateVisite().toString());

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
	}
	
	

	@Override
	public List<Visite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Visite o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}


		

}
