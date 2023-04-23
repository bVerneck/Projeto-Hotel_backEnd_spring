package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.contato.ContatoInputDTO;
import br.com.tex.hotel.model.dto.contato.ContatoOutputDTO;
import br.com.tex.hotel.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
        var contatos = contatoRepository.findAll();
        if (contatos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(new ContatoOutputDTO().lista(contatos));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        var contato = this.contatoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ContatoOutputDTO(contato));
    }

    @Transactional
    @PostMapping
    public ResponseEntity salvar(@RequestBody ContatoInputDTO contatoDTO, UriComponentsBuilder uriBuilder) {
        var contatoSalvo = this.contatoRepository.save(contatoDTO.toEntityContato());

        return ResponseEntity
                .created(uriBuilder.path("/contatos/{id}").buildAndExpand(contatoSalvo.getId()).toUri())
                .body(new ContatoOutputDTO(contatoSalvo));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody ContatoInputDTO contatoDTO) {
        var contato = this.contatoRepository.getReferenceById(id);
        contato = contatoDTO.toEntityContato();
        contato.setId(id);

        contato = this.contatoRepository.save(contato);
        return ResponseEntity.ok(new ContatoOutputDTO(contato));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id) {
        var contato = this.contatoRepository.getReferenceById(id);

        this.contatoRepository.delete(contato);
        return ResponseEntity.ok(new ContatoOutputDTO(contato));
    }
}
