package br.com.tex.hotel.controller;

import br.com.tex.hotel.model.dto.cliente.ClienteInputSalvatDTO;
import br.com.tex.hotel.model.dto.cliente.ClienteOutputDTO;
import br.com.tex.hotel.model.entitys.Cliente;
import br.com.tex.hotel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody ClienteInputSalvatDTO dto, UriComponentsBuilder uriBuilder) {
        Cliente clienteSalvo = this.clienteRepository.save(dto.toEntityCliente());

        return ResponseEntity
                .created(uriBuilder.path("/clientes/{id}").buildAndExpand(clienteSalvo.getId()).toUri())
                .body(new ClienteOutputDTO(clienteSalvo));
    }

    @GetMapping
    public ResponseEntity lista() {
        List<Cliente> clientes = this.clienteRepository.findAll();

        if (clientes.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(new ClienteOutputDTO().lista(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        Optional<Cliente> clienteOptional = this.clienteRepository.findById(id);
        return ResponseEntity.ok(new ClienteOutputDTO(clienteOptional.get()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Integer id) {
        Optional<Cliente> clienteOptional = this.clienteRepository.findById(id);

        this.clienteRepository.deleteById(id);
        return ResponseEntity.ok(new ClienteOutputDTO(clienteOptional.get()));
    }
}
