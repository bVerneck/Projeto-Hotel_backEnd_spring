package br.com.tex.hotel.model.dto.endereco;

import br.com.tex.hotel.model.entitys.Endereco;
import lombok.*;

import java.util.List;

/**
 * @author willian
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoOutputDTO {

    private Integer id;
    private String tipoLogradouro;
    private String logradouro;
    private Integer numeroResidencial;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public EnderecoOutputDTO(Endereco endereco){
        this.id=endereco.getId();
        this.tipoLogradouro=endereco.getTipoLogradouro().getDescricao();
        this.logradouro=endereco.getLogradouro();
        this.numeroResidencial=endereco.getNumeroResidencial();
        this.complemento=endereco.getComplemento();
        this.cep=endereco.getCep();
        this.bairro=endereco.getBairro();
        this.cidade=endereco.getCidade();
        this.estado=endereco.getEstado().getNome();
        this.pais=endereco.getPais();
    }

    public List<EnderecoOutputDTO> lista(List<Endereco> enderecos){
        return enderecos
                .stream()
                .map(e -> new EnderecoOutputDTO(e))
                .toList();
    }
}
