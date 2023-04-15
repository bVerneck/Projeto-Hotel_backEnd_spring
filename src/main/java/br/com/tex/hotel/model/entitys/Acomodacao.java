package br.com.tex.hotel.model.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 
 * @author renor
 *
 */
@Entity
@Table(name = "acomodacoes")
public class Acomodacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeAcomodacao;
	private BigDecimal valorAdulto;
	private BigDecimal valorCrianca;
	private boolean quartoLivre;
	private BigDecimal tamanhoQuarto;

	@JoinColumn(name = "id_hotel")
	@ManyToOne
	private Hotel hotel;

	public Acomodacao() {
	}

	public Acomodacao(String nomeAcomodacao, BigDecimal valorAdulto, BigDecimal valorCrianca, boolean quartoLivre,
					  BigDecimal tamanhoQuarto, Hotel hotel) {
		this.nomeAcomodacao = nomeAcomodacao;
		this.valorAdulto = valorAdulto;
		this.valorCrianca = valorCrianca;
		this.quartoLivre = quartoLivre;
		this.tamanhoQuarto = tamanhoQuarto;
		this.hotel = hotel;
	}

	public Acomodacao(String nomeAcomodacao, BigDecimal valorAdulto, BigDecimal valorCrianca, boolean quartoLivre,
					  BigDecimal tamanhoQuarto) {
		this.nomeAcomodacao = nomeAcomodacao;
		this.valorAdulto = valorAdulto;
		this.valorCrianca = valorCrianca;
		this.quartoLivre = quartoLivre;
		this.tamanhoQuarto = tamanhoQuarto;
	}

	public Acomodacao(Integer id, String nomeAcomodacao, BigDecimal valorAdulto, BigDecimal valorCrianca,
					  boolean quartoLivre, BigDecimal tamanhoQuarto, Hotel hotel) {
		this.id = id;
		this.nomeAcomodacao = nomeAcomodacao;
		this.valorAdulto = valorAdulto;
		this.valorCrianca = valorCrianca;
		this.quartoLivre = quartoLivre;
		this.tamanhoQuarto = tamanhoQuarto;
		this.hotel = hotel;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isQuartoLivre() {
		return quartoLivre;
	}

	public void setQuartoLivre(boolean quartoLivre) {
		this.quartoLivre = quartoLivre;
	}

	public Integer getId() {
		return id;
	}

	public String getNomeAcomodacao() {
		return nomeAcomodacao;
	}

	public BigDecimal getValorAdulto() {
		return valorAdulto;
	}

	public BigDecimal getValorCrianca() {
		return valorCrianca;
	}

	public BigDecimal getTamanhoQuarto() {
		return tamanhoQuarto;
	}

	public void setNomeAcomodacao(String nomeAcomodacao) {this.nomeAcomodacao = nomeAcomodacao;}

	public void setValorAdulto(BigDecimal valorAdulto) {this.valorAdulto = valorAdulto;}

	public void setValorCrianca(BigDecimal valorCrianca) {this.valorCrianca = valorCrianca;}

	public void setTamanhoQuarto(BigDecimal tamanhoQuarto) {this.tamanhoQuarto = tamanhoQuarto;}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
		Acomodacao other = (Acomodacao) obj;
		return Double.doubleToLongBits(id) == Double.doubleToLongBits(other.id);
	}

	@Override
	public String toString() {
		return "Acomodacao [id=" + id + ", nomeAcomodacao=" + nomeAcomodacao + ", valorAdulto=" + valorAdulto
				+ ", valorCrianca=" + valorCrianca + ", quartoLivre=" + quartoLivre + ", tamanhoQuarto=" + tamanhoQuarto
				+ "]";
	}

}