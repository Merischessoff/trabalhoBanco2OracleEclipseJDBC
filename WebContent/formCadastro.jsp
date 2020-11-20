<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div style="height: 200px; width: 50%; display: block; margin-left: auto; margin-right: auto;">
    	<br/>
        <h1> Cadastro - Corpo clínico</h1>
        <br/>
        <form action="Cadastrar" method="POST">
          <br>
          <strong>Nome:</strong>
          <input class="form-control form-control-sm" type="text" name="nome" value="" />
          <br>
          <strong>Documento:</strong>
          <input class="form-control form-control-sm" type="text" name="documento" value="" />
          <br>
          <select class="form-control" name="especialidade" id="especialidade">
  			<option value="1">Clínico</option>
  			<option value="2">Nutricionista</option>
  			<option value="3">Enfermeiro</option>
  			<option value="4">Cirurgião</option>
  			<option value="5">Dermatologista</option>
		  </select>
		  <br/>
          <input type="submit" value="Enviar" />
          </form></td>
       </div>
    </body>
</html>

