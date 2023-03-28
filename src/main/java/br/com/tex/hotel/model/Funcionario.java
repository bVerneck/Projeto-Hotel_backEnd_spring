package br.com.tex.hotel.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 
 * @author willian
 *
 */
public class Funcionario {
	private Integer id;
	private Integer matricula;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private BigDecimal salario;
	private Contato contato;
	private Endereco endereco;
	private Hotel hotel;

	public Funcionario() {
	}

	public Funcionario(Integer matricula, String nome, String cpf, LocalDate dataNascimento, BigDecimal salario,
			Contato contato, Endereco endereco, Hotel hotel) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.contato = contato;
		this.endereco = endereco;
		this.hotel = hotel;
	}

	public Funcionario(Integer id, Integer matricula, String nome, String cpf, LocalDate dataNascimento,
			BigDecimal salario, Contato contato, Endereco endereco, Hotel hotel) {
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.contato = contato;
		this.endereco = endereco;
		this.hotel = hotel;
	}

	public Funcionario(Integer matricula, String nome, String cpf, LocalDate dataNascimento, BigDecimal salario,
			Contato contato, Endereco endereco) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.contato = contato;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
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

	public BigDecimal getSalario() {
		return salario;
	}

	public Contato getContato() {
		return contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Hotel getHotel() {
		return hotel;
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", salario=" + salario + ", hotel=" + hotel.getId() + "]";
	}

}
