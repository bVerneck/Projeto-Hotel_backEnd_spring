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
public class AcomodacaoOutputDTO {

    private Integer id;
    private String nomeAcomodacao;
    private BigDecimal valorAdulto;
    private BigDecimal valorCrianca;
    private boolean quartoLivre;
    private BigDecimal tamanhoQuarto;

    public AcomodacaoOutputDTO(Acomodacao acomodacao) {
        this.id = acomodacao.getId();
        this.nomeAcomodacao = acomodacao.getNomeAcomodacao();
        this.valorAdulto = acomodacao.getValorAdulto();
        this.valorCrianca = acomodacao.getValorCrianca();
        this.quartoLivre = acomodacao.isQuartoLivre();
        this.tamanhoQuarto = acomodacao.getTamanhoQuarto();
    }
}
