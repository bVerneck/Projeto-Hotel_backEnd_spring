package br.com.tex.hotel.dao;

import br.com.tex.hotel.model.dto.funcionario.FuncionarioInputAlterarDTO;
import br.com.tex.hotel.model.dto.funcionario.FuncionarioInputSalvarDTO;
import br.com.tex.hotel.model.dto.funcionario.FuncionarioOutputDTO;
import br.com.tex.hotel.model.entitys.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioDAO {

	@PersistenceContext
	private EntityManager em;
	public void inserir(FuncionarioInputSalvarDTO dto){
		this.em.persist(dto.toEntityFuncionario());
	}

	public void alterar(FuncionarioInputAlterarDTO dto) {
		this.em.merge(dto.toEntityFuncionario(this.em.find(Funcionario.class, dto.getId())));
	}

	public void delete(Integer id){
		this.em.remove(this.em.find(Funcionario.class, id));
	}

	public FuncionarioOutputDTO getById(Integer id){
		return new FuncionarioOutputDTO(this.em.find(Funcionario.class, id));
	}

	public List<FuncionarioOutputDTO> listAllFuncionario(){
		String jpql = "select f from Funcionario f";

		return this.em.createQuery(jpql, Funcionario.class)
				.getResultList()
				.stream()
				.map(f -> new FuncionarioOutputDTO(f))
				.toList();
	}
}
