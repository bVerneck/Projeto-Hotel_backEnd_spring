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
import java.util.Optional;

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
        Optional<Acomodacao> acomodacao = this.acomodacaoRepository.findById(dto.getId());

        this.acomodacaoRepository.save(dto.toEntityAcomodacao(acomodacao.get()));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id) {
        Optional<Acomodacao> acomodacaoOptional = this.acomodacaoRepository.findById(id);

        this.acomodacaoRepository.deleteById(id);
        return ResponseEntity.ok(acomodacaoOptional.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        Optional<Acomodacao> acomodacaoOptional = this.acomodacaoRepository.findById(id);

        return ResponseEntity.ok(new AcomodacaoOutputDTO(acomodacaoOptional.get()));
    }

    @GetMapping
    public ResponseEntity lista() {
        List<Acomodacao> acomodacoes = this.acomodacaoRepository.findAll();

        if(acomodacoes.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(new AcomodacaoOutputDTO().lista(acomodacoes));
    }
}
