package br.com.tex.hotel.model.dto.hotel;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelInputAlteraDTO {
    private Integer id;
    private String nome;
    private String telefonePrincipal;
    private String telefoneAuxiliar;
    private String email;
    private String tipoLogradouro;
    private String logradouro;
    private Integer numeroResidencial;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

}
