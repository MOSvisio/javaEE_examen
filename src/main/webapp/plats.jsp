<%@ page import="org.exam.Modeles.Plat"%>
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
	<h2 style="width: 50%; margin: auto; text-align: center;">Liste
		des Plats du restaurant !</h2>
	<br />
	<br /> <a class="btn btn-success" href="/plats/creer?resto=<% out.println(request.getAttribute("idResto")); %>">Créer
			plat</a>
	<table class="table">
		<thead>
			<tr>
				<th>Nom du plat</th>
				<th>Type du plat</th>
				<th>Prix</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<% 
	        	java.util.ArrayList<Plat> attribut = (java.util.ArrayList<Plat>) request.getAttribute("plats");
	        	
	        	for (Plat obj : attribut)
	        	{
	        		out.println("<tr>");
		        		out.println("<td>");
		        			out.println( obj.getNomPlat() );
		        		out.println("</td>");
		        		out.println("<td>");
	        				out.println( obj.getTypePlat() );
			        	out.println("</td>");
			        	out.println("<td>");
        					out.println( obj.getPrix() );
		        		out.println("</td>");
		        		out.println("<td>");
	    					out.println( "<a type='button' class='btn btn-primary' href='/plats/modifier?id=" + obj.getId()+ "&all=false&idResto=" + request.getAttribute("idResto") + "' >Modifier</a>" );
		        		out.println("</td>");
		        		out.println("<td>");
	    					out.println( "<a type='button' class='btn btn-danger' href='/plats/delete?id=" + obj.getId()+ "&all=false&idResto=" + request.getAttribute("idResto") + "' >Supprimer</a>" );
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
