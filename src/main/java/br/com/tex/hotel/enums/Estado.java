package br.com.tex.hotel.enums;

/**
 *
 * @author willian
 *
 */
public enum Estado {

    AMAZONAS("Amazonas", "AM"),
    ALAGOAS("Alagoas", "AL"),
    ACRE("Acre", "AC"),
    AMAPA("Amapá", "AP"),
    BAHIA("Bahia", "BA"),
    PARA("Pará", "PA"),
    MATO_GROSSO("Mato Grosso", "MT"),
    MINAS_GERAIS("Minas Gerais", "MG"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS"),
    GOIAS("Goiás", "GO"),
    MARANHAO("Maranhão", "MA"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS"),
    TOCANTINS("Tocantins", "TO"),
    PIAUI("Piauí", "PI"),
    SAO_PAULO("São Paulo", "SP"),
    RONDONIA("Rondônia", "RO"),
    RORAIMA("Roraima", "RR"),
    PARANA("Paraná", "PR"),
    CEARA("Ceará", "CE"),
    PERNAMBUCO("Pernambuco", "PE"),
    SANTA_CATARINA("Santa Catarina", "SC"),
    PARAIBA("Paraíba", "PB"),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN"),
    ESPIRITO_SANTO("Espírito Santo", "ES"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ"),
    SERGIPE("Sergipe", "SE"),
    DISTRITO_FEDERAL("Distrito Federal", "DF");

    private final String nome;
    private final String sigla;

    Estado(final String nome, final String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    /**
     * Converte a partir do nome do estado, para o respectivo enum.
     *
     * @param nomeUf o nome do estado. Exemplo: "Minas Gearais"
     * @return o enum do esatado
     * @throws IllegalArgumentException caso não ache o enum pelo nome da UF
     */
    public static Estado fromUF(final String nomeUf) {
        for (final Estado uf : Estado.values()) {
            if (uf.nome.equalsIgnoreCase(nomeUf)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(nomeUf);
    }

    /**
     * Converte a partir da Sigla do estado no parâmetro, para o enum do estado.
     *
     * @param sigla do estado. Exemplo: "MG"
     * @return o estado
     * @throws IllegalArgumentException caso a sigla do estado não exista
     */
    public static Estado fromSigla(final String sigla) {
        for (final Estado uf : Estado.values()) {
            if (uf.sigla.equalsIgnoreCase(sigla)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(sigla);
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Estado{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", sigla='").append(sigla).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
