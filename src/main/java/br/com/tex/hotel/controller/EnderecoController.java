package br.com.tex.hotel.controller;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.dto.endereco.EnderecoInputDTO;
import br.com.tex.hotel.model.dto.endereco.EnderecoOutputDTO;
import br.com.tex.hotel.repository.EnderecoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author willian
 */
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRespository enderecoRespository;

    @GetMapping
    public ResponseEntity lista() {
        var enderecos = this.enderecoRespository.findAll();
        if (enderecos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity
                .ok()
                .body(new EnderecoOutputDTO().lista(enderecos));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        var endereco = this.enderecoRespository.getReferenceById(id);

        return ResponseEntity
                .ok()
                .body(new EnderecoOutputDTO(endereco));
    }

    @GetMapping("/estados")
    public List<String> estados() {
        return Arrays.asList(Estado.values())
                .stream()
                .map(e -> e.getNome())
                .toList();
    }

    @GetMapping("/tipoLogradouro")
    public List<String> tipoLogradouro() {
        return Arrays.asList(TipoLogradouro.values())
                .stream()
                .map(t -> t.getDescricao())
                .toList();
    }

    @Transactional
    @PostMapping
    public ResponseEntity salvar(EnderecoInputDTO dto, UriComponentsBuilder uriBuilder) {
        var enderecoSalvo = this.enderecoRespository.save(dto.toEntityEndereco());

        return ResponseEntity
                .created(uriBuilder.path("/{id}").buildAndExpand(enderecoSalvo.getId()).toUri())
                .body(new EnderecoOutputDTO(enderecoSalvo));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, EnderecoInputDTO dto) {
        var endereco = this.enderecoRespository.getReferenceById(id);

        endereco = dto.toEntityEndereco();
        endereco.setId(id);
        endereco = this.enderecoRespository.save(endereco);

        return ResponseEntity.ok(new EnderecoOutputDTO(endereco));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id) {
        var endereco = this.enderecoRespository.getReferenceById(id);
        this.enderecoRespository.delete(endereco);
        return ResponseEntity.ok(new EnderecoOutputDTO(endereco));
    }
}
