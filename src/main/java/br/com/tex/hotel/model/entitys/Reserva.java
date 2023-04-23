package br.com.tex.hotel.model.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author willian
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private Integer quantHospedeAdulto;
    private Integer quantHospedeAteOitoAnos;

    @ManyToOne(fetch = FetchType.EAGER)
    private Acomodacao quarto;

    @OneToMany(mappedBy = "reserva", fetch = FetchType.EAGER)
    private List<ServicoReserva> servicosDaReserva = new ArrayList<>();

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", dataCheckIn=" + dataCheckIn + ", dataCheckOut=" + dataCheckOut
                + ", quantHospedeAdulto=" + quantHospedeAdulto + ", quantHospedeAteOitoAnos=" + quantHospedeAteOitoAnos
                + ", quarto=" + quarto.getNomeAcomodacao() + "]";
    }

}
