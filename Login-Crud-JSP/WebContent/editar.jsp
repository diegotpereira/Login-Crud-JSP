<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Usuário</title>
</head>
<body>
<!--Page is Loaded in admin page modal from Login Servlet  -->
				<form action="Register" id="editform" method="post">
							<fieldset style= "margin:auto text-align:center">
								<div>
									<label for="id" >ID</label>
									<input class="theinput" type="text" readonly="readonly" name="id" id="id" value="<c:out value ="${usuario.id}"/>" />
								</div>
								<div>
									<label for="nome">Nome</label>
									<input class="theinput" type="text" name="nome" id="nome" value="<c:out value ="${usuario.nome}"/>" required/>	
								</div>
								<div>	
									<label for="senha">Senha</label> 
									<input class="theinput" type="text" name="senha" id="senha" value="<c:out value ="${usuario.senha}"/>" required/>	
								</div>		
								<br>
								<input class="back-home-btn" type="submit" value="Update" name = "Alterar"/> 
							</fieldset>		
						</form>

</body>
</html>