package br.com.tex.hotel.model.dto.hotel;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.entitys.Hotel;

import java.util.Objects;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public String getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public String getTelefoneAuxiliar() {
        return telefoneAuxiliar;
    }

    public void setTelefoneAuxiliar(String telefoneAuxiliar) {
        this.telefoneAuxiliar = telefoneAuxiliar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumeroResidencial() {
        return numeroResidencial;
    }

    public void setNumeroResidencial(Integer numeroResidencial) {
        this.numeroResidencial = numeroResidencial;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelOutputDetalheDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HotelOutputDetalheDTO{" +
                "id=" + id +
                ", nomeHotel='" + nomeHotel + '\'' +
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
                '}';
    }
}
