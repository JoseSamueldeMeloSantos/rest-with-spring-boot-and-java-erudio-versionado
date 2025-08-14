package br.com.bthirtyeight.controllers;

import br.com.bthirtyeight.exception.UnsupportedMathOperationException;
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
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number");
        }


        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Invalid number");
        }
        String number = strNumber.replaceAll(",",".");

        return Double.parseDouble(number);
    }

    public boolean isNumeric(String strNumber) {

        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        String number =  strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
