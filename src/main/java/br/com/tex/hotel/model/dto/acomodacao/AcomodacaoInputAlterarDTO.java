package br.com.tex.hotel.model.dto.acomodacao;

import br.com.tex.hotel.model.entitys.Acomodacao;
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
public class AcomodacaoInputAlterarDTO {

    private Integer id;
    private String nomeAcomodacao;
    private BigDecimal valorAdulto;
    private BigDecimal valorCrianca;
    private BigDecimal tamanhoQuarto;

    public Acomodacao toEntityAcomodacao(Acomodacao acomodacao) {

        acomodacao.setNomeAcomodacao(this.nomeAcomodacao);
        acomodacao.setValorAdulto(this.valorAdulto);
        acomodacao.setValorCrianca(this.valorCrianca);
        acomodacao.setTamanhoQuarto(this.tamanhoQuarto);

        return acomodacao;
    }
}
