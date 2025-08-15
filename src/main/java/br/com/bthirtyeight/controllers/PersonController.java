package br.com.bthirtyeight.controllers;

import br.com.bthirtyeight.model.Person;
import br.com.bthirtyeight.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired//injeta a instancia do service(da um new)
    private PersonServices service;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,//Define que esse método a requisições HTTP do tipo GET
            produces = MediaType.APPLICATION_JSON_VALUE//Diz que o tipo de resposta gerado por esse endpoint será JSON
    )
    public Person findById(@PathVariable("id") String id) {
           return service.findById(id);
    }


    @RequestMapping(//quando nao tiver o parametro value sera para pega toda a lista json(default)
            method = RequestMethod.GET,//Define que esse método a requisições HTTP do tipo GET
            produces = MediaType.APPLICATION_JSON_VALUE//Diz que o tipo de resposta gerado por esse endpoint será JSON
    )
    public List<Person> findAll() {
        return service.findAll();
    }

    @RequestMapping(//nao e necessario passar o value,pois o parametro e passado pelo body
            method = RequestMethod.POST,//Define que esse método a requisições HTTP do tipo post
            consumes = MediaType.APPLICATION_JSON_VALUE,//Diz que o tipo de valor que ele vai consumir e um json(nao e necessario mas e bom)
            produces = MediaType.APPLICATION_JSON_VALUE//Diz que o tipo de resposta gerado por esse endpoint será JSON
    )
    public Person create(@RequestBody Person person) {//RequestBody -> usado para url do tipo body
        return service.create(person);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
