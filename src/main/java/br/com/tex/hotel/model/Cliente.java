package br.com.tex.hotel.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author willian
 *
 */
public class Cliente {
	private Integer id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Contato contato;
	private Endereco endereco;
	private List<Reserva> reservas;

	public Cliente() {
	}

	public Cliente(String nome, String cpf, LocalDate dataNascimento, Contato contato, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.contato = contato;
		this.endereco = endereco;
	}

	public Cliente(Integer id, String nome, String cpf, LocalDate dataNascimento, Contato contato, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.contato = contato;
		this.endereco = endereco;
	}

	public void addReserva(Reserva reserva) {
		if (this.reservas == null)
			this.reservas = new ArrayList<>();

		this.reservas.add(reserva);
	}

	public void removeReserva(Reserva reserva) {
		if (this.reservas != null)
			if (this.reservas.contains(reserva))
				this.reservas.remove(reserva);
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

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Contato getContato() {
		return contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + "]";
	}

}
