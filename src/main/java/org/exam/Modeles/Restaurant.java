package org.exam.Modeles;

import java.util.ArrayList;

import org.exam.Dao.RestaurantDao;

public class Restaurant {
	private int id;
	private String nomRestaurant;
	private String adresse; 
	private String typeCuisine;
	private ArrayList<Plat> plats;
	
	public Restaurant(int id, String nom, String addresse, String typeCuisine)
	{
		this.id = id;
		this.nomRestaurant = nom;
		this.adresse = addresse;
		this.typeCuisine = typeCuisine;
	}
	
	public static ArrayList<Restaurant> getAllRestaurant() {
		return RestaurantDao.getInstance().getAll();
	}
	
	public void creerRestaurant() {
		RestaurantDao.getInstance().create(this);
	}
	
	public void modifierRestaurant() {
		RestaurantDao.getInstance().update(this);
	}
	
	public void supprimerRestaurant() {
		RestaurantDao.getInstance().delete(this);
	}
	
	public String getNomRestaurant() {
		return nomRestaurant;
	}
	public void setNomRestaurant(String nomRestaurant) {
		this.nomRestaurant = nomRestaurant;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public ArrayList<Plat> getPlats() {
		return plats;
	}
	public void setPlats(ArrayList<Plat> plats) {
		this.plats = plats;
	}
	public String getTypeCuisine() {
		return typeCuisine;
	}
	public void setTypeCuisine(String typeCuisine) {
		this.typeCuisine = typeCuisine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
