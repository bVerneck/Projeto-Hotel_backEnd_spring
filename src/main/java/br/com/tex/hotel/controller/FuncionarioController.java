package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.funcionario.FuncionarioInputAlterarDTO;
import br.com.tex.hotel.model.dto.funcionario.FuncionarioInputSalvarDTO;
import br.com.tex.hotel.model.dto.funcionario.FuncionarioOutputDTO;
import br.com.tex.hotel.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author willian
 */
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity salvar(@RequestBody FuncionarioInputSalvarDTO dto, UriComponentsBuilder uriBuilder) {
        var funcionario = this.funcionarioRepository.save(dto.toEntityFuncionario());
        return ResponseEntity
                .created(uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri())
                .body(new FuncionarioOutputDTO(funcionario));
    }

    @Transactional
    @PutMapping
    public ResponseEntity alterar(@RequestBody FuncionarioInputAlterarDTO dto) {
        var funcionario = this.funcionarioRepository
                .save(dto.toEntityFuncionario(this.funcionarioRepository.getReferenceById(dto.getId())));
        return ResponseEntity.ok(new FuncionarioOutputDTO(funcionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(new FuncionarioOutputDTO(this.funcionarioRepository.getReferenceById(id)));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id) {
        var funcionario = this.funcionarioRepository.getReferenceById(id);
        this.funcionarioRepository.delete(funcionario);
        return ResponseEntity.ok(new FuncionarioOutputDTO(funcionario));
    }

    @GetMapping
    public ResponseEntity lista() {
        var funcionarios = this.funcionarioRepository.findAll();

        if (funcionarios.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(new FuncionarioOutputDTO().lista(funcionarios));
    }
}