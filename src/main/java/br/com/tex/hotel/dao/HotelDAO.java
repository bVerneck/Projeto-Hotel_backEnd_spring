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
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HotelDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Hotel hotel) {
        this.entityManager.persist(hotel);
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

    public Hotel getById(Integer id){
        return this.entityManager.find(Hotel.class, id);
    }

    public List<Hotel> listAllHotel() {
        return this.entityManager.createQuery("select h from Hotel h", Hotel.class).getResultList();
    }
}
