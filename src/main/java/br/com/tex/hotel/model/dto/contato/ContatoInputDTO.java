package br.com.tex.hotel.model.dto.contato;

import br.com.tex.hotel.model.entitys.Contato;
import lombok.*;

/**
 * @author willian
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContatoInputDTO {

    private String telefonePrincipal;
    private String telefoneAuxiliar;
    private String email;

    public Contato toEntityContato(){
        Contato contato = new Contato();

        contato.setTelefonePrincipal(this.telefonePrincipal);
        contato.setTelefoneAuxiliar(this.telefoneAuxiliar);
        contato.setEmail(this.email);

        return contato;
    }
}
