package org.exam.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exam.Dao.CarteDao;
import org.exam.Dao.PlatDao;
import org.exam.Dao.RestaurantDao;
import org.exam.Dao.TypeCuisineDao;
import org.exam.Dao.TypePlatDao;
import org.exam.Modeles.Plat;
import org.exam.Modeles.Restaurant;

public class ModifierPlatServlet extends HttpServlet {
	private int currentPlat;
	private String idResto;
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		 String id = request.getParameter("id");
		 idResto = request.getParameter("idResto");
		 currentPlat = Integer.parseInt(id);
		 Plat plat = new Plat(0, "", "", 0);
		 plat.getById(id);
		 request.setAttribute("nom", plat.getNomPlat());
		 request.setAttribute("prix", plat.getPrix());
		 request.setAttribute("typePlat", TypePlatDao.getInstance().getAllType());
		 request.setAttribute("currentType",  plat.getTypePlat());
		 this.getServletContext().getRequestDispatcher( "/modifierPlat.jsp" ).forward( request, response );
	}
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nom = request.getParameter("nom");
		 String prix = request.getParameter("prixPlat");
		 String type = request.getParameter("type");
		 
		 if (nom != null && prix != null && type != null)
		 {
			 Plat plat = new Plat(currentPlat, nom, type, Double.parseDouble(prix));
			 plat.modifierPlat();
		 }
		 response.sendRedirect("/plats?resto=" + idResto);

	 }
}
