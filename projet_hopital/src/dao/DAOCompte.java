package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Compte;
import model.Medecin;
import model.Secretaire;




public class DAOCompte implements IDAO<Compte,Integer>{

	@Override
	public Compte findById(Integer id) {
		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1,id);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{

				if(rs.getString("type_compte").equals("Medecin")) 
				{
					c=new Medecin((Integer)rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getInt("salle"));
				}
				else if(rs.getString("type_compte").equals("Secretaire")) 
				{
					c = new Secretaire((Integer)rs.getInt("id"),rs.getString("login"), rs.getString("password"));
				}
				
			}
			rs.close();
			ps.close();
			conn.close();


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1,c.getLogin());
			ps.setString(2,c.getPassword());

			if(c instanceof Medecin) {
				ps.setString(3, "Medecin");				
			}
			else if (c instanceof Secretaire) {
				ps.setString(3, "Secretaire");
			}
		

			ps.executeUpdate();
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Compte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	public static Compte seConnecter(String login, String password)
    {
        Compte connect=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

            PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
            ps.setString(1,login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) 
            {
                if(rs.getString("type_compte").equals("Medecin")) 
                {
                    connect = new Medecin(rs.getInt("id"), rs.getString("login"),rs.getString("password"),rs.getInt("salle"));

                }
                else if(rs.getString("type_compte").equals("Secretaire"))
                {
                    connect = new Secretaire(rs.getInt("id"), rs.getString("login"),rs.getString("password"));
                }
                            }

            rs.close();
            ps.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connect;

    }
	
}
