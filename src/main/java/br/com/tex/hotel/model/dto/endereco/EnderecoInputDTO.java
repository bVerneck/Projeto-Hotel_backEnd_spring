package br.com.tex.hotel.model.dto.endereco;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.entitys.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author willian
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnderecoInputDTO {

    private String tipoLogradouro;
    private String logradouro;
    private Integer numeroResidencial;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco toEntityEndereco(){
        Endereco endereco = new Endereco();
        endereco.setTipoLogradouro(TipoLogradouro.fromDescricao(this.tipoLogradouro));
        endereco.setPais(this.pais);
        endereco.setEstado(Estado.fromUF(this.estado));
        endereco.setCep(this.cep);
        endereco.setLogradouro(this.logradouro);
        endereco.setCidade(this.cidade);
        endereco.setBairro(this.bairro);
        endereco.setComplemento(this.complemento);
        endereco.setNumeroResidencial(this.numeroResidencial);

        return endereco;
    }
}
