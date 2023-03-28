package br.com.tex.hotel.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 
 * @author André
 *
 */
public class Servico {

	private Integer id;
	private String descricao;
	private BigDecimal preco;
	private int hotel_id_hotel;
	private int reserva_id_reserva;

	public Servico(String descricao, BigDecimal preco, int hotel_id_hotel, int reserva_id_reserva) {
		this.descricao = descricao;
		this.preco = preco;
		this.hotel_id_hotel = hotel_id_hotel;
		this.reserva_id_reserva = reserva_id_reserva;
	}

	public Servico(Integer id, String descricao, BigDecimal preco, int hotel_id_hotel, int reserva_id_reserva) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.hotel_id_hotel = hotel_id_hotel;
		this.reserva_id_reserva = reserva_id_reserva;
	}

	public Servico(Integer id) {
		this.id = id;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getHotel_id_hotel() {
		return hotel_id_hotel;
	}

	public int getReserva_id_reserva() {
		return reserva_id_reserva;
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
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", descricao=" + descricao + ", preco=" + preco + "]";
	}

}
