package br.com.tex.hotel.model.dto.hotel;

import br.com.tex.hotel.model.entitys.Hotel;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelOutputApiDTO{

    private Integer id;
    private String nome;

    public HotelOutputApiDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.nome = hotel.getNome();
    }
}
