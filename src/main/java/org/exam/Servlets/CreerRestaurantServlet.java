package org.exam.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exam.Dao.RestaurantDao;
import org.exam.Dao.TypeCuisineDao;
import org.exam.Modeles.Restaurant;

public class CreerRestaurantServlet extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
		 request.setAttribute("typeCuisine", TypeCuisineDao.getInstance().getAllType());
		 this.getServletContext().getRequestDispatcher( "/creerRestaurant.jsp" ).forward( request, response );
	}
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nom = request.getParameter("nom");
		 String addresse = request.getParameter("addresse");
		 String type = request.getParameter("type");
		 
		 Restaurant rest = new Restaurant(0, nom, addresse, type);
		 rest.creerRestaurant();
		 response.sendRedirect("/restaurants");
	 }
}
