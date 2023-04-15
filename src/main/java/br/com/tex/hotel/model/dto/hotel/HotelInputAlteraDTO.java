package br.com.tex.hotel.model.dto.hotel;

import java.util.Objects;

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

    public HotelInputAlteraDTO() {
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelInputAlteraDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HotelInputAlteraDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefonePrincipal='" + telefonePrincipal + '\'' +
                ", telefoneAuxiliar='" + telefoneAuxiliar + '\'' +
                ", email='" + email + '\'' +
                ", tipoLogradouro='" + tipoLogradouro + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numeroResidencial=" + numeroResidencial +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
