package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.cliente.ClienteInputSalvatDTO;
import br.com.tex.hotel.model.dto.cliente.ClienteOutputDTO;
import br.com.tex.hotel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody ClienteInputSalvatDTO dto, UriComponentsBuilder uriBuilder) {
        var clienteSalvo = this.clienteRepository.save(dto.toEntityCliente());

        return ResponseEntity
                .created(uriBuilder.path("/clientes/{id}").buildAndExpand(clienteSalvo.getId()).toUri())
                .body(new ClienteOutputDTO(clienteSalvo));
    }

    @GetMapping
    public ResponseEntity lista() {
        var clientes = this.clienteRepository.findAll();

        if (clientes.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(new ClienteOutputDTO().lista(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        var cliente = this.clienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new ClienteOutputDTO(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Integer id) {
        var cliente = this.clienteRepository.getReferenceById(id);

        this.clienteRepository.delete(cliente);
        return ResponseEntity.ok(new ClienteOutputDTO(cliente));
    }
}
