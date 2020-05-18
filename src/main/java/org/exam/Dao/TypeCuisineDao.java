package org.exam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeCuisineDao{
	
	private static TypeCuisineDao instance;
	
	private TypeCuisineDao() {}
	
	public static TypeCuisineDao getInstance(){
		if(instance == null){
			instance = new TypeCuisineDao();
		}
		return instance;
	}

	public String read(int numero) {
		
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from typecuisine where id = " + numero);
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				return res.getString("Type");
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get typeCuisine " + sqle.toString());
		}
		return null;
	}
	
	public ArrayList<String> getAllType() {
		ArrayList<String> list = new ArrayList<>();
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from typecuisine");
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				list.add(res.getString("Type"));
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get typeCuisine " + sqle.toString());
		}
		return list;
	}

	public int getIdFromNom(String nomType) {
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select id from typecuisine where Type = '" + nomType +"'");
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				return res.getInt("id");
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get typeCuisine " + sqle.toString());
		}
		return 0;
	}


}
