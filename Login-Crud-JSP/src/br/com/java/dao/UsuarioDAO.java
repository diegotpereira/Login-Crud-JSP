package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.java.connection.DBUtil;



public class UsuarioDAO {
	
	private Connection conn;
	
	public UsuarioDAO() {
		
		conn= DBUtil.getConnection();
	}
	
	public boolean validaLogin(String usuario,String senha){
		
		boolean logado = false;
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from usuario where email=? and senha=?");
			ps.setString(1, usuario);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			logado = rs.next();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return logado;
		
	}

	public void deletaConta(int id) {
		// TODO Auto-generated method stub
		
	}

	public Object listaUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
