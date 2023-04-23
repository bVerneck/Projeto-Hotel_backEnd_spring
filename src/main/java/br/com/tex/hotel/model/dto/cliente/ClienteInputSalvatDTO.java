package br.com.tex.hotel.model.dto.cliente;

import br.com.tex.hotel.model.entitys.Cliente;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteInputSalvatDTO {
    private String nome;
    private String email;
    private String senha;
    private String confirmaSenha;
    public Cliente toEntityCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setSenha(this.senha);

        return cliente;
    }
}
