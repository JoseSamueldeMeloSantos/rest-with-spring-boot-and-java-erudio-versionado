package br.com.bthirtyeight.controllers;

import br.com.bthirtyeight.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController//define uma classe como controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //estrutura de um url
    //host/endpoint/parametro=valor
    //http://localhost:8080/gretting?name=Ricardo ->padrao query string
    //http://localhost:8080/math/sum/3/5 ->padrao path(os paramentros fazem parte da url)

    //para que seja reconhecido como metodo exposto por http
    @RequestMapping("/gretting")//para definir o nome do endpoint(apenas no metodo)
    public Greeting greeting (
                        //requisita o parametro da url
                        //  value-> pega o valor do parametro
                        //  defaultValue -> define um valor do parametro padrao caso nao encontre nenhum
                        @RequestParam(value = "name",defaultValue = "World")
                        String name
                             ) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
