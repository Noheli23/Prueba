<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Tienda</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<br>
 <h3 class="login-heading mb-4 text-center">Registro de Tienda</h3>
            <div class="col-md-6 col-lg-8 mx-auto">
              <form action="insert" method="post">
            
                <div class="form-label-group">
                  <input type="text" id="inputNombre" class="form-control" name="nombre" placeholder="Nombre" required autofocus>
                  <br>
                </div>
               
                <div class="form-label-group">
                  <input type="text" id="inputEmail" class="form-control"  name="lema" placeholder="Lema" required autofocus>
                  
                </div>
				<br>
                <div class="form-label-group">
                  <input type="text" id="inputPassword" class="form-control"  name="telefono" placeholder="Telefono" required>
                  
                </div>
				<br>
               
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Registrar</button>

              </form>
             </div>
</body>
</html>