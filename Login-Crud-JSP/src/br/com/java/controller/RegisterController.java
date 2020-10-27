package br.com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.java.dao.UsuarioDAO;
import br.com.java.model.Usuario;

@WebServlet(name = "Register", urlPatterns = { "/Register" })
public class RegisterController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;	
	private static String ADMINPG= "/admin.jsp";
	private UsuarioDAO dao;
	
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new UsuarioDAO();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		Usuario usuario = new Usuario();
		PrintWriter pwOut= response.getWriter();
		
		String nome=request.getParameter("nome");		
		String senha =request.getParameter("senha");
		String email=request.getParameter("email");
		String id = request.getParameter("id");		
		usuario.setNome(nome);			
		usuario.setSenha(senha);
		usuario.setEmail(email);
		
		
		if (id==null||id.isEmpty()) {
			
			dao.criarUsuario(usuario);
			pwOut.print("Registro bem-sucedido! Por favor entre.");
			response.setContentType("text/html");
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.include(request, response);
		}
		
		else {
			usuario.setId(Integer.parseInt(id));
			dao.editarConta(usuario);
			request.setAttribute("usuarios",dao.listaUsuarios());
			RequestDispatcher view = request.getRequestDispatcher(ADMINPG);
			view.forward(request, response);
		}
	}
	
	

}
