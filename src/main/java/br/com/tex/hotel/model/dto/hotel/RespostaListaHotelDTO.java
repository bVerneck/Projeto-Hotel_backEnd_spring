package br.com.tex.hotel.model.dto.hotel;

import br.com.tex.hotel.model.entitys.Hotel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
@NoArgsConstructor
public class RespostaListaHotelDTO{

    private List<HotelOutputApiDTO> lista = new ArrayList<>();


    public RespostaListaHotelDTO(List<Hotel> hoteis) {
        hoteis.stream().forEach(h ->{
            this.lista.add(new HotelOutputApiDTO(h));
        });
    }

    public List<HotelOutputApiDTO> getLista() {
        return Collections.unmodifiableList(lista);
    }

    public void setLista(List<HotelOutputApiDTO> lista) {
        this.lista = lista;
    }

}
