package org.exam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.exam.Modeles.Plat;
import org.exam.Modeles.Restaurant;

public class CarteDao {
	
	private static CarteDao instance;
	
	private CarteDao() {}
	
	public static CarteDao getInstance(){
		if(instance == null){
			instance = new CarteDao();
		}
		return instance;
	}
	
	public ArrayList<Plat> getAllPlatFromResto(int idResto)
	{
		
		ArrayList<Plat> list = new ArrayList<Plat>();
		
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from carte where idResto = " + idResto);
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				int id = res.getInt("idPlat"); 
				Plat newPlat = PlatDao.getInstance().read(id);
				list.add(newPlat);
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get all restaurant " + sqle.toString());
		}
		return list;
		
	}
	
	public void deletePlatDunResto(int idResto, int idPlat)
	{

		try {
			Connection laConnexion = SqlConnection.getInstance();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("DELETE FROM carte WHERE idPlat=" + idPlat + " and idResto = " + idResto);
		}catch (SQLException sqle){
			System.out.println("pb suppression du client : " + sqle.getMessage());
		}

	}
	
	public void create(int idResto, int idPlat)
	{
		try{

			
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete = laConnexion.prepareStatement("insert into carte(idResto, idPlat) values(?,?)", Statement.RETURN_GENERATED_KEYS);  
			requete.setInt(1, idResto);
			requete.setInt(2, idPlat);

			requete.executeUpdate();	
		} catch (SQLException sqle){
			System.out.println("Pb insert carte " + sqle.getMessage());
		}
	}
	

}
