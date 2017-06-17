package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.*;
import br.com.caelum.ingresso.rest.ImdbClient;
import br.com.caelum.ingresso.validation.GerenciadorDeSessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by nando on 03/03/17.
 */
@Controller
public class SessaoController {


    @Autowired
    private SalaDao salaDao;

    @Autowired
    private FilmeDao filmeDao;

    @Autowired
    private SessaoDao sessaoDao;

    @Autowired
    private ImdbClient client;

    @Autowired
    private Carrinho carrinho;

    @GetMapping("/sessao")
    public ModelAndView form(@RequestParam("salaId") Integer salaId, SessaoForm form) {
        ModelAndView modelAndView = new ModelAndView("sessao/sessao");

        form.setSalaId(salaId);

        modelAndView.addObject("sala", salaDao.findOne(salaId));
        modelAndView.addObject("filmes", filmeDao.findAll());
        modelAndView.addObject("form", form);


        return modelAndView;
    }


    @PostMapping("/sessao")
    @Transactional
    public ModelAndView salva(@Valid SessaoForm form, BindingResult result) {

        if (result.hasErrors()) return form(form.getSalaId(), form);


        Sessao sessao = form.toSessao(salaDao, filmeDao);

        List<Sessao> sessoesDaSala = sessaoDao.buscaSessoesDaSala(sessao.getSala());

        GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoesDaSala);

        if (gerenciador.cabe(sessao)) {
            sessaoDao.save(sessao);
            return new ModelAndView("redirect:/sala/" + form.getSalaId() + "/sessoes");
        }

        return form(form.getSalaId(), form);
    }



    @GetMapping("/sessao/{id}/lugares")
    public ModelAndView lugaresNaSessao(@PathVariable("id") Integer sessaoId){
        ModelAndView modelAndView = new ModelAndView("sessao/lugares");

        Sessao sessao = sessaoDao.findOne(sessaoId);
        Optional<ImagemCapa> imagemCapa = client.request(sessao.getFilme(), ImagemCapa.class);

        System.out.println(sessao.getMapaDeLugares());

        modelAndView.addObject("sessao", sessao);
        modelAndView.addObject("carrinho", carrinho);
        modelAndView.addObject("imagemCapa", imagemCapa.orElse(new ImagemCapa()));
        modelAndView.addObject("tiposDeIngressos", TipoDeIngresso.values());

        return modelAndView;
    }

}
