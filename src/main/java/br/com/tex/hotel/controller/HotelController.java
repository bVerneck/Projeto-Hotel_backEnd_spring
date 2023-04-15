package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.model.dto.hotel.HotelInputAlteraDTO;
import br.com.tex.hotel.model.dto.hotel.HotelInputDTO;
import br.com.tex.hotel.model.dto.hotel.HotelOutputDetalheDTO;
import br.com.tex.hotel.model.dto.hotel.RespostaListaHotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author Willian
 */
@RestController
@RequestMapping("/hoteis")
public class HotelController {

    @Autowired
    private HotelDAO dao;

    @GetMapping
    public RespostaListaHotelDTO listHoteis() {
        return new RespostaListaHotelDTO(dao.listAllHotel());
    }

    @GetMapping("/{id}")
    public HotelOutputDetalheDTO mostrarDetalhe(@PathVariable("id") Integer id) {
        return new HotelOutputDetalheDTO(dao.getById(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity cadastra(@RequestBody HotelInputDTO hotelInputDTO) {
        dao.inserir(hotelInputDTO.toHotel(hotelInputDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelInputDTO);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String deleta(@PathVariable Integer id) {
        dao.delete(dao.getById(id));
        return "Excluído com sucesso!";
    }

    @Transactional
    @PutMapping
    public ResponseEntity altera(@RequestBody HotelInputAlteraDTO dto) {
        dao.alterar(dao.getById(dto.getId()), dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }
}
