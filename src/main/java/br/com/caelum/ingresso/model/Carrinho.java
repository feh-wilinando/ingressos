package br.com.caelum.ingresso.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matheusbrandino on 5/11/17.
 */
@Component
@SessionScope
public class Carrinho {

    private List<Ingresso> ingressos = new ArrayList<>();

    public void add(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public boolean isSelecionado(Lugar lugar) {
        return ingressos.stream().map(Ingresso::getLugar).anyMatch(l -> l.equals(lugar));
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }
}
