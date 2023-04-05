package br.com.tex.hotel.dao;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.Contato;
import br.com.tex.hotel.model.Endereco;
import br.com.tex.hotel.model.Hotel;
import br.com.tex.hotel.model.dto.HotelInputAlteraDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HotelDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    public void delete(Hotel hotel){
        this.entityManager.remove(hotel);
    }

    public Hotel getById(Integer id){
        return this.entityManager.find(Hotel.class, id);
    }

    public List<Hotel> listAllHotel() {
        return this.entityManager.createQuery("select h from Hotel h", Hotel.class).getResultList();
    }

    public void alterar(Hotel hotel, HotelInputAlteraDTO dto) {
        hotel.setNome(dto.getNome());

        Contato contato = this.entityManager.find(Contato.class, hotel.getContato().getId());
        contato.setTelefoneAuxiliar(dto.getTelefoneAuxiliar());
        contato.setTelefonePrincipal(dto.getTelefonePrincipal());
        contato.setEmail(dto.getEmail());

        Endereco endereco = this.entityManager.find(Endereco.class, hotel.getEndereco().getId());
        endereco.setBairro(dto.getBairro());
        endereco.setCep(dto.getCep());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(Estado.fromUF(dto.getEstado()));
        endereco.setComplemento(dto.getComplemento());
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumeroResidencial(dto.getNumeroResidencial());
        endereco.setPais(dto.getPais());
        endereco.setTipoLogradouro(TipoLogradouro.fromDescricao(dto.getTipoLogradouro()));
    }
}
