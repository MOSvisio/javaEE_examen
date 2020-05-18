package org.exam.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConnection {

	private static Connection instance;
	
	
	public static Connection getInstance(){
		if(instance == null){
			instance = creeConnexion();
		}
		return instance;
	}
	
	public static Connection creeConnexion(){
		
		String url = "jdbc:mysql://localhost:3306/server_restaurant?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		String login = "root";
		String pwd = "";
		Connection maConnexion = null;	
		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle){
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}
	
}
