package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Servico;

public class ServicoDAO {

	public Integer inserir(Servico servico) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO servico (descricao,preco,hotel_id_hotel,reserva_id_reserva) VALUES(?, ?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, servico.getDescricao());
		statement.setBigDecimal(2, servico.getPreco());
		statement.setInt(3, servico.getHotel_id_hotel());
		statement.setInt(4, servico.getReserva_id_reserva());

		statement.executeUpdate();
		ResultSet rs = statement.getGeneratedKeys();
		int id = 0;
		
		while (rs.next()) {
			id = rs.getInt(1);
		}
		
		rs.close();
		statement.close();
		conexao.close();
		return id;
	}

	public void alterar(Servico servico) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE servico SET descricao=?, preco=? WHERE id_servico=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, servico.getDescricao());
		statement.setBigDecimal(2, servico.getPreco());
		statement.setInt(3, servico.getId());
		
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Servico getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from servico WHERE id_servico=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Servico servico = null;

		while (rs.next()) {
			servico = new Servico(rs.getInt("id_servico"), rs.getString("descricao"), rs.getBigDecimal("preco"),
					rs.getInt("hotel_id_hotel"), rs.getInt("reserva_id_reserva"));
		}
		
		rs.close();
		statement.close();
		conexao.close();

		return servico;
	}

	public List<Servico> listServicosPorReserva(int reserva_id_reserva) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from servico WHERE reserva_id_reserva";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, reserva_id_reserva);

		ResultSet rs = statement.executeQuery();

		List<Servico> servicos = new ArrayList<>();

		while (rs.next()) {
			Servico servico = new Servico(rs.getInt("id_servico"), rs.getString("descricao"), rs.getBigDecimal("preco"),
					rs.getInt("hotel_id_hotel"), rs.getInt("reserva_id_reserva"));

			servicos.add(servico);
		}
		rs.close();
		statement.close();
		conexao.close();

		return servicos;
	}

	public List<Servico> listAllServico() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from servico";
		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		List<Servico> servicos = new ArrayList<>();

		while (rs.next()) {
			Servico servico = new Servico(rs.getInt("id_servico"), rs.getString("descricao"), rs.getBigDecimal("preco"),
					rs.getInt("hotel_id_hotel"), rs.getInt("reserva_id_reserva"));

			servicos.add(servico);
		}
		
		rs.close();
		statement.close();
		conexao.close();

		return servicos;
	}

}
