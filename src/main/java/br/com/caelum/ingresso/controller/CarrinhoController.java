package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.model.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nando on 11/05/17.
 */
@Controller
public class CarrinhoController {


    @Autowired
    private Carrinho carrinho;


    @DeleteMapping("/carrinho/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Integer id){
        carrinho.remove(id);
    }
}
