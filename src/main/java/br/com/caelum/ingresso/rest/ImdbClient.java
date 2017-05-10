package br.com.caelum.ingresso.rest;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Created by matheusbrandino on 5/10/17.
 */
@Component
public class ImdbClient {

    private Logger logger = Logger.getLogger(ImdbClient.class);

    public Optional<DetalhesDoFilme> request(Filme filme) {

        RestTemplate client = new RestTemplate();

        String titulo = filme.getNome().replace(" ", "+");

        String url = String.format("http://www.omdbapi.com/?t=%s&y=&plot=short&r=json", titulo);

        try {
            DetalhesDoFilme detalhesDoFilme = client.getForObject(url, DetalhesDoFilme.class);
            return Optional.of(detalhesDoFilme);
        } catch (RestClientException e) {
            logger.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}
