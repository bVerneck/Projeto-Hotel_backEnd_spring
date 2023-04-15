package br.com.tex.hotel.model.entitys;

import br.com.tex.hotel.model.dto.funcionario.FuncionarioInputSalvarDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 
 * @author willian
 *
 */

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer matricula;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private BigDecimal salario;

	@JoinColumn(name = "id_contato")
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Contato contato;

	@JoinColumn(name = "id_endereco")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Endereco endereco;

	@JoinColumn(name = "id_hotel")
	@ManyToOne
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

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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