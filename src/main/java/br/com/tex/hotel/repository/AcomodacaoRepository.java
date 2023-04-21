package br.com.tex.hotel.repository;

import br.com.tex.hotel.model.entitys.Acomodacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author willian
 */
@Repository
public interface AcomodacaoRepository extends JpaRepository<Acomodacao, Integer> {
}