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
public class FuncionarioInputSalvarDTO {

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

    public Funcionario toEntityFuncionario(){
        Funcionario funcionario = new Funcionario();

        funcionario.setCpf(this.cpf);
        funcionario.setNome(this.nome);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setMatricula(this.matricula);
        funcionario.setSalario(this.salario);
        funcionario.setContato(toEntityContato());
        funcionario.setEndereco(toEntityEndereco());

        return funcionario;
    }

    public Endereco toEntityEndereco(){
        return new Endereco(TipoLogradouro.fromDescricao(this.tipoLogradouro),
                this.logradouro,
                this.numeroResidencial,
                this.complemento,
                this.cep,
                this.bairro,
                this.cidade,
                Estado.fromUF(this.estado),
                this.pais);
    }

    public Contato toEntityContato(){
        return new Contato(this.telefonePrincipal, this.telefoneAuxiliar, this.email);
    }

}
