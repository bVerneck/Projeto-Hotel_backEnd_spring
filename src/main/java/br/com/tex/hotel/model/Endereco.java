package br.com.tex.hotel.model;

import java.util.Objects;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;

public class Endereco {

	private Integer id;
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private Integer numeroResidencial;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private Estado estado;
	private String pais;

	public Endereco() {
	}

	public Endereco(TipoLogradouro tipoLogradouro, String logradouro, Integer numeroResidencial, String complemento,
			String cep, String bairro, String cidade, Estado estado, String pais) {
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

	public Endereco(Integer id, TipoLogradouro tipoLogradouro, String logradouro, Integer numeroResidencial,
			String complemento, String cep, String bairro, String cidade, Estado estado, String pais) {
		this.id = id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumeroResidencial() {
		return numeroResidencial;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getPais() {
		return pais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", tipoLogradouro=" + tipoLogradouro.getDescricao() + ", logradouro=" + logradouro
				+ ", numeroResidencial=" + numeroResidencial + ", complemento=" + complemento + ", cep=" + cep
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado.getSigla() + ", pais=" + pais
				+ "]";
	}

}
