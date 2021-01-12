package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;

public class ClienteDAO {
	public void create(Cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE(nome, endereco, sexo) VALUES" + "(?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getEndereco());
			stmt.setBoolean(3, f.isSexo());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso: ");
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
}

	}
	
	public List<Cliente> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
				while (rs.next()) {
					Cliente f = new Cliente();
					f.setIdCliente(rs.getInt("IdCliente"));
					f.setNome(rs.getString("nome"));
					f.setEndereco(rs.getString("endereco"));
					f.setSexo(rs.getBoolean("sexo"));
					clientes.add(f);
				}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return clientes;
	}
	
	public Cliente read(int IdCliente){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente f = new Cliente();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE IdCliente=? LIMIT 1");
			stmt.setInt(1, IdCliente);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				f.setIdCliente(rs.getInt("idCliente"));
				f.setNome(rs.getString("nome"));
				f.setEndereco(rs.getString("endereco"));
				f.setSexo(rs.getBoolean("sexo"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		 return f;
	}
	
	public void update(Cliente f) { 
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE cliente SET nome=?, endereco=?, sexo=? WHERE idCliente=?;");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getEndereco());
			stmt.setBoolean(3, f.isSexo());
			stmt.setInt(4, f.getIdCliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar" + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}

	public void delete(Cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM cliente WHERE idCliente =?");
			stmt.setInt(1, f.getIdCliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir" + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
}