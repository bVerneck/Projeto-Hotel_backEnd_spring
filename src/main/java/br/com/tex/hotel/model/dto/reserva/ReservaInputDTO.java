package br.com.tex.hotel.model.dto.reserva;

import br.com.tex.hotel.model.entitys.Reserva;
import lombok.*;

import java.time.LocalDate;

/**
 * @author willian
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservaInputDTO {

    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private Integer quantHospedeAdulto;
    private Integer quantHospedeAteOitoAnos;
    private Integer idQuarto;

    public Reserva toEntityReserva(){
        Reserva reserva = new Reserva();
        reserva.setDataCheckIn(this.dataCheckIn);
        reserva.setDataCheckOut(this.dataCheckOut);
        reserva.setQuantHospedeAdulto(this.quantHospedeAdulto);
        reserva.setQuantHospedeAteOitoAnos(this.quantHospedeAteOitoAnos);

        return reserva;
    }

    public Reserva toEntityReserva(Reserva reserva){
        reserva.setDataCheckIn(this.dataCheckIn);
        reserva.setDataCheckOut(this.dataCheckOut);
        reserva.setQuantHospedeAdulto(this.quantHospedeAdulto);
        reserva.setQuantHospedeAteOitoAnos(this.quantHospedeAteOitoAnos);

        return reserva;
    }
}
