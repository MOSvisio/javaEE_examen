<%@page import="org.exam.Modeles.Restaurant"%>
<%@ page pageEncoding="UTF-8" %>
<html>
    <body>
        <h2>Hello World!</h2>
        <h3>test test test</h3>
        <table>
	        <% 
	        	java.util.ArrayList<Restaurant> attribut = (java.util.ArrayList) request.getAttribute("test");
	        	
	        	for (Restaurant obj : attribut)
	        	{
	        		out.println("<tr>");
		        		out.println("<td>");
		        			out.println( obj.getNomRestaurant() );
		        		out.println("</td>");
		        		out.println("<td>");
	        				out.println( obj.getAdresse() );
			        	out.println("</td>");
			        	out.println("<td>");
    						out.println( "<a href='/'>Plats</a>" );
	        			out.println("</td>");
	        		out.println("</tr>");
	        	}
		        out.println("<h3>");
		        
		        out.println("</h3>");
	        %>
        </table>
    </body>
</html>
