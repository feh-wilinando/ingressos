package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

/**
 * Created by matheusbrandino on 5/3/17.
 */
public interface Desconto {

    BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal);

}
