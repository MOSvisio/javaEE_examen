package org.exam.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exam.Dao.CarteDao;
import org.exam.Dao.PlatDao;
import org.exam.Dao.RestaurantDao;
import org.exam.Dao.TypePlatDao;
import org.exam.Modeles.Plat;
import org.exam.Modeles.Restaurant;

public class CreerPlatServlet extends HttpServlet {
	private int idResto;
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		 idResto = Integer.parseInt(request.getParameter("resto"));
		 request.setAttribute("typePlat", TypePlatDao.getInstance().getAllType());
		 this.getServletContext().getRequestDispatcher( "/creerPlat.jsp" ).forward( request, response );
	}
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nom = request.getParameter("nom");
		 String prix = request.getParameter("prixPlat");
		 String type = request.getParameter("type");
		 
		 if (nom != null && prix != null && type != null)
		 {
			 Plat plat = new Plat(0, nom, type, Double.parseDouble(prix));
			 plat.creerPlat();
			 CarteDao.getInstance().create(idResto, PlatDao.getInstance().getIdFromNom(nom));
		 }
		 response.sendRedirect("/plats?resto=" + idResto);
	 }
}
