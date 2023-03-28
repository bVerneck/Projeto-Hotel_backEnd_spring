package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Cliente;

public class ClienteDAO {

	public Integer inserir(Cliente cliente) throws SQLException {

		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO cliente (nome, cpf, dataNascimento,"
				+ " contato_id_contato, endereco_id_endereco, reserva_id_reserva)" + " VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getCpf());
		statement.setDate(3, Date.valueOf(cliente.getDataNascimento()));
		statement.setInt(4, cliente.getContato().getId());
		statement.setInt(5, cliente.getEndereco().getId());
		statement.setInt(6, cliente.getReservas().get(0).getId()); // precisa modificar.

		statement.executeUpdate();

		ResultSet rs = statement.getGeneratedKeys();

		int ultimoId = 0;
		while (rs.next()) {
			ultimoId = rs.getInt(1);
		}

		rs.close();
		statement.close();
		conexao.close();

		return ultimoId;
	}

	public void alterar(Cliente cliente) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE funcionario SET matricula= ?, nome= ?, cpf= ?, salario= ?, dataNascimento= ?,"
				+ " hotel_id_hotel= ?, endereco_id_endereco= ?, contato_id_contato= ? WHERE id_funcionario= ?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getCpf());
		statement.setDate(3, Date.valueOf(cliente.getDataNascimento()));
		statement.setInt(4, cliente.getContato().getId());
		statement.setInt(5, cliente.getEndereco().getId());
		statement.setInt(6, cliente.getReservas().get(0).getId()); // precisa modificar.

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Cliente cliente) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM cliente WHERE id_cliente=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, cliente.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Cliente getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from cliente WHERE id_cliente=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Cliente cliente = null;

		while (rs.next()) {
			cliente = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getDate("dataNascimento").toLocalDate(),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")));
		}

		rs.close();
		statement.close();
		conexao.close();
		
		return cliente;
	}

	public List<Cliente> listAllFuncionario() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from cliente";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Cliente> clientes = new ArrayList<>();

		while (rs.next()) {
			Cliente cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nome"), rs.getString("cpf"),
					rs.getDate("dataNascimento").toLocalDate(),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")));

			clientes.add(cliente);
		}

		rs.close();
		statement.close();
		conexao.close();
		
		return clientes;
	}
}
