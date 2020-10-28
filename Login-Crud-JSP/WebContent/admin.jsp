<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.java.model.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="thestyles2.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<!-- Page Header -->
	<div class= "top-header">
	<!-- Link to Home page -->
		<span class= "home-logo"><a href="/Login-Crud-JSP"></a></span>
		<h1 class="admin-header">Bem Vindo Administrador</h1>
	</div>
	<!-- User Table -->
	<div class="container">
		<div class="content">
			<table class="admin-table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Senha</th>
						<th>Email</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
			<!-- Data from Database -->
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td><c:out value= "${usuario.id}"/></td>
							<td><c:out value= "${usuario.nome}"/></td>
							<td><c:out value="${usuario.senha}"/></td>
							<td><c:out value= "${usuario.email}"/></td>
							<td><a data-toggle="modal" href="#editModal" id="<c:out value="${usuario.id}"/>" class="edit-link" >Editar</a></td>
						<td><a href="Login?action=remove&id=<c:out value="${usuario.id}"/>">Remover</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- Modal for Edit-->
	  	<div class="modal fade" id="editModal" role="dialog">
			<div style="text-align: center" class="modal-dialog">
		    
		    	 <!-- Modal content-->
			      <div class="modal-content">
				       <div class="modal-header" style="padding:25px 40px;">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4> Edit User</h4>
				       </div>
				       <!-- Modal body loads edit page-->
				       <div class="modal-body" style="padding:30px 40px;">
				       		<div class="load-body"></div>	       
				        	
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
				//Sends id to servelet when Edit link is clicked
				$(".edit-link").click(function(){
					var id= $(this).attr('id');
					var action= 'editar';
					var data= "action="+ action + "&id=" +id;
					//Request Get, load response(edit Form ) in modal
					$.ajax({
						type: "Get",
						url: 'Login',
						data: data,
						success: function(response){
							$(".load-body").html(response);
						},
						error : function() {
							alert('error');
						}
					});
				});				
			});
		</script>
	</div>
	<!-- Page Footer -->
	<div class="footer"> <button class="back-home-btn" onclick="history.back()">Back</button> </div>
	
</body>
</html>