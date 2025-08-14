package br.com.bthirtyeight.controllers;

import br.com.bthirtyeight.model.Person;
import br.com.bthirtyeight.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired//injeta a instancia do service(da um new)
    private PersonServices services;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,//Define que esse método a requisições HTTP do tipo GET
            produces = MediaType.APPLICATION_JSON_VALUE//Diz que o tipo de resposta gerado por esse endpoint será JSON
    )
    public Person findById(@PathVariable("id") String id) {
           return services.findById(id);
    }


    @RequestMapping(//quando nao tiver o parametro value sera para pega toda a lista json(default)
            method = RequestMethod.GET,//Define que esse método a requisições HTTP do tipo GET
            produces = MediaType.APPLICATION_JSON_VALUE//Diz que o tipo de resposta gerado por esse endpoint será JSON
    )
    public List<Person> findAll() {
        return services.findAll();
    }


}
