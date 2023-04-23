package br.com.tex.hotel.repository;

import br.com.tex.hotel.model.entitys.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author willian
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
