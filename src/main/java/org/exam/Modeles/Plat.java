package org.exam.Modeles;

import org.exam.Dao.PlatDao;

public class Plat {

	private int id; 
	private String nomPlat;
	private String typePlat;
	private double prix;
	
	
	public Plat(int id, String nomPlat, String typePlat, double prix) {
		this.id = id;
		this.nomPlat = nomPlat;
		this.typePlat = typePlat;
		this.prix = prix;
	}
	
	public void getById(String id) {
		Plat plat = PlatDao.getInstance().read(id);
		this.id = plat.getId();
		this.nomPlat = plat.getNomPlat();
		this.typePlat = plat.getTypePlat();
		this.prix = plat.getPrix();
	}
	
	public void creerPlat()
	{
		PlatDao.getInstance().create(this);
	}
	
	public void modifierPlat()
	{
		 // TODO: call DAO
		PlatDao.getInstance().update(this);
	}
	
	public void supprimerPlat() 
	{
		// TODO: call DAO 
		PlatDao.getInstance().delete(this);
	}
	
	public String getNomPlat() {
		return nomPlat;
	}
	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypePlat() {
		return typePlat;
	}

	public void setTypePlat(String typePlat) {
		this.typePlat = typePlat;
	}
	
	public String toString() {
		return "" + this.id;
	}
	
}
