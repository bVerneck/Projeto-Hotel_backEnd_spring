package br.com.tex.hotel.model.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 
 * @author renor
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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