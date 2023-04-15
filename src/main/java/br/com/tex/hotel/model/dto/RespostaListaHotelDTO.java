package br.com.tex.hotel.model.dto;

import br.com.tex.hotel.model.Hotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RespostaListaHotelDTO implements java.io.Serializable {

    private List<HotelOutputApiDTO> lista = new ArrayList<>();

    public RespostaListaHotelDTO() {
    }

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

    @Override
    public String toString() {
        return "RespostaListaHotelDTO{" +
                "lista=" + lista +
                '}';
    }
}
