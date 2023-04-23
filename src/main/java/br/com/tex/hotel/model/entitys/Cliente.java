package br.com.tex.hotel.model.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * @author willian
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cliente cliente = (Cliente) o;
		return Objects.equals(id, cliente.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}