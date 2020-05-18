package org.exam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.exam.Modeles.Restaurant;

import org.exam.Dao.SqlConnection;

public class RestaurantDao implements IDao<Restaurant>{

	
	private static RestaurantDao instance;
	
	private RestaurantDao() {}
	
	public static RestaurantDao getInstance(){
		if(instance == null){
			instance = new RestaurantDao();
		}
		return instance;
	}
	
	@Override
	public void create(Restaurant object) {
		if (object != null)
		{
			try{
				String nom = object.getNomRestaurant();
				String adresse = object.getAdresse();
				String typeCuisine = object.getTypeCuisine();
				
				int idTypeCuisine = TypeCuisineDao.getInstance().getIdFromNom(typeCuisine);
				
				Connection laConnexion = SqlConnection.getInstance();
				PreparedStatement requete = laConnexion.prepareStatement("insert into restaurant(nom, addresse, typeCuisine) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);  
				requete.setString(1, nom);
				requete.setString(2, adresse);
				requete.setInt(3, idTypeCuisine);
				requete.executeUpdate();	
			} catch (SQLException sqle){
				System.out.println("Pb insert restaurant " + sqle.getMessage());
			}
		}
	}

	@Override
	public void update(Restaurant object) {
		// TODO Auto-generated method stub
		if (object != null)
		{
			try{
				int id = object.getId();
				String nom = object.getNomRestaurant();
				String addresse = object.getAdresse();
				String typeCuisine = object.getTypeCuisine();
				
				int idTypeCuisine = TypeCuisineDao.getInstance().getIdFromNom(typeCuisine);
				Connection laConnexion = SqlConnection.getInstance();
				Statement requete = laConnexion.createStatement();
				requete.executeUpdate("UPDATE restaurant SET nom = '"+ nom + "' WHERE id = " + id);
				requete.executeUpdate("UPDATE restaurant SET addresse = '"+ addresse + "' WHERE id = " + id);
				requete.executeUpdate("UPDATE restaurant SET typeCuisine = '"+ idTypeCuisine + "' WHERE id = " + id);
			}catch (SQLException sqle){
				System.out.println("pb modification du restaurant : "+object.getNomRestaurant() +' ' + sqle.getMessage());
			}
		}
		
	}

	@Override
	public void delete(Restaurant object) {
		// TODO Auto-generated method stub
		if (object != null)
		{
			try {
				Connection laConnexion = SqlConnection.getInstance();
				Statement requete = laConnexion.createStatement();
				int nbLignes = requete.executeUpdate("DELETE FROM restaurant WHERE id=" + object.getId());
			}catch (SQLException sqle){
				System.out.println("pb suppression du restaurant : " + sqle.getMessage());
			}
		}
	}

	@Override
	public Restaurant read(String numero) {
		
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from restaurant where id = " + numero);
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				int id = res.getInt("id");
				String nom = res.getString("nom"); 
				String addresse =res.getString("addresse");
				String typeCuisine = TypeCuisineDao.getInstance().read(res.getInt("typeCuisine"));
				
				Restaurant resto = new Restaurant(id, nom, addresse, typeCuisine);
				return resto;
			}	
		} catch (SQLException sqle) {
			System.out.println("Pb get all restaurant " + sqle.toString());
		}
		return null;
	}

	@Override
	public ArrayList<Restaurant> getAll() {
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from restaurant ");
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				int id = res.getInt("id");
				String nom = res.getString("nom"); 
				String addresse =res.getString("addresse");
				String typeCuisine = TypeCuisineDao.getInstance().read(res.getInt("typeCuisine"));
				
				Restaurant resto = new Restaurant(id, nom, addresse, typeCuisine);
				list.add(resto);
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get all restaurant " + sqle.toString());
		}
		return list;
	}

}
