package br.com.caelum.ingresso.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by matheusbrandino on 5/2/17.
 */

public class SessaoTest {

    @Test
    public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
        Sala sala = new Sala("Eldorado - IMax", new BigDecimal("22.5"));
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0"));

        BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());

        Sessao sessao = new Sessao(LocalTime.now(), filme, sala);

        assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
    }
}
