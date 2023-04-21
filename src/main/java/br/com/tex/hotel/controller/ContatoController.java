package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.contato.ContatoInputDTO;
import br.com.tex.hotel.model.dto.contato.ContatoOutputDTO;
import br.com.tex.hotel.model.entitys.Contato;
import br.com.tex.hotel.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

/**
 * @author willian
 */
@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity lista() {
        List<Contato> contatos = contatoRepository.findAll();
        if (contatos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(new ContatoOutputDTO().lista(contatos));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        Optional<Contato> contatoOptional = this.contatoRepository.findById(id);

        return ResponseEntity.ok(new ContatoOutputDTO(contatoOptional.get()));
    }

    @Transactional
    @PostMapping
    public ResponseEntity salvar(@RequestBody ContatoInputDTO contatoDTO, UriComponentsBuilder uriBuilder) {
        Contato contatoSalvo = this.contatoRepository.save(contatoDTO.toEntityContato());

        return ResponseEntity
                .created(uriBuilder.path("/contatos/{id}").buildAndExpand(contatoSalvo.getId()).toUri())
                .body(new ContatoOutputDTO(contatoSalvo));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody ContatoInputDTO contatoDTO) {
        Contato contato = contatoDTO.toEntityContato();
        contato.setId(id);

        contato = this.contatoRepository.save(contato);
        return ResponseEntity.ok(new ContatoOutputDTO(contato));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id) {
        Optional<Contato> contatoOptional = this.contatoRepository.findById(id);

        this.contatoRepository.deleteById(id);
        return ResponseEntity.ok(new ContatoOutputDTO(contatoOptional.get()));
    }
}
