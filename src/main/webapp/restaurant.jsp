<%@ page import="org.exam.Modeles.Restaurant"%>
<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Annuaire</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/restaurants">Restaurants</a>
				</li>
			</ul>
		</div>
	</nav>
	<div style="width: 60%; margin: auto">
		<br />
		<h2 style="width: 90%; margin: auto; text-align: center;">Liste
			des restaurants !</h2>
		<br />
		<form action="/restaurants" method="get">
			<div class="form-group">
				<label for="typeCuisine">Type Cuisine</label> <select
					class="form-control" id="typeCuisine" name="type">
					<%
			      	java.util.ArrayList<String> type = (java.util.ArrayList<String>) request.getAttribute("typeCuisine");
			    	for (String obj : type) 
			    	{
			    		if (obj.equals(request.getParameter("type")))
	    				{
			    			out.println("<option selected>");
	    				}
			    		else 
			    		{
			    			out.println("<option>");
			    		}
		       				out.println( obj );
		       			out.println("</option>");
			    	}
			    	if (request.getParameter("type") != null){
				    	if (request.getParameter("type").equals("Tous"))
				    	{
				    		out.println("<option selected>");
				    	}
				    	else 
			    		{
			    			out.println("<option>");
			    		}
			    	}
			    	else out.println("<option>");
			    	out.println( "Tous" );
	       			out.println("</option>");
			      %>
				</select>

			</div>
			<button type="submit" value="rechercher" class="btn btn-primary">Rechercher
				par type</button>
		</form>
		<br />
		<form action="/restaurants" method="get">
			<div class="form-group">
				<label for="nomResto">Nom du restaurant</label> <input
					class="form-control" id="nomResto" type="text" name="nom">

			</div>
			<button type="submit" value="rechercher par nom"
				class="btn btn-primary">Rechercher par nom</button>
		</form>
		<br /> <a class="btn btn-success" href="/restaurants/creer">Créer
			restaurant</a>

		<table class="table">
			<% 
	        	java.util.ArrayList<Restaurant> attribut = (java.util.ArrayList<Restaurant>) request.getAttribute("test");
	        	
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
        					out.println( obj.getTypeCuisine() );
		        		out.println("</td>");
			        	out.println("<td>");
        					out.println( "<a type='button' class='btn btn-primary' href='/plats?resto=" + obj.getId() +" '>Plats</a>" );
		        		out.println("</td>");
		        		out.println("<td>");
	    					out.println( "<a type='button' class='btn btn-info' href='/restaurants/modifier?resto=" + obj.getId() +" '>Modifier</a>" );
		        		out.println("</td>");
	        		out.println("</tr>");
	        	}
	        %>
		</table>

		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
			integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>
