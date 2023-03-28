package br.com.tex.hotel.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author willian
 *
 */
public class Reserva {
	private Integer id;
	private LocalDate dataCheckIn;
	private LocalDate dataCheckOut;
	private Integer quantHospedeAdulto;
	private Integer quantHospedeAteOitoAnos;
	private Acomodacao quarto;
	private List<Servico> servicos;

	public Reserva() {
	}

	public Reserva(LocalDate dataCheckIn, LocalDate dataCheckOut, Integer quantHospedeAdulto,
			Integer quantHospedeAteOitoAnos, Acomodacao quarto) {
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
		this.quantHospedeAdulto = quantHospedeAdulto;
		this.quantHospedeAteOitoAnos = quantHospedeAteOitoAnos;
		this.quarto = quarto;
	}

	public Reserva(Integer id, LocalDate dataCheckIn, LocalDate dataCheckOut, Integer quantHospedeAdulto,
			Integer quantHospedeAteOitoAnos, Acomodacao quarto) {
		this.id = id;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
		this.quantHospedeAdulto = quantHospedeAdulto;
		this.quantHospedeAteOitoAnos = quantHospedeAteOitoAnos;
		this.quarto = quarto;
	}

	public void addServico(Servico servico) {
		if (this.servicos == null)
			this.servicos = new ArrayList<>();

		this.servicos.add(servico);
	}

	public void removeServico(Servico servico) {
		if (this.servicos != null)
			if (this.servicos.contains(servico))
				this.servicos.add(servico);
	}

	public BigDecimal valorTotalReserva() {

		BigDecimal valorServicosAdicionais = getTotalServicos();

		BigDecimal valorTotalAdulto = this.quarto.getValorAdulto().multiply(new BigDecimal(this.quantHospedeAdulto));

		BigDecimal valorTotalCrianca = this.quarto.getValorCrianca()
				.multiply(new BigDecimal(this.quantHospedeAteOitoAnos));

		return valorServicosAdicionais.add(valorTotalCrianca).add(valorTotalAdulto);
	}

	public BigDecimal getTotalServicos() {
		if (servicos != null && !servicos.isEmpty() && servicos.size() > 0) {
			double sum = servicos.stream().mapToDouble(s -> s.getPreco().doubleValue()).sum();

			BigDecimal valorTotal = new BigDecimal(sum);
			return valorTotal;
		}
		return BigDecimal.ZERO;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataCheckIn() {
		return dataCheckIn;
	}

	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}

	public Integer getQuantHospedeAdulto() {
		return quantHospedeAdulto;
	}

	public Integer getQuantHospedeAteOitoAnos() {
		return quantHospedeAteOitoAnos;
	}

	public Acomodacao getQuarto() {
		return quarto;
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
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", dataCheckIn=" + dataCheckIn + ", dataCheckOut=" + dataCheckOut
				+ ", quantHospedeAdulto=" + quantHospedeAdulto + ", quantHospedeAteOitoAnos=" + quantHospedeAteOitoAnos
				+ ", quarto=" + quarto.getNomeAcomodacao() + "]";
	}

}
