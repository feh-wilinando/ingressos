package br.com.caelum.ingresso.validation;

import br.com.caelum.ingresso.model.Sessao;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by nando on 03/03/17.
 */
public class GerenciadorDeSessao {

    private List<Sessao> sessoesDaSala;
    public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
        this.sessoesDaSala = sessoesDaSala;
    }

    public boolean cabe(Sessao sessaoAtual) {
        Optional<Boolean> optionalCabe = sessoesDaSala
                .stream()
                .map(sessaoExistente -> horarioIsValido(sessaoExistente, sessaoAtual))
                .reduce(Boolean::logicalAnd);

        return optionalCabe.orElse(true);
    }

    private boolean horarioIsValido(Sessao sessaoExistente, Sessao sessaoAtual) {

        LocalTime horarioSessao = sessaoExistente.getHorario();
        LocalTime horarioAtual = sessaoAtual.getHorario();

        boolean ehAntes = horarioAtual.isBefore(horarioSessao);

        if (ehAntes) {

            return horarioAtual.plusMinutes(sessaoAtual.getFilme().getDuracao().toMinutes())
                    .isBefore(sessaoExistente.getHorario());
        } else {

            return sessaoExistente.getHorarioTermino().isBefore(horarioAtual);

        }
    }
}
