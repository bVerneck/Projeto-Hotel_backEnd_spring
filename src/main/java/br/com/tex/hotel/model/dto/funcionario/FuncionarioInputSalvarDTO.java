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
    private Integer idContato;
    private Integer idEndereco;

    public Funcionario toEntityFuncionario(){
        Funcionario funcionario = new Funcionario();

        funcionario.setCpf(this.cpf);
        funcionario.setNome(this.nome);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setMatricula(this.matricula);
        funcionario.setSalario(this.salario);

        return funcionario;
    }

}
