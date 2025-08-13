package br.com.bthirtyeight.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//colocando o resquestMapping aqui vc torna a url em path varialbe(usada para transportar variaveis)
@RequestMapping("/math")//-> define um endPoint "superior" para tudo da classe
public class MathController {

    //  /{} -> para definir as variaveis que serao usadas no metodo
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            //pathVariable -> puxa a variavel certa do parametro
            @PathVariable("numberOne") String numerOne,
            @PathVariable("numberTwo") String numerTwo
    ) {
        return 1.0;
    }

}
