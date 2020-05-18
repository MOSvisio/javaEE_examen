package org.exam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.exam.Modeles.Plat;
import org.exam.Modeles.Restaurant;

public class PlatDao implements IDao<Plat>{
	
	private static PlatDao instance;
	
	private PlatDao() {}
	
	public static PlatDao getInstance(){
		if(instance == null){
			instance = new PlatDao();
		}
		return instance;
	}

	public Plat read(int id) {
		// TODO Auto-generated method stub
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from plat where id = " + id);
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				return new Plat(id, res.getString("nom"), TypePlatDao.getInstance().read(res.getInt("typePlat")), res.getDouble("prix"));
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get plat " + sqle.toString());
		}
		return null;
	}

	@Override
	public void create(Plat object) {
		// TODO Auto-generated method stub
		if (object != null)
		{
			try{
				String nom = object.getNomPlat();
				double prix = object.getPrix();
				String typePlat = object.getTypePlat();
				
				int idTypePlat = TypePlatDao.getInstance().getIdFromNom(typePlat);
				System.out.println("id type plat = " + idTypePlat);
				
				Connection laConnexion = SqlConnection.getInstance();
				PreparedStatement requete = laConnexion.prepareStatement("insert into plat(nom, typePlat, prix) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);  
				requete.setString(1, nom);
				requete.setInt(2, idTypePlat);
				requete.setDouble(3, prix);
				requete.executeUpdate();	
			} catch (SQLException sqle){
				System.out.println("Pb insert plat " + sqle.getMessage());
			}
		}
	}

	@Override
	public void update(Plat object) {
		// TODO Auto-generated method stub
		if (object != null)
		{
			try{
				int id = object.getId();
				String nom = object.getNomPlat();
				double prix = object.getPrix();
				String typePlat = object.getTypePlat();
				
				int idTypePlat = TypePlatDao.getInstance().getIdFromNom(typePlat);
				
				System.out.println("id in update = " + id);
				
				Connection laConnexion = SqlConnection.getInstance();
				Statement requete = laConnexion.createStatement();
				requete.executeUpdate("UPDATE plat SET nom = '"+ nom + "' WHERE id = " + id);
				requete.executeUpdate("UPDATE plat SET typePlat = '"+ idTypePlat + "' WHERE id = " + id);
				requete.executeUpdate("UPDATE plat SET prix = '"+ prix + "' WHERE id = " + id);
			}catch (SQLException sqle){
				System.out.println("pb modification du plat : "+object.getNomPlat() +' ' + sqle.getMessage());
			}
		}
	}

	@Override
	public void delete(Plat object) {
		// TODO Auto-generated method stub
		if (object != null)
		{
			try {
				Connection laConnexion = SqlConnection.getInstance();
				Statement requete = laConnexion.createStatement();
				requete.executeUpdate("DELETE FROM carte WHERE idPlat=" + object.getId());
				requete.executeUpdate("DELETE FROM plat WHERE id=" + object.getId());
			}catch (SQLException sqle){
				System.out.println("pb suppression du client : " + sqle.getMessage());
			}
		}
		
	}

	@Override
	public Plat read(String numero) {
		// TODO Auto-generated method stub
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select * from plat where id = " + numero);
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				int id = res.getInt("id");
				String nom = res.getString("nom"); 
				String typePlat = TypePlatDao.getInstance().read(res.getInt("typePlat"));
				double prix = res.getDouble("prix");
				
				Plat plat = new Plat(id, nom, typePlat, prix);
				return plat;
			}	
		} catch (SQLException sqle) {
			System.out.println("Pb get all restaurant " + sqle.toString());
		}
		return null;
	}

	
	public int getIdFromNom(String nomPlat) {
		try {
			Connection laConnexion = SqlConnection.getInstance();
			PreparedStatement requete;
			requete = laConnexion.prepareStatement("select id from plat where nom = '" + nomPlat +"'");
			ResultSet res = requete.executeQuery();
		
			while (res.next()) {   
				return res.getInt("id");
			}	
			
		} catch (SQLException sqle) {
			System.out.println("Pb get plat " + sqle.toString());
		}
		return 0;
	}
	
	@Override
	public ArrayList<Plat> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
