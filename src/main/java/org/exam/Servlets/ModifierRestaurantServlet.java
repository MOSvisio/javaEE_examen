package org.exam.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exam.Dao.RestaurantDao;
import org.exam.Dao.TypeCuisineDao;
import org.exam.Modeles.Restaurant;

public class ModifierRestaurantServlet extends HttpServlet {
	
	private int currentResto;
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		 String id = request.getParameter("resto");
		 currentResto = Integer.parseInt(id);
		 System.out.println(id);
		 Restaurant resto = RestaurantDao.getInstance().read(id);
		 request.setAttribute("nom", resto.getNomRestaurant());
		 request.setAttribute("addresse", resto.getAdresse());
		 request.setAttribute("typeCuisine", TypeCuisineDao.getInstance().getAllType());
		 request.setAttribute("currentType",  resto.getTypeCuisine());
		 this.getServletContext().getRequestDispatcher( "/modifierRestaurant.jsp" ).forward( request, response );
	}
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nom = request.getParameter("nom");
		 String addresse = request.getParameter("addresse");
		 String type = request.getParameter("type");
		 
		 Restaurant rest = new Restaurant(currentResto, nom, addresse, type);
		 rest.modifierRestaurant();
		 response.sendRedirect("/restaurants");
	 }
}
