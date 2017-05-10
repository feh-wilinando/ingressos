package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by matheusbrandino on 5/10/17.
 */
public class ImagemCapa {

    @JsonProperty("Poster")
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}