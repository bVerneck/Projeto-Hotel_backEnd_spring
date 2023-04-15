package br.com.tex.hotel.model.dto.funcionario;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.entitys.Contato;
import br.com.tex.hotel.model.entitys.Endereco;
import br.com.tex.hotel.model.entitys.Funcionario;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author willian
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FuncionarioInputAlterarDTO {

    private Integer id;
    private Integer matricula;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private BigDecimal salario;
    private String telefonePrincipal;
    private String telefoneAuxiliar;
    private String email;
    private String tipoLogradouro;
    private String logradouro;
    private Integer numeroResidencial;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public Funcionario toEntityFuncionario(Funcionario funcionario) {
        funcionario.setCpf(this.cpf);
        funcionario.setNome(this.nome);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setMatricula(this.matricula);
        funcionario.setSalario(this.salario);
        funcionario.setContato(toEntityContato(funcionario.getContato()));
        funcionario.setEndereco(toEntityEndereco(funcionario.getEndereco()));

        return funcionario;
    }

    public Endereco toEntityEndereco(Endereco endereco) {
        endereco.setBairro(this.bairro);
        endereco.setCep(this.cep);
        endereco.setCidade(this.cidade);
        endereco.setEstado(Estado.fromUF(this.estado));
        endereco.setComplemento(this.complemento);
        endereco.setTipoLogradouro(TipoLogradouro.fromDescricao(this.tipoLogradouro));
        endereco.setLogradouro(this.logradouro);
        endereco.setNumeroResidencial(this.numeroResidencial);
        endereco.setPais(this.pais);

        return endereco;
    }

    public Contato toEntityContato(Contato contato) {
        contato.setTelefonePrincipal(this.telefonePrincipal);
        contato.setTelefoneAuxiliar(this.telefoneAuxiliar);
        contato.setEmail(this.email);

        return contato;
    }
}
