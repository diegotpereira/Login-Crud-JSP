package br.com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.java.dao.UsuarioDAO;

@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String EDITPG= "/editar.jsp";
	private static String ADMINPG= "/admin.jsp";
	private static String BEMVINDOPG= "/bemvindo.jsp";
	private UsuarioDAO dao;
	
	public LoginController() {
		
		super();
		
		dao = new UsuarioDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String redirectPage="/index.jsp";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("remover")) {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deletaConta(id);
			redirectPage= ADMINPG;
			request.setAttribute("usuarios", dao.listaUsuarios());
		}
	}
}
