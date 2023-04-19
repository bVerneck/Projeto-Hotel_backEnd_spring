package br.com.tex.hotel.model.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author willian
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @JoinColumn(name = "id_endereco")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Endereco endereco;
    @JoinColumn(name = "id_contato")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Contato contato;

    @Transient
    private List<Funcionario> funcionarios;
    @Transient
    private List<Acomodacao> acomodacoes;

    public Hotel(String nome, Endereco endereco, Contato contato) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Hotel(String nome) {
        this.nome = nome;
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
