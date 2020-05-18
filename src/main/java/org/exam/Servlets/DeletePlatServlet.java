package org.exam.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exam.Dao.CarteDao;
import org.exam.Dao.PlatDao;
import org.exam.Modeles.Plat;

public class DeletePlatServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		String id = request.getParameter("idResto");
		if (request.getParameter("id") != null) {
			Plat plat = new Plat(Integer.parseInt(request.getParameter("id")), "", "", 0);
			plat.supprimerPlat();
		}
		
		response.sendRedirect("/plats?resto=" + id);
	}
}
