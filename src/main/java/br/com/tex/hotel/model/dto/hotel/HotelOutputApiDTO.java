package br.com.tex.hotel.model.dto.hotel;

import br.com.tex.hotel.model.entitys.Hotel;

import java.util.Objects;

public class HotelOutputApiDTO implements  java.io.Serializable{

    private Integer id;
    private String nome;
    public HotelOutputApiDTO() {
    }

    public HotelOutputApiDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public HotelOutputApiDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.nome = hotel.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelOutputApiDTO that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "HotelOutputApiDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
