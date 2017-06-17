package br.com.caelum.ingresso.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by nando on 17/06/17.
 */
public class SalaTest {


    @Test
    public void test(){
        Lugar a1 = new Lugar("A", 1);
        Lugar a2 = new Lugar("A", 2);
        Lugar a3 = new Lugar("A", 3);
        Lugar b1 = new Lugar("B", 1);
        Lugar b2 = new Lugar("B", 2);
        Lugar b3 = new Lugar("B", 3);

        Sala eldorado = new Sala("Eldorado", BigDecimal.TEN);

        eldorado.add(a1);
        eldorado.add(a2);
        eldorado.add(a3);
        eldorado.add(b1);
        eldorado.add(b2);
        eldorado.add(b3);


        Map<String, List<Lugar>> lugares = eldorado.getMapaDeLugares();

        System.out.println(lugares);


    }

}
