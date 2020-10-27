package br.com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.java.dao.UsuarioDAO;
import br.com.java.model.Usuario;

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
		
		else if (action.equalsIgnoreCase("listaUsuarios")) {
			redirectPage= ADMINPG;
			request.setAttribute("usuarios", dao.listaUsuarios());
		}
		
		else if (action.equalsIgnoreCase("editar")) {
			redirectPage= EDITPG;
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario usuario = dao.getUsuarioByID(id);
			request.setAttribute("usuario", usuario); 
		}
		
		RequestDispatcher view = request.getRequestDispatcher(redirectPage);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pwOut = response.getWriter();
		String email = request.getParameter("email");
		String senha =request.getParameter("senha");
		
		if (dao.validaLogin(email, senha)) {
			Usuario usuario = dao.usuarioSession(email);
			HttpSession session = request.getSession();
			session.setAttribute("nome", usuario.getNome());
			session.setAttribute("email", email);
			RequestDispatcher view = request.getRequestDispatcher(BEMVINDOPG);	
			view.forward(request, response);
		}
		
		else {
			pwOut.print("<p style=\"color:red\">Usuário ou senha incorretos!</p>");
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");	
			view.include(request, response);
			
		}
		
		pwOut.close();
	}
}
