package br.com.tex.hotel.model.dto.acomodacao;

import br.com.tex.hotel.model.entitys.Acomodacao;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author willian
 */
public class AcomodacaoInputAlterarDTO {

    private Integer id;
    private String nomeAcomodacao;
    private BigDecimal valorAdulto;
    private BigDecimal valorCrianca;
    private BigDecimal tamanhoQuarto;

    public AcomodacaoInputAlterarDTO() {}

    public AcomodacaoInputAlterarDTO(Integer id, String nomeAcomodacao, BigDecimal valorAdulto, BigDecimal valorCrianca, BigDecimal tamanhoQuarto) {
        this.id = id;
        this.nomeAcomodacao = nomeAcomodacao;
        this.valorAdulto = valorAdulto;
        this.valorCrianca = valorCrianca;
        this.tamanhoQuarto = tamanhoQuarto;
    }

    public Acomodacao toEntityAcomodacao(Acomodacao acomodacao){

        acomodacao.setNomeAcomodacao(this.nomeAcomodacao);
        acomodacao.setValorAdulto(this.valorAdulto);
        acomodacao.setValorCrianca(this.valorCrianca);
        acomodacao.setTamanhoQuarto(this.tamanhoQuarto);

        return acomodacao;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNomeAcomodacao() {return nomeAcomodacao;}

    public void setNomeAcomodacao(String nomeAcomodacao) {this.nomeAcomodacao = nomeAcomodacao;}

    public BigDecimal getValorAdulto() {return valorAdulto;}

    public void setValorAdulto(BigDecimal valorAdulto) {this.valorAdulto = valorAdulto;}

    public BigDecimal getValorCrianca() {return valorCrianca;}

    public void setValorCrianca(BigDecimal valorCrianca) {this.valorCrianca = valorCrianca;}

    public BigDecimal getTamanhoQuarto() {return tamanhoQuarto;}

    public void setTamanhoQuarto(BigDecimal tamanhoQuarto) {this.tamanhoQuarto = tamanhoQuarto;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcomodacaoInputAlterarDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AcomodacaoInputAlterarDTO{" +
                "id=" + id +
                ", nomeAcomodacao='" + nomeAcomodacao + '\'' +
                '}';
    }
}
