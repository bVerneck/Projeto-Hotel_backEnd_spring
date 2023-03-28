package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Acomodacao;

public class AcomodacaoDAO {

	public Integer inserir(Acomodacao acomodacao) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO acomodacao (nome, valorPorAdulto, valorPorCrianca,"
				+ " tamanho, quartoLivre, hotel_id_hotel)" + " VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, acomodacao.getNomeAcomodacao());
		statement.setBigDecimal(2, acomodacao.getValorAdulto());
		statement.setBigDecimal(3, acomodacao.getValorCrianca());
		statement.setBigDecimal(4, acomodacao.getTamanhoQuarto());
		statement.setBoolean(5, acomodacao.isQuartoLivre());
		statement.setInt(6, acomodacao.getHotel().getId());

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

	public void alterar(Acomodacao acomodacao) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE acomodacao SET nome= ?, valorPorAdulto= ?, valorPorCrianca= ?,"
				+ " tamanho= ?, quartoLivre= ?, hotel_id_hotel= ?" + " WHERE id_acomodacao= ?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, acomodacao.getNomeAcomodacao());
		statement.setBigDecimal(2, acomodacao.getValorAdulto());
		statement.setBigDecimal(3, acomodacao.getValorCrianca());
		statement.setBigDecimal(4, acomodacao.getTamanhoQuarto());
		statement.setBoolean(5, acomodacao.isQuartoLivre());
		statement.setInt(6, acomodacao.getHotel().getId());
		statement.setInt(7, acomodacao.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Acomodacao acomodacao) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM acomodacao WHERE id_acomodacao=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, acomodacao.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Acomodacao getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from acomodacao WHERE id_acomodacao= ?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Acomodacao acomodacao = null;

		while (rs.next()) {
			acomodacao = new Acomodacao(rs.getInt("id_acomodacao"), rs.getString("nome"),
					rs.getBigDecimal("valorPorAdulto"), rs.getBigDecimal("valorPorCrianca"),
					rs.getBoolean("quartoLivre"), rs.getBigDecimal("tamanho"),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));
		}

		return acomodacao;
	}

	public List<Acomodacao> listAllAcomodacao() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from acomodacao";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Acomodacao> quartos = new ArrayList<>();

		while (rs.next()) {
			Acomodacao acomodacao = new Acomodacao(rs.getInt("id_acomodacao"), rs.getString("nome"),
					rs.getBigDecimal("valorPorAdulto"), rs.getBigDecimal("valorPorCrianca"),
					rs.getBoolean("quartoLivre"), rs.getBigDecimal("tamanho"),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));

			quartos.add(acomodacao);
		}

		rs.close();
		statement.close();
		conexao.close();

		return quartos;
	}

	public List<Acomodacao> listAcomodacaoByHotel(int idHotel) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from acomodacao WHERE hotel_id_hotel=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idHotel);

		ResultSet rs = statement.executeQuery();

		List<Acomodacao> quartos = new ArrayList<>();

		while (rs.next()) {
			Acomodacao acomodacao = new Acomodacao(rs.getInt("id_acomodacao"), rs.getString("nome"),
					rs.getBigDecimal("valorPorAdulto"), rs.getBigDecimal("valorPorCrianca"),
					rs.getBoolean("quartoLivre"), rs.getBigDecimal("tamanho"),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));

			quartos.add(acomodacao);
		}

		rs.close();
		statement.close();
		conexao.close();

		return quartos;
	}

}
