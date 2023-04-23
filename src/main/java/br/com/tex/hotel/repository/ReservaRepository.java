package br.com.tex.hotel.repository;

import br.com.tex.hotel.model.entitys.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author willian
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
