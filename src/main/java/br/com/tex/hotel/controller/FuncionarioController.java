package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.FuncionarioDAO;
import br.com.tex.hotel.model.dto.funcionario.FuncionarioInputAlterarDTO;
import br.com.tex.hotel.model.dto.funcionario.FuncionarioInputSalvarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author willian
 */
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioDAO dao;

    @Transactional
    @PostMapping
    public ResponseEntity salvar(@RequestBody FuncionarioInputSalvarDTO dto) {
        this.dao.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Transactional
    @PutMapping
    public ResponseEntity alterar(@RequestBody FuncionarioInputAlterarDTO dto) {
        this.dao.alterar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.dao.getById(id));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id){
        this.dao.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity lista() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.dao.listAllFuncionario());
    }
}