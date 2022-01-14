package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Medecin;
import model.Patient;
import model.Visite;

public class DAOVisite implements IDAO<Visite, Integer>{

	@Override
	public Visite findById(Integer id) {


		Visite v = null;
		DAOPatient daoP = new DAOPatient();
		DAOCompte daoC = new DAOCompte();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				Patient p = daoP.findById(rs.getInt("id_patient"));
				Medecin m = (Medecin) daoC.findById(rs.getInt("id_medecin"));
				
				v = new Visite(rs.getInt("numero"), p, m);

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
			ps.setInt(2, v.getPatient().getId());
			ps.setInt(3, v.getMedecin().getId());
			ps.setInt(4, v.getPrix());
			ps.setInt(5, v.getSalle());
			ps.setString(6, v.getDateVisite().toString());

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

	
	public List<Visite> findAllByPatient(Integer id) {

		List<Visite> visites = new ArrayList();
		Visite v =null;
		DAOPatient daoP = new DAOPatient();
		DAOCompte daoC = new DAOCompte();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id_patient=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				Patient p = daoP.findById(rs.getInt("id_patient"));
				Medecin m = (Medecin) daoC.findById(rs.getInt("id_medecin"));
				
				v = new Visite(rs.getInt("numero"), p, m);
				visites.add(v);
			}
			
			rs.close();
			ps.close();
			conn.close();


		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return visites;
	}

		

}
