package org.exam.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exam.Dao.CarteDao;
import org.exam.Modeles.Plat;

public class PlatServlet extends HttpServlet {
	
	private ArrayList<Plat> plats;
	
	public PlatServlet() {
		// TODO : get all restaurant from DAO 
		plats = new ArrayList<>();
	}
	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		String idResto = request.getParameter("resto");
		if (!idResto.isEmpty())
		{
			plats = CarteDao.getInstance().getAllPlatFromResto(Integer.parseInt(idResto));
			System.out.println("try");
			request.setAttribute("idResto", idResto);
		}
		System.out.println(plats.toString());
		
		request.setAttribute( "plats", plats );
		this.getServletContext().getRequestDispatcher( "/plats.jsp" ).forward( request, response );
	}
}
