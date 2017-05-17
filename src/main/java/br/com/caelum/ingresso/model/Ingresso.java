package br.com.caelum.ingresso.model;

import br.com.caelum.ingresso.model.descontos.Desconto;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by matheusbrandino on 5/3/17.
 */
@Entity
public class Ingresso {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Sessao sessao;

    @ManyToOne
    private Lugar lugar;

    private BigDecimal preco;


    @Enumerated(EnumType.STRING)
    private TipoDeIngresso tipoDeIngresso;

    public Ingresso() {

    }

    public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar) {
        this.sessao = sessao;
        this.lugar = lugar;
        this.tipoDeIngresso = tipoDeIngresso;
        this.preco = tipoDeIngresso.aplicaDesconto(sessao.getPreco());
    }

    public Sessao getSessao() {
        return sessao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public TipoDeIngresso getTipoDeIngresso() {
        return tipoDeIngresso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
        this.tipoDeIngresso = tipoDeIngresso;
    }


    public BigDecimal getPrecoComDesconto() {
        return tipoDeIngresso.aplicaDesconto(preco);
    }

    public BigDecimal getValorDeDesconto() {

        BigDecimal desconto = getPrecoComDesconto();

        return preco.subtract(desconto);
    }
}
