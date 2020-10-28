<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Index Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="thestyles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div id="container">
	
	<!-- Login Container -->
		<div align="center" id="loginBox">
			<form action='Login' method="post" id="userform">
				<fieldset style= "margin:auto text-align:center">
				<legend class="legend-bold" >Login</legend>
					<div>					
						<label>Email:</label>
						<input class="theinput" type="text" placeholder= "Entre com seu email" name="email" required/>
					</div>
					<div>
						<label>Senha:</label>
						<input class="theinput" type="password" placeholder = "Entre com sua senha" name="senha" required/>
					</div>				
					<br>
					<input class="submit" type="submit" value="Login"/> 
					
				</fieldset>
				
			</form>
			<br>
			<!-- Login box Footer -->
			<div id="footer2">
				<p style="color:black"> Novo? <a href="#registerModal" id="registerLink">Cadastrar</a></p>			
				<a href="Login?action=listaUsuarios">Página Administrador</a>
			</div>
		</div>
		<!-- Modal for registration-->
	  	<div class="modal fade" id="registerModal" role="dialog">
			<div style="text-align: center" class="modal-dialog">
		    
		    	 <!-- Modal content-->
			      <div class="modal-content">
				       <div class="modal-header" style="padding:25px 40px;">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4> Cadastro de Usuário</h4>
				       </div>
				       <!-- Modal body-->
				       <div class="modal-body" style="padding:30px 40px;">
				       <!-- Register Form -->
				        <form action='Register' method="post" id="regform">
							<fieldset style= "margin:auto text-align:center">
								<div>
									<label for="nome">Nome</label> 
									<input class="theinput" type="text" name="nome" id="nome" placeholder="Entre com nome de usuário" required/>
								</div>		
								<div>
									<label for="email">Email</label> 
									<input class="theinput" type="text" id="email" name="email"  placeholder="Entre com seu Email" required/>
								</div>			
								<div>
									<label for="senha">Senha</label> 
									<input class="theinput" type="password" id="senha" name="senha" placeholder="Entre com sua senha" required/>
								</div>			
								<div>
									<label for="cfmsenha">Confirmar Senha</label> 
									<input class="theinput" type="password" id="cfmsenha" name="cfmsenha" placeholder="Confirme a senha" required/>
								</div> 
								<br>
								<input class="submit" type="submit" value="Register"/> 
							</fieldset>				
						</form>
						</div>
						<!-- Modal footer-->
						<div class="modal-footer">
					          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>          
					    </div>					
				</div>
			</div>
	  	</div>
	  	
	 	<script>
			$(document).ready(function(){
				//JQuery confirms password is equal to confirm password field
				$("#regform").validate({
					rules: {				
						cfmsenha : 
						{
							equalTo: "#senha"
						}			
					}				
				});
				//opens modal when user clicks register
				$("#registerLink").click(function(){
			        $("#registerModal").modal();
			    });
			});		
		</script>
	</div>
	<!-- page Footer -->
	<div id="footer"></div>
</body>
</html>