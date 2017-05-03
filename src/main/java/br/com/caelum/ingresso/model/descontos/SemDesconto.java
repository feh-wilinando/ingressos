package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

/**
 * Created by matheusbrandino on 5/3/17.
 */
public class SemDesconto implements Desconto {

    @Override
    public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
        return precoOriginal;
    }
}
