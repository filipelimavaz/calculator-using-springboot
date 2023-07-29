package br.com.dcx.controllers;

import br.com.dcx.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @RequestMapping(value="/soma/{num1}/{num2}", method=RequestMethod.GET)
    public Double soma(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsupportedMathOperationException("Por favor. Insira apenas valores numéricos");
        }
        return covertToDouble(num1) + covertToDouble(num2);
    }

    @RequestMapping(value="/subtracao/{num1}/{num2}", method=RequestMethod.GET)
    public Double subtracao(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsupportedMathOperationException("Por favor. Insira apenas valores numéricos");
        }
        return covertToDouble(num1) - covertToDouble(num2);
    }

    @RequestMapping(value="/divisao/{num1}/{num2}", method=RequestMethod.GET)
    public Double divisao(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsupportedMathOperationException("Por favor. Insira apenas valores numéricos");
        }

        if(covertToDouble(num2) == 0) {
            throw new UnsupportedMathOperationException("Não existe divisão por zero");
        }

        return covertToDouble(num1) + covertToDouble(num2);
    }

    @RequestMapping(value="/media/{num1}/{num2}", method=RequestMethod.GET)
    public Double media(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsupportedMathOperationException("Por favor. Insira apenas valores numéricos");
        }

        return (covertToDouble(num1) + covertToDouble(num2)) / 2;
    }

    @RequestMapping(value="/raizQuadrada/{num1}", method=RequestMethod.GET)
    public Double raizQuadrada(@PathVariable("num1") String num1) throws Exception {
        if (!isNumeric(num1)) {
            throw new UnsupportedMathOperationException("Por favor. Insira apenas valores numéricos");
        }
        return StrictMath.sqrt(covertToDouble(num1));
    }

    @RequestMapping(value="/multiplicacao/{num1}/{num2}", method=RequestMethod.GET)
    public Double multiplicacao(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsupportedMathOperationException("Por favor. Insira apenas valores numéricos");
        }
        return covertToDouble(num1) * covertToDouble(num2);
    }

    public static Double covertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0d;
        }
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 1.0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
