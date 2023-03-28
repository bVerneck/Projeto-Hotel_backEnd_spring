package br.com.tex.hotel.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 
 * @author renor
 *
 */
public class Acomodacao {
	private Integer id;
	private String nomeAcomodacao;
	private BigDecimal valorAdulto;
	private BigDecimal valorCrianca;
	private boolean quartoLivre;
	private BigDecimal tamanhoQuarto;
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
