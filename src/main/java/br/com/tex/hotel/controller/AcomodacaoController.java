package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoInputAlterarDTO;
import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoInputSalvarDTO;
import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoOutputDTO;
import br.com.tex.hotel.model.entitys.Acomodacao;
import br.com.tex.hotel.repository.AcomodacaoRepository;
import br.com.tex.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/acomodacoes")
public class AcomodacaoController {

    @Autowired
    private AcomodacaoRepository acomodacaoRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    @PostMapping
    public ResponseEntity salvar(@RequestBody AcomodacaoInputSalvarDTO dto, UriComponentsBuilder uriBuilder) {
        Acomodacao acomodacao = dto.toEntityAcomodacao();
        acomodacao.setHotel(this.hotelRepository.getReferenceById(dto.getIdHotel()));
        acomodacao = this.acomodacaoRepository.save(acomodacao);

        return ResponseEntity
                .created(uriBuilder.path("/acomodacoes/{id}").buildAndExpand(acomodacao.getId()).toUri())
                .body(new AcomodacaoOutputDTO(acomodacao));
    }

    @Transactional
    @PutMapping
    public ResponseEntity alterar(@RequestBody AcomodacaoInputAlterarDTO dto) {
        this.acomodacaoRepository.save(dto.toEntityAcomodacao(this.acomodacaoRepository.findById(dto.getId()).get()));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Integer id) {
        this.acomodacaoRepository.deleteById(id);
        return "Quarto excluído com sucesso!";
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new AcomodacaoOutputDTO(this.acomodacaoRepository.findById(id).get()));
    }

    @GetMapping
    public List<AcomodacaoOutputDTO> lista() {
        return new AcomodacaoOutputDTO().lista(this.acomodacaoRepository.findAll());
    }
}
