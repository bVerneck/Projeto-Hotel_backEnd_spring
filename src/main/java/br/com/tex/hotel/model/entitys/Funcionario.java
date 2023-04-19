package br.com.tex.hotel.model.entitys;

import br.com.tex.hotel.model.dto.funcionario.FuncionarioInputSalvarDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 
 * @author willian
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

	public Funcionario(Integer matricula, String nome, String cpf, LocalDate dataNascimento, BigDecimal salario,
					   Contato contato, Endereco endereco) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.contato = contato;
		this.endereco = endereco;
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