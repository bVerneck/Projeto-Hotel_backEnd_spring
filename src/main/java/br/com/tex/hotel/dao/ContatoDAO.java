package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Contato;

public class ContatoDAO {

	public Integer inserir(Contato contato) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO contato (telefonePrincipal, telefoneAuxiliar, email) VALUES(?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, contato.getTelefonePrincipal());
		statement.setString(2, contato.getTelefoneAuxiliar());
		statement.setString(3, contato.getEmail());

		statement.executeUpdate();
		
		ResultSet rs = statement.getGeneratedKeys();
		
		int ultimoId=0;
		while(rs.next()) {
			ultimoId=  rs.getInt(1);
		}
		
		rs.close();
		statement.close();
		conexao.close();
		
		return ultimoId;
	}

	public void alterar(Contato contato) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE contato SET telefonePrincipal=?, telefoneAuxiliar=?, email=? WHERE id_contato=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, contato.getTelefonePrincipal());
		statement.setString(2, contato.getTelefoneAuxiliar());
		statement.setString(3, contato.getEmail());
		statement.setInt(4, contato.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Contato contato) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM contato WHERE id_contato=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, contato.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Contato getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from contato WHERE id_contato=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Contato contato = null;

		while (rs.next()) {
			contato = new Contato(rs.getString("telefonePrincipal"),
					rs.getString("telefoneAuxiliar"),
					rs.getString("email"),
					rs.getInt("id_contato"));
		}
		
		rs.close();
		statement.close();
		conexao.close();

		return contato;
	}

	public List<Contato> listAllContato() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from contato";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Contato> contatos = new ArrayList<>();

		while (rs.next()) {
			Contato contato = new Contato(rs.getString("telefonePrincipal"),
					rs.getString("telefoneAuxiliar"),
					rs.getString("email"),
					rs.getInt("id_contato"));

			contatos.add(contato);
		}
		
		rs.close();
		statement.close();
		conexao.close();

		return contatos;
	}
}
