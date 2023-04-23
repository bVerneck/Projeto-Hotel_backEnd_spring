package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.reserva.ReservaOutputDTO;
import br.com.tex.hotel.model.entitys.Reserva;
import br.com.tex.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author willian
 */
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public ResponseEntity lista(){
        List<Reserva> reservas = this.reservaRepository.findAll();
        return ResponseEntity.ok(reservas.stream().map(r -> new ReservaOutputDTO(r)).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        Reserva reserva = this.reservaRepository.findById(id).get();

        return ResponseEntity.ok(new ReservaOutputDTO(reserva));
    }
}
