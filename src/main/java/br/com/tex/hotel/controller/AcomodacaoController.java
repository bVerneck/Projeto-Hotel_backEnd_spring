package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.AcomodacaoDAO;
import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoInputAlterarDTO;
import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoInputSalvarDTO;
import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acomodacoes")
public class AcomodacaoController {
    @Autowired
    private AcomodacaoDAO acomodacaoDAO;

    @Transactional
    @PostMapping
    public ResponseEntity salvar(@RequestBody AcomodacaoInputSalvarDTO dto) {
        this.acomodacaoDAO.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Transactional
    @PutMapping
    public ResponseEntity alterar(@RequestBody AcomodacaoInputAlterarDTO dto) {
        this.acomodacaoDAO.alterar(dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Integer id) {
        this.acomodacaoDAO.delete(id);
        return "Quarto excluído com sucesso!";
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        AcomodacaoOutputDTO acomodacao = this.acomodacaoDAO.getById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(acomodacao);
    }

    @GetMapping
    public List<AcomodacaoOutputDTO> lista() {
        return this.acomodacaoDAO.listAllAcomodacao();
    }
}
