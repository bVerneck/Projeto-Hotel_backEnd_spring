package br.com.tex.hotel.model.dto.cliente;

import br.com.tex.hotel.model.entitys.Cliente;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClienteOutputDTO {
    private Integer id;
    private String nome;
    private String email;

    public ClienteOutputDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }

    public List<ClienteOutputDTO> lista(List<Cliente> clientes) {
        return clientes
                .stream()
                .map(c -> new ClienteOutputDTO(c))
                .toList();
    }
}
