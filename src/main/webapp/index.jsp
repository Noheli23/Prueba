<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-sm bg-primary navbar-dark" >
			<div>
				<a href="" class="navbar-brand">Gestión de Usuarios</a>
			</div>
			
			<ul>
				<li><a href=""> Usuarios</a></li>
			</ul>
		</nav>
		</header>
		<br>
		
		<div class="container">
		<div class="row">
		<div class="col col-sm-6"><a href="<%=request.getContextPath()%>/new"><button type="button" class="btn btn-primary">Registrar cliente</button> </a></div>
		<div class="col col-sm-6"><a href="tienda.jsp"><button type="button" class="btn btn-primary">Registrar Tienda</button> </a></div>
		</div>
	</div>
	
			<br>
		<div class="container">	
			<table class="table table-bordered">
				<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Email</th>
					<th>Clave</th>
					
				</tr>
				</thead>
				<tbody>
					<c:forEach var= "cliente" items="${listCliente}">
					<tr>
						<td>
						 	<c:out value="${cliente.id}"/>
						</td>
						<td>
						 	<c:out value="${cliente.nombre}"/>
						</td>
						<td>
						 	<c:out value="${cliente.email}"/>
						</td>
						<td>
						 	<c:out value="${cliente.clave}"/>
						</td>
						
					</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
		
	
</body>
</html>