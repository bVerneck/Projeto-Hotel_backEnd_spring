package br.com.tex.hotel.model.dto.reserva;

import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoOutputDTO;
import br.com.tex.hotel.model.entitys.Reserva;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author willian
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservaOutputDTO {

    private Integer id;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private Integer quantHospedeAdulto;
    private Integer quantHospedeAteOitoAnos;
    private AcomodacaoOutputDTO quarto;
    private BigDecimal valorTotal;


    public ReservaOutputDTO (Reserva reserva){
        this.id = reserva.getId();
        this.dataCheckIn = reserva.getDataCheckIn();
        this.dataCheckOut=reserva.getDataCheckOut();
        this.quantHospedeAdulto=reserva.getQuantHospedeAdulto();
        this.quantHospedeAteOitoAnos=reserva.getQuantHospedeAteOitoAnos();
        this.quarto = new AcomodacaoOutputDTO(reserva.getQuarto());
    }
}
