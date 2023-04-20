package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.ClienteDAO;
import br.com.tex.hotel.model.dto.cliente.ClienteInputSalvatDTO;
import br.com.tex.hotel.model.dto.cliente.ClienteOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteDAO clienteDAO;

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody ClienteInputSalvatDTO dto) {
        this.clienteDAO.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public List<ClienteOutputDTO> lista() {
        return this.clienteDAO.listAllCliente();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.clienteDAO.getById(id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Integer id) {
        this.clienteDAO.delete(id);
        return ResponseEntity.ok().build();
    }
}
