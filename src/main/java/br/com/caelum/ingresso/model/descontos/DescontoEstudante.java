package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

/**
 * Created by matheusbrandino on 5/3/17.
 */
public class DescontoEstudante implements Desconto {

    private BigDecimal metade = new BigDecimal(2.0);

    @Override
    public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
        return precoOriginal.divide(metade);
    }

    @Override
    public String getDescricao() {
        return "Estudante";
    }
}
