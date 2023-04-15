package br.com.tex.hotel.model.dto.hotel;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.entitys.Hotel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelOutputDetalheDTO {

    private Integer id;
    private String nomeHotel;
    private String telefonePrincipal;
    private String telefoneAuxiliar;
    private String email;
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    private Integer numeroResidencial;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private Estado estado;

    public HotelOutputDetalheDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.nomeHotel = hotel.getNome();
        this.telefonePrincipal = hotel.getContato().getTelefonePrincipal();
        this.telefoneAuxiliar = hotel.getContato().getTelefoneAuxiliar();
        this.email = hotel.getContato().getEmail();
        this.tipoLogradouro = hotel.getEndereco().getTipoLogradouro();
        this.logradouro = hotel.getEndereco().getLogradouro();
        this.numeroResidencial = hotel.getEndereco().getNumeroResidencial();
        this.complemento = hotel.getEndereco().getComplemento();
        this.cep = hotel.getEndereco().getComplemento();
        this.bairro = hotel.getEndereco().getBairro();
        this.cidade = hotel.getEndereco().getCidade();
        this.estado = hotel.getEndereco().getEstado();
    }
}
