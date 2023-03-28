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
import br.com.tex.hotel.model.Funcionario;

public class FuncionarioDAO {

	public Integer inserir(Funcionario funcionario) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO funcionario (matricula, nome, cpf, salario, dataNascimento, hotel_id_hotel,"
				+ " endereco_id_endereco, contato_id_contato) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		statement.setInt(1, funcionario.getMatricula());
		statement.setString(2, funcionario.getNome());
		statement.setString(3, funcionario.getCpf());
		statement.setBigDecimal(4, funcionario.getSalario());
		statement.setDate(5, Date.valueOf(funcionario.getDataNascimento()));
		statement.setInt(6, funcionario.getHotel().getId());
		statement.setInt(7, funcionario.getEndereco().getId());
		statement.setInt(8, funcionario.getContato().getId());

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

	public void alterar(Funcionario funcionario) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE funcionario SET matricula= ?, nome= ?, cpf= ?, salario= ?, dataNascimento= ?,"
				+ " hotel_id_hotel= ?, endereco_id_endereco= ?, contato_id_contato= ? WHERE id_funcionario= ?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, funcionario.getMatricula());
		statement.setString(2, funcionario.getNome());
		statement.setString(3, funcionario.getCpf());
		statement.setBigDecimal(4, funcionario.getSalario());
		statement.setDate(5, Date.valueOf(funcionario.getDataNascimento()));
		statement.setInt(6, funcionario.getHotel().getId());
		statement.setInt(7, funcionario.getEndereco().getId());
		statement.setInt(8, funcionario.getContato().getId());
		statement.setInt(9, funcionario.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Funcionario funcionario) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM funcionario WHERE id_funcionario=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, funcionario.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Funcionario getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from funcionario WHERE id_funcionario=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Funcionario funcionario = null;

		while (rs.next()) {
			funcionario = new Funcionario(rs.getInt("id_funcionario"), rs.getString("nome"), rs.getString("cpf"),
					rs.getDate("dataNascimento").toLocalDate(), rs.getBigDecimal("salario"),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));
		}
		
		rs.close();
		statement.close();
		conexao.close();

		return funcionario;
	}

	public List<Funcionario> listAllFuncionario() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from funcionario";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Funcionario> funcionarios = new ArrayList<>();

		while (rs.next()) {
			Funcionario funcionario = new Funcionario(rs.getInt("id_funcionario"), rs.getString("nome"),
					rs.getString("cpf"), rs.getDate("dataNascimento").toLocalDate(), rs.getBigDecimal("salario"),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));

			funcionarios.add(funcionario);
		}
		
		rs.close();
		statement.close();
		conexao.close();

		return funcionarios;
	}

	public List<Funcionario> listFuncionariosByHotel(int idHotel) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from funcionario WHERE hotel_id_hotel";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idHotel);
		ResultSet rs = statement.executeQuery();

		List<Funcionario> funcionarios = new ArrayList<>();

		while (rs.next()) {
			Funcionario funcionario = new Funcionario(rs.getInt("id_funcionario"), rs.getString("nome"),
					rs.getString("cpf"), rs.getDate("dataNascimento").toLocalDate(), rs.getBigDecimal("salario"),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));

			funcionarios.add(funcionario);
		}
		
		rs.close();
		statement.close();
		conexao.close();

		return funcionarios;
	}
}
