package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.servico.ServicoInputDTO;
import br.com.tex.hotel.model.dto.servico.ServicoOutputDTO;
import br.com.tex.hotel.model.entitys.Servico;
import br.com.tex.hotel.repository.ServicoRespositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author willian
 */

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRespositoy servicoRespositoy;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        Servico servico = this.servicoRespositoy.getReferenceById(id);

        return ResponseEntity.ok(new ServicoOutputDTO(servico));
    }

    @GetMapping
    public ResponseEntity lista(){
        List<Servico> servicos = this.servicoRespositoy.findAll();

        if(servicos.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(servicos.stream().map(s -> new ServicoOutputDTO(s)).toList());
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody ServicoInputDTO dto){
        Servico servico = this.servicoRespositoy.save(dto.toEntityServico());
        return ResponseEntity.ok(new ServicoOutputDTO(servico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity alterar(@PathVariable Integer id, ServicoInputDTO dto){
        Servico servico = this.servicoRespositoy.findById(id).get();
        this.servicoRespositoy.save(dto.toEntityServico(servico));

        return ResponseEntity.ok(new ServicoOutputDTO(servico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Integer id){
        this.servicoRespositoy.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
