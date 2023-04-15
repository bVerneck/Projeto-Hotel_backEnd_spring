package br.com.tex.hotel.model.dto.funcionario;

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
public class FuncionarioOutputDTO {

    private Integer id;
    private Integer matricula;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private BigDecimal salario;
    private Integer idContato;
    private Integer idEndereco;

    public FuncionarioOutputDTO (Funcionario funcionario){
        this.id = funcionario.getId();
        this.matricula=funcionario.getMatricula();
        this.nome=funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.dataNascimento = funcionario.getDataNascimento();
        this.salario=funcionario.getSalario();
        this.idContato=funcionario.getContato().getId();
        this.idEndereco=funcionario.getEndereco().getId();
    }
}
