package br.com.tex.hotel.model;

import java.util.Objects;

public class Contato {
	private String telefonePrincipal;
	private String telefoneAuxiliar;
	private String email;
	private Integer id;

	public void contato() {
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
	
	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public String getTelefoneAuxiliar() {
		return telefoneAuxiliar;
	}

	public String getEmail() {
		return email;
	}

	public Integer getId() {
		return id;
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
