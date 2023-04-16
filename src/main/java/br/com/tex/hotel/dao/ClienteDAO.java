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
import br.com.tex.hotel.model.dto.cliente.ClienteInputSalvatDTO;
import br.com.tex.hotel.model.dto.cliente.ClienteOutputDTO;
import br.com.tex.hotel.model.entitys.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO {

    @PersistenceContext
    private EntityManager em;

    public void inserir(ClienteInputSalvatDTO dto) {
       this.em.persist(dto.toEntityCliente());
    }

    public void alterar() {}

	public ClienteOutputDTO getById(Integer id) {
		return new ClienteOutputDTO(this.em.find(Cliente.class, id));
	}


    public void delete(Integer id) {
       this.em.remove(this.em.find(Cliente.class, id));
    }


    public List<ClienteOutputDTO> listAllCliente() {
		String jpql = "select c from Cliente c";
		return this.em.createQuery(jpql, Cliente.class).getResultList()
				.stream()
				.map(cliente -> new ClienteOutputDTO(cliente))
				.toList();
	}
}
