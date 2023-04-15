package br.com.tex.hotel.model.dto.acomodacao;

import br.com.tex.hotel.model.entitys.Acomodacao;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author willian
 */
public class AcomodacaoInputSalvarDTO {

    private String nomeAcomodacao;
    private BigDecimal valorAdulto;
    private BigDecimal valorCrianca;
    private boolean quartoLivre;
    private BigDecimal tamanhoQuarto;
    private Integer idHotel;

    public AcomodacaoInputSalvarDTO() {
    }

    public AcomodacaoInputSalvarDTO(String nomeAcomodacao, BigDecimal valorAdulto, BigDecimal valorCrianca, boolean quartoLivre, BigDecimal tamanhoQuarto, Integer idHotel) {
        this.nomeAcomodacao = nomeAcomodacao;
        this.valorAdulto = valorAdulto;
        this.valorCrianca = valorCrianca;
        this.quartoLivre = quartoLivre;
        this.tamanhoQuarto = tamanhoQuarto;
        this.idHotel = idHotel;
    }

    public Acomodacao toEntityAcomodacao() {
        return new Acomodacao(this.nomeAcomodacao, this.valorAdulto, this.valorCrianca, this.quartoLivre, this.tamanhoQuarto);
    }


    public String getNomeAcomodacao() {return nomeAcomodacao;}

    public void setNomeAcomodacao(String nomeAcomodacao) {this.nomeAcomodacao = nomeAcomodacao;}

    public BigDecimal getValorAdulto() {return valorAdulto;}

    public void setValorAdulto(BigDecimal valorAdulto) {this.valorAdulto = valorAdulto;}

    public BigDecimal getValorCrianca() {return valorCrianca;}

    public void setValorCrianca(BigDecimal valorCrianca) {this.valorCrianca = valorCrianca;}

    public boolean isQuartoLivre() {return quartoLivre;}

    public void setQuartoLivre(boolean quartoLivre) {this.quartoLivre = quartoLivre;}

    public BigDecimal getTamanhoQuarto() {return tamanhoQuarto;}

    public void setTamanhoQuarto(BigDecimal tamanhoQuarto) {this.tamanhoQuarto = tamanhoQuarto;}

    public Integer getIdHotel() {return idHotel;}

    public void setIdHotel(Integer idHotel) {this.idHotel = idHotel;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcomodacaoInputSalvarDTO that)) return false;
        return Objects.equals(nomeAcomodacao, that.nomeAcomodacao) && Objects.equals(idHotel, that.idHotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeAcomodacao, idHotel);
    }

    @Override
    public String toString() {
        return "AcomodacaoInputDTO{" +
                "nomeAcomodacao='" + nomeAcomodacao + '\'' +
                ", idHotel=" + idHotel +
                '}';
    }
}
