package br.com.tex.hotel.model.entitys;

import java.util.Objects;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private Integer numeroResidencial;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	private String pais;

	public Endereco(TipoLogradouro tipoLogradouro, String logradouro, Integer numeroResidencial, String complemento,
					String cep, String bairro, String cidade, Estado estado, String pais) {
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numeroResidencial = numeroResidencial;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", tipoLogradouro=" + tipoLogradouro.getDescricao() + ", logradouro=" + logradouro
				+ ", numeroResidencial=" + numeroResidencial + ", complemento=" + complemento + ", cep=" + cep
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado.getSigla() + ", pais=" + pais
				+ "]";
	}

}
