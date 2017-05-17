package br.com.caelum.ingresso.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matheusbrandino on 5/17/17.
 */
@Entity
public class Compra {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Ingresso> ingressos = new ArrayList<>();

    /**
     * @deprecated hibernate only
     */
    public Compra() {
    }

    public Compra(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
}