package test; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Compte;
import model.Medecin;
import model.Secretaire;


public class Test { 
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}
	 
	public static void seConnecterSECURE(String login,String password)
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
					
			ResultSet rs = ps.executeQuery();
			
			Compte c=null;
			
			while(rs.next()) 
			{
				
				if(rs.getString("type_compte").equals("Medecin")) 
				{
					connect = new Medecin(null, (rs.getString("login"), rs.getString("password"));
									
				}
				else if(rs.getString("type_compte").equals("Secretaire"))
				{
					connect = new Secretaire(null, (rs.getString("login"), rs.getString("password"));
				}
							}
			if(c==null) {System.out.println("Identifiants invalides");}
			
			rs.close();
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connect;
		
	}
	 
	
	
	
	
	
	
	
} 
 
 
} 
