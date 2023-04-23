package br.com.tex.hotel.model.dto.contato;

import br.com.tex.hotel.model.entitys.Contato;
import lombok.*;

import java.util.List;

/**
 * @author willian
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContatoOutputDTO {

    private Integer id;
    private String telefonePrincipal;
    private String telefoneAuxiliar;
    private String email;

    public ContatoOutputDTO(Contato contato) {
        this.id = contato.getId();
        this.telefonePrincipal = contato.getTelefonePrincipal();
        this.telefoneAuxiliar = contato.getTelefoneAuxiliar();
        this.email = contato.getEmail();
    }

    public List<ContatoOutputDTO> lista(List<Contato> contatos) {
        return contatos.stream().map(c -> new ContatoOutputDTO(c)).toList();
    }
}
