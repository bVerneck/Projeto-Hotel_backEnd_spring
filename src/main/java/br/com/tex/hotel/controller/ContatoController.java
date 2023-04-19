package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.contato.ContatoInputDTO;
import br.com.tex.hotel.model.dto.contato.ContatoOutputDTO;
import br.com.tex.hotel.model.entitys.Contato;
import br.com.tex.hotel.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author willian
 */
@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    public ResponseEntity lista() {
        return ResponseEntity.ok(new ContatoOutputDTO().lista(repository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return ResponseEntity.ok(new ContatoOutputDTO(this.repository.findById(id).get()));
    }

    @Transactional
    @PostMapping
    public ResponseEntity salvar(@RequestBody ContatoInputDTO contatoDTO){
        this.repository.save(contatoDTO.toEntityContato());
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoDTO);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody ContatoInputDTO contatoDTO){
        Contato contato = contatoDTO.toEntityContato();
        contato.setId(id);

        this.repository.save(contato);
        return ResponseEntity.ok(contatoDTO);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id){
        this.repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
