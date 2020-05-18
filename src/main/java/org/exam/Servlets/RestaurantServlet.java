package org.exam.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exam.Dao.RestaurantDao;
import org.exam.Dao.TypeCuisineDao;
import org.exam.Modeles.Restaurant;

public class RestaurantServlet extends HttpServlet {
	
	private ArrayList<Restaurant> restaurants;
	
	public RestaurantServlet() {
		// TODO : get all restaurant from DAO 
		
	}
	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		restaurants = Restaurant.getAllRestaurant();
		ArrayList<Restaurant> restaurantResponse = new ArrayList<>();
		
		if (request.getParameter("type") != null)
		{
			for (Restaurant obj : restaurants)
			{
				if (obj.getTypeCuisine().equals(request.getParameter("type")))
				{
					restaurantResponse.add(obj);
				}
			}
			if (request.getParameter("type").equals("Tous"))
				restaurantResponse = restaurants;
		}
		else if (request.getParameter("nom") != null)
		{
			for (Restaurant obj : restaurants)
			{
				if (obj.getNomRestaurant().toLowerCase().contains(request.getParameter("nom").toLowerCase()))
				{
					restaurantResponse.add(obj);
				}
			}
		}
		else {
			restaurantResponse = restaurants;
		}
		
		request.setAttribute("typeCuisine", TypeCuisineDao.getInstance().getAllType());
		request.setAttribute( "test", restaurantResponse);
		this.getServletContext().getRequestDispatcher( "/restaurant.jsp" ).forward( request, response );
	}
}
