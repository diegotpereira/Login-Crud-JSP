package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.java.connection.DBUtil;
import br.com.java.model.Usuario;



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
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("delete from usuario where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public  List<Usuario> listaUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> usuarioLista = new ArrayList<Usuario>();
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from usuario");
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				usuarioLista.add(usuario);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuarioLista;
	}

	public Usuario getUsuarioByID(int id) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from usuario where id= ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuario;
	}

	public Usuario usuarioSession(String email) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from usuario where email=?");//search database for email
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuario;
	}

	public void criarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into usuario(nome,senha,email) values (?,?,?)");
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void editarConta(Usuario usuario) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps = conn.prepareStatement("update usuario set nome=?, senha=?" + " where id=?"); 
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setInt   (3, usuario.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
