package br.com.tex.hotel.controller;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.dto.endereco.EnderecoInputDTO;
import br.com.tex.hotel.model.dto.endereco.EnderecoOutputDTO;
import br.com.tex.hotel.model.entitys.Endereco;
import br.com.tex.hotel.repository.EnderecoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author willian
 */
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRespository enderecoRespository;

    @GetMapping
    public ResponseEntity lista(){
        List<Endereco> enderecos = this.enderecoRespository.findAll();
        if(enderecos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity
                .ok()
                .body(new EnderecoOutputDTO().lista(enderecos));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        Optional<Endereco> endereco = this.enderecoRespository.findById(id);

        return ResponseEntity
                .ok()
                .body(new EnderecoOutputDTO(endereco.get()));
    }

    @GetMapping("/estados")
    public List<String> estados(){
        return Arrays.asList(Estado.values())
                .stream()
                .map(e -> e.getNome())
                .toList();
    }

    @GetMapping("/tipoLogradouro")
    public List<String> tipoLogradouro(){
        return Arrays.asList(TipoLogradouro.values())
                .stream()
                .map(t -> t.getDescricao())
                .toList();
    }

    @Transactional
    @PostMapping
    public ResponseEntity salvar(EnderecoInputDTO dto, UriComponentsBuilder uriBuilder){
        Endereco enderecoSalvo = this.enderecoRespository.save(dto.toEntityEndereco());

        return ResponseEntity
                .created(uriBuilder.path("/{id}").buildAndExpand(enderecoSalvo.getId()).toUri())
                .body(new EnderecoOutputDTO(enderecoSalvo));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, EnderecoInputDTO dto){
        Optional<Endereco> enderecoOptional = this.enderecoRespository.findById(id);

        Endereco endereco = dto.toEntityEndereco();
        endereco.setId(id);
        endereco = this.enderecoRespository.save(endereco);

        return ResponseEntity.ok(new EnderecoOutputDTO(endereco));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id){
        Optional<Endereco> enderecoOptional = this.enderecoRespository.findById(id);
        this.enderecoRespository.deleteById(id);
        return ResponseEntity.ok(new EnderecoOutputDTO(enderecoOptional.get()));
    }
}
