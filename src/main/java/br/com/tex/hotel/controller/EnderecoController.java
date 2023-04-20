package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.endereco.EnderecoOutputDTO;
import br.com.tex.hotel.repository.EnderecoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok().body(new EnderecoOutputDTO().lista(this.enderecoRespository.findAll()));
    }
}
