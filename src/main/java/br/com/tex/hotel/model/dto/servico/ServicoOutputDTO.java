package br.com.tex.hotel.model.dto.servico;

import br.com.tex.hotel.model.entitys.Servico;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author willian
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServicoOutputDTO {
    private Integer id;
    private String descricao;
    private BigDecimal preco;

    public ServicoOutputDTO(Servico servico){
        this.id=servico.getId();
        this.descricao=servico.getDescricao();
        this.preco=servico.getPreco();
    }
}
