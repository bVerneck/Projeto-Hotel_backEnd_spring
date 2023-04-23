package br.com.tex.hotel.model.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "servico_reserva")
public class ServicoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.EAGER)
    private Servico servico;
}
