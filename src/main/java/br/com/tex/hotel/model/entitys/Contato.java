package br.com.tex.hotel.model.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "contato")
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String telefonePrincipal;
	private String telefoneAuxiliar;
	private String email;

	public Contato() {
	}

	public Contato(String telefonePrincipal, String telefoneAuxiliar, String email) {
		this.telefonePrincipal = telefonePrincipal;
		this.telefoneAuxiliar = telefoneAuxiliar;
		this.email = email;
	}

	public Contato(String telefonePrincipal, String telefoneAuxiliar, String email, Integer id) {
		this.telefonePrincipal = telefonePrincipal;
		this.telefoneAuxiliar = telefoneAuxiliar;
		this.email = email;
		this.id = id;
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
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}
}