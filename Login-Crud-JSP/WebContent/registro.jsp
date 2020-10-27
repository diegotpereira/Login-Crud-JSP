<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
</head>
<body>
	<form action='Register' method="post" id="regform">
		<fieldset style= "margin:auto text-align:center">
			<p><label for="nome">Nome</label> <input type="text" name="nome" id="usnm" required/></p>		
			<p><label for="email">Email</label> <input type="text" name="email" id="email" required/></p>			
			<p><label for="senha">Senha</label> <input type="password" id="senha" name="senha" required/></p>			
			<p><label for="cfmsenha">Confirmar Senha</label> <input type="password" id="senha" name="senha" required/></p> 
			<br>
			<input class="submit" type="submit" value="Register"/> 
		</fieldset>		
	</form>
	  <script>
	$(document).ready(function(){
		$("#regform").validate({
			rules: {				
				cfmsenha : 
				{
					equalTo: "#senha"
				}			
			}				
		});		
	});		
	</script>
</body>
</html>