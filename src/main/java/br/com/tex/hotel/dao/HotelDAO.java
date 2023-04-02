package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Hotel;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDAO {

    public Integer inserir(Hotel hotel) {
        try {
            Connection conexao = FactoryConnetion.getConnection();

            String sql = "INSERT INTO hotel (nome, contato_id_contato, endereco_id_endereco) VALUES(?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, hotel.getNome());
            statement.setInt(2, hotel.getContato().getId());
            statement.setInt(3, hotel.getEndereco().getId());

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

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void alterar(Hotel hotel) throws SQLException {
        Connection conexao = FactoryConnetion.getConnection();
        String sql = "UPDATE hotel SET nome=?, contato_id_contato=?, endereco_id_endereco=? WHERE id_hotel=?";

        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1, hotel.getNome());
        statement.setInt(2, hotel.getContato().getId());
        statement.setInt(3, hotel.getEndereco().getId());
        statement.setInt(4, hotel.getId());

        statement.execute();

        statement.close();
        conexao.close();
    }

    public void delete(Hotel hotel) throws SQLException {
        Connection conexao = FactoryConnetion.getConnection();
        String sql = "DELETE FROM hotel WHERE id_hotel=?";

        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setInt(1, hotel.getId());
        statement.execute();

        statement.close();
        conexao.close();
    }

    public Hotel getById(Integer id) throws SQLException {
        Connection conexao = FactoryConnetion.getConnection();
        String sql = "SELECT * from hotel WHERE id_hotel=?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        Hotel hotel = null;

        while (rs.next()) {
            hotel = new Hotel(rs.getInt("id_hotel"),
                    rs.getString("nome"), new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
                    new ContatoDAO().getById(rs.getInt("contato_id_contato")));
        }

        return hotel;
    }

    public List<Hotel> listAllHotel() {
        Connection conexao;
        try {
            conexao = FactoryConnetion.getConnection();
            String sql = "SELECT * from hotel";
            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            List<Hotel> hoteis = new ArrayList<>();

            while (rs.next()) {
                Hotel hotel = new Hotel(rs.getInt("id_hotel"), rs.getString("nome"),
                        new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
                        new ContatoDAO().getById(rs.getInt("contato_id_contato")));

                hoteis.add(hotel);
            }

            if (hoteis != null && !hoteis.isEmpty()) {
                for (Hotel hotel : hoteis) {
                    hotel.setFuncionarios(new FuncionarioDAO().listFuncionariosByHotel(hotel.getId()));
                    hotel.setAcomodacoes(new AcomodacaoDAO().listAcomodacaoByHotel(hotel.getId()));
                }
            }

            rs.close();
            statement.close();
            conexao.close();

            return hoteis;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
