package org.exam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypePlatDao {

	private static TypePlatDao instance;
	
	private TypePlatDao() {}
	
	public static TypePlatDao getInstance(){
		if(instance == null){
			instance = new TypePlatDao();
		}
		return instance;
	}

	public String read(int numero) {
		
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from typeplat where id = " + numero);
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				return res.getString("type");
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get typePlat " + sqle.toString());
		}
		return null;
	}
	
	public ArrayList<String> getAllType() {
		ArrayList<String> list = new ArrayList<>();
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from typeplat");
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				list.add(res.getString("type"));
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get typeplat " + sqle.toString());
		}
		return list;
	}

	public int getIdFromNom(String nomType) {
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select id from typeplat where type = '" + nomType +"'");
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				return res.getInt("id");
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get typePlat " + sqle.toString());
		}
		return 0;
	}
}
