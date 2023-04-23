package br.com.tex.hotel.model.dto.servico;

import br.com.tex.hotel.model.entitys.Servico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author willian
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ServicoInputDTO {
    private String descricao;
    private BigDecimal preco;

    public Servico toEntityServico(){
        return new Servico(this.descricao, this.preco);
    }

    public Servico toEntityServico(Servico servico){
        servico.setPreco(this.preco);
        servico.setDescricao(this.descricao);

        return servico;
    }
}
