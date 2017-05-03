package br.com.caelum.ingresso.model;

import br.com.caelum.ingresso.model.descontos.Desconto;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

/**
 * Created by matheusbrandino on 5/3/17.
 */
public class Ingresso {

    private Sessao sessao;
    private BigDecimal preco;

    public Ingresso(Sessao sessao, Desconto desconto) {
        this.sessao = sessao;
        this.preco = desconto.aplicarDescontoSobre(sessao.getPreco());
    }

    public Sessao getSessao() {
        return sessao;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
