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
public class AcomodacaoInputSalvarDTO {

    private String nomeAcomodacao;
    private BigDecimal valorAdulto;
    private BigDecimal valorCrianca;
    private boolean quartoLivre;
    private BigDecimal tamanhoQuarto;
    private Integer idHotel;

    public Acomodacao toEntityAcomodacao() {
        return new Acomodacao(this.nomeAcomodacao, this.valorAdulto, this.valorCrianca, this.quartoLivre, this.tamanhoQuarto);
    }
}
