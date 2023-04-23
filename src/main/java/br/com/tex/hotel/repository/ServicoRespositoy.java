package br.com.tex.hotel.repository;

import br.com.tex.hotel.model.entitys.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRespositoy extends JpaRepository<Servico, Integer> {
}
