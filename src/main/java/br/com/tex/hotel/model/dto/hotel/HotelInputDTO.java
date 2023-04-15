package br.com.tex.hotel.model.dto.hotel;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.entitys.Contato;
import br.com.tex.hotel.model.entitys.Endereco;
import br.com.tex.hotel.model.entitys.Hotel;

import java.util.Objects;

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

    public HotelInputDTO() {
    }

    public HotelInputDTO(String nome, String telefonePrincipal, String telefoneAuxiliar, String email, String tipoLogradouro, String logradouro, Integer numeroResidencial, String complemento, String cep, String bairro, String cidade, String estado, String pais) {
        this.nome = nome;
        this.telefonePrincipal = telefonePrincipal;
        this.telefoneAuxiliar = telefoneAuxiliar;
        this.email = email;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numeroResidencial = numeroResidencial;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Endereco enderecoHotel(HotelInputDTO hotelInputDTO){
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

    public Contato contatoHotel(HotelInputDTO hotelInputDTO){
        return new Contato(hotelInputDTO.getTelefonePrincipal(), hotelInputDTO.getTelefoneAuxiliar(), hotelInputDTO.getEmail());
    }

    public Hotel toHotel(HotelInputDTO hotelInputDTO){
        Hotel hotel =new Hotel(hotelInputDTO.getNome());
        hotel.setContato(contatoHotel(hotelInputDTO));
        hotel.setEndereco(enderecoHotel(hotelInputDTO));
        return hotel;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getTelefonePrincipal() {return telefonePrincipal;}

    public void setTelefonePrincipal(String telefonePrincipal) {this.telefonePrincipal = telefonePrincipal;}

    public String getTelefoneAuxiliar() {return telefoneAuxiliar;}

    public void setTelefoneAuxiliar(String telefoneAuxiliar) {this.telefoneAuxiliar = telefoneAuxiliar;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}


    public String getLogradouro() {return logradouro;}

    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}

    public Integer getNumeroResidencial() {return numeroResidencial;}

    public void setNumeroResidencial(Integer numeroResidencial) {this.numeroResidencial = numeroResidencial;}

    public String getComplemento() {return complemento;}

    public void setComplemento(String complemento) {this.complemento = complemento;}

    public String getCep() {return cep;}

    public void setCep(String cep) {this.cep = cep;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}


    public String getPais() {return pais;}

    public void setPais(String pais) {this.pais = pais;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelInputDTO that)) return false;
        return Objects.equals(nome, that.nome) && Objects.equals(telefonePrincipal, that.telefonePrincipal) && Objects.equals(telefoneAuxiliar, that.telefoneAuxiliar) && Objects.equals(email, that.email) && tipoLogradouro == that.tipoLogradouro && Objects.equals(logradouro, that.logradouro) && Objects.equals(numeroResidencial, that.numeroResidencial) && Objects.equals(complemento, that.complemento) && Objects.equals(cep, that.cep) && Objects.equals(bairro, that.bairro) && Objects.equals(cidade, that.cidade) && estado == that.estado && Objects.equals(pais, that.pais);
    }

    public String getTipoLogradouro() {return tipoLogradouro;}

    public void setTipoLogradouro(String tipoLogradouro) {this.tipoLogradouro = tipoLogradouro;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefonePrincipal, telefoneAuxiliar, email, tipoLogradouro, logradouro, numeroResidencial, complemento, cep, bairro, cidade, estado, pais);
    }

    @Override
    public String toString() {
        return "HotelInputDTO{" +
                "nome='" + nome + '\'' +
                ", telefonePrincipal='" + telefonePrincipal + '\'' +
                ", telefoneAuxiliar='" + telefoneAuxiliar + '\'' +
                ", email='" + email + '\'' +
                ", tipoLogradouro=" + tipoLogradouro +
                ", logradouro='" + logradouro + '\'' +
                ", numeroResidencial=" + numeroResidencial +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado=" + estado +
                ", pais='" + pais + '\'' +
                '}';
    }
}
