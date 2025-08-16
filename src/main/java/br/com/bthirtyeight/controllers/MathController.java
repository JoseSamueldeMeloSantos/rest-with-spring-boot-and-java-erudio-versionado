package br.com.bthirtyeight.controllers;

import br.com.bthirtyeight.exception.ResourceNotFoundException;
import br.com.bthirtyeight.math.MathUtilities;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//colocando o resquestMapping aqui vc torna a url em path varialbe(usada para transportar variaveis)
@RequestMapping("/math")//-> define um endPoint "superior" para tudo da classe
public class MathController {

    private final MathUtilities mathUtt = new MathUtilities();

    //  /{} -> para definir as variaveis que serao usadas no metodo
    @RequestMapping("/sum/{numberOne}/{numberTwo}")//define o endpint do metodo especifico
    public Double sum(
            //pathVariable -> puxa a variavel certa do parametro
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!mathUtt.isNumeric(numberOne) || !mathUtt.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid number");
        }
        return mathUtt.sum(
                mathUtt.convertToDouble(numberOne),
                mathUtt.convertToDouble(numberTwo));
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double Subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!mathUtt.isNumeric(numberOne) || !mathUtt.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid number");
        }
        return mathUtt.subtraction(
                mathUtt.convertToDouble(numberOne),
                mathUtt.convertToDouble(numberTwo));
    }

    @RequestMapping("/divison/{numberOne}/{numberTwo}")
    public Double Division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!mathUtt.isNumeric(numberOne) || !mathUtt.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid number");
        }
        return mathUtt.division(
                mathUtt.convertToDouble(numberOne),
                mathUtt.convertToDouble(numberTwo));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double Multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {
        if (!mathUtt.isNumeric(numberOne) || !mathUtt.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid number");
        }
        return mathUtt.multiplication(
                mathUtt.convertToDouble(numberOne),
                mathUtt.convertToDouble(numberTwo));
    }

    @RequestMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) {

        if (!mathUtt.isNumeric(number)) {
            throw new ResourceNotFoundException("Invalid number");
        }
        return mathUtt.squareRoot(
                mathUtt.convertToDouble(number));
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {
        if (!mathUtt.isNumeric(numberOne) || !mathUtt.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Invalid number");
        }
        return mathUtt.mean(
                mathUtt.convertToDouble(numberOne),
                mathUtt.convertToDouble(numberTwo));
    }
}
