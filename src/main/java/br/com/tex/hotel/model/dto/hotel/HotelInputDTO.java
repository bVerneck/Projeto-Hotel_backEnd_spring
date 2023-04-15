package br.com.tex.hotel.model.dto.hotel;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.entitys.Contato;
import br.com.tex.hotel.model.entitys.Endereco;
import br.com.tex.hotel.model.entitys.Hotel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelInputDTO {
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

    public Endereco enderecoHotel(HotelInputDTO hotelInputDTO) {
        return new Endereco(TipoLogradouro.fromDescricao(hotelInputDTO.getTipoLogradouro()),
                hotelInputDTO.getLogradouro(),
                hotelInputDTO.getNumeroResidencial(),
                hotelInputDTO.getComplemento(),
                hotelInputDTO.getCep(),
                hotelInputDTO.getBairro(),
                hotelInputDTO.getCidade(),
                Estado.fromUF(hotelInputDTO.getEstado()),
                hotelInputDTO.getPais());
    }

    public Contato contatoHotel(HotelInputDTO hotelInputDTO) {
        return new Contato(hotelInputDTO.getTelefonePrincipal(), hotelInputDTO.getTelefoneAuxiliar(), hotelInputDTO.getEmail());
    }

    public Hotel toHotel(HotelInputDTO hotelInputDTO) {
        Hotel hotel = new Hotel(hotelInputDTO.getNome());
        hotel.setContato(contatoHotel(hotelInputDTO));
        hotel.setEndereco(enderecoHotel(hotelInputDTO));
        return hotel;
    }
}
