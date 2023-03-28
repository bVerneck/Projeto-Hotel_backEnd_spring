package br.com.tex.hotel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author willian
 *
 */
public class Hotel {
	private Integer id;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	private List<Funcionario> funcionarios;
	private List<Acomodacao> acomodacoes;

	public Hotel() {
	}

	public Hotel(String nome, Endereco endereco, Contato contato) {
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}

	public Hotel(Integer id, String nome, Endereco endereco, Contato contato) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}

	public void addFuncionario(Funcionario funcionario) {
		if (this.funcionarios == null)
			this.funcionarios = new ArrayList<>();

		this.funcionarios.add(funcionario);
	}

	public void removeFuncionario(Funcionario funcionario) {
		if (this.funcionarios != null) {
			if (this.funcionarios.contains(funcionario))
				this.funcionarios.remove(funcionario);
		}
	}

	public void addAcomodacao(Acomodacao acomodacao) {
		if (this.acomodacoes == null)
			this.acomodacoes = new ArrayList<>();

		this.acomodacoes.add(acomodacao);
	}

	public void removeAcomodacao(Acomodacao acomodacao) {
		if (this.acomodacoes != null && this.acomodacoes.contains(acomodacao))
			this.acomodacoes.remove(acomodacao);
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Acomodacao> getAcomodacoes() {
		return acomodacoes;
	}

	public void setAcomodacoes(List<Acomodacao> acomodacoes) {
		this.acomodacoes = acomodacoes;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public Contato getContato() {
		return contato;
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
		Hotel other = (Hotel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nome=" + nome + "]";
	}

}
