package br.com.tex.hotel.model.entitys;

import jakarta.persistence.*;

import java.util.Objects;

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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneAuxiliar() {
		return telefoneAuxiliar;
	}

	public void setTelefoneAuxiliar(String telefoneAuxiliar) {
		this.telefoneAuxiliar = telefoneAuxiliar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Contato [telefonePrincipal=" + telefonePrincipal + ", telefoneAuxiliar=" + telefoneAuxiliar + ", email="
				+ email + ", id=" + id + "]";
	}

}