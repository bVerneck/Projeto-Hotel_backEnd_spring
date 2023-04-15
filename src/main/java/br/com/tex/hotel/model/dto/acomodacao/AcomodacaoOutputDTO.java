package br.com.tex.hotel.model.dto.acomodacao;

import br.com.tex.hotel.model.entitys.Acomodacao;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author willian
 */
public class AcomodacaoOutputDTO {

    private Integer id;
    private String nomeAcomodacao;
    private BigDecimal valorAdulto;
    private BigDecimal valorCrianca;
    private boolean quartoLivre;
    private BigDecimal tamanhoQuarto;


    public AcomodacaoOutputDTO() {}

    public AcomodacaoOutputDTO(Integer id, String nomeAcomodacao, BigDecimal valorAdulto, BigDecimal valorCrianca, boolean quartoLivre, BigDecimal tamanhoQuarto) {
        this.id = id;
        this.nomeAcomodacao = nomeAcomodacao;
        this.valorAdulto = valorAdulto;
        this.valorCrianca = valorCrianca;
        this.quartoLivre = quartoLivre;
        this.tamanhoQuarto = tamanhoQuarto;
    }

    public AcomodacaoOutputDTO(Acomodacao acomodacao) {
        this.id = acomodacao.getId();
        this.nomeAcomodacao = acomodacao.getNomeAcomodacao();
        this.valorAdulto = acomodacao.getValorAdulto();
        this.valorCrianca = acomodacao.getValorCrianca();
        this.quartoLivre = acomodacao.isQuartoLivre();
        this.tamanhoQuarto = acomodacao.getTamanhoQuarto();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeAcomodacao() {
        return nomeAcomodacao;
    }

    public void setNomeAcomodacao(String nomeAcomodacao) {
        this.nomeAcomodacao = nomeAcomodacao;
    }

    public BigDecimal getValorAdulto() {
        return valorAdulto;
    }

    public void setValorAdulto(BigDecimal valorAdulto) {
        this.valorAdulto = valorAdulto;
    }

    public BigDecimal getValorCrianca() {
        return valorCrianca;
    }

    public void setValorCrianca(BigDecimal valorCrianca) {
        this.valorCrianca = valorCrianca;
    }

    public boolean isQuartoLivre() {
        return quartoLivre;
    }

    public void setQuartoLivre(boolean quartoLivre) {
        this.quartoLivre = quartoLivre;
    }

    public BigDecimal getTamanhoQuarto() {
        return tamanhoQuarto;
    }

    public void setTamanhoQuarto(BigDecimal tamanhoQuarto) {
        this.tamanhoQuarto = tamanhoQuarto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcomodacaoOutputDTO that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AcomodacaoOutputDTO{" +
                "id=" + id +
                ", nomeAcomodacao='" + nomeAcomodacao + '\'' +
                '}';
    }
}
