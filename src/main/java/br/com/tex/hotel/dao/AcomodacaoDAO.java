package br.com.tex.hotel.dao;

import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoInputAlterarDTO;
import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoInputSalvarDTO;
import br.com.tex.hotel.model.dto.acomodacao.AcomodacaoOutputDTO;
import br.com.tex.hotel.model.entitys.Acomodacao;
import br.com.tex.hotel.model.entitys.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AcomodacaoDAO {

    @PersistenceContext
    private EntityManager em;

    public void inserir(AcomodacaoInputSalvarDTO dto) {
        Acomodacao acomodacao = dto.toEntityAcomodacao();
        acomodacao.setHotel(this.em.find(Hotel.class, dto.getIdHotel()));
        this.em.persist(acomodacao);
    }

    public void alterar(AcomodacaoInputAlterarDTO dto) {
        Acomodacao acomodacao = dto.toEntityAcomodacao(this.em.find(Acomodacao.class, dto.getId()));
        this.em.persist(acomodacao);
    }

    public void delete(Integer id) {
        this.em.remove(this.em.find(Acomodacao.class, id));
    }

    public AcomodacaoOutputDTO getById(Integer id) {
        return new AcomodacaoOutputDTO(this.em.find(Acomodacao.class, id));
    }

    public List<AcomodacaoOutputDTO> listAllAcomodacao() {
        String jpql = "select a from Acomodacao a";

        return this.em.createQuery(jpql, Acomodacao.class)
                .getResultList()
                .stream()
                .map(a -> new AcomodacaoOutputDTO(a))
                .toList();
    }

    public List<AcomodacaoOutputDTO> listAcomodacaoByHotel(int idHotel) {
        String jpql = "select a from Acomodacao a where a.hotel = :id";

        return this.em.createQuery(jpql, Acomodacao.class).setParameter("id", idHotel)
                .getResultList()
                .stream()
                .map(a -> new AcomodacaoOutputDTO(a))
                .toList();
    }

}