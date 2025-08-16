package br.com.bthirtyeight.math;

import br.com.bthirtyeight.exception.ResourceNotFoundException;

public class MathUtilities {


    public Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) {
            throw new ResourceNotFoundException("Invalid number");
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

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}
