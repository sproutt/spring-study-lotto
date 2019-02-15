package controller;

import model.Function;
import utils.StringUtils;

public class CalculatorController {

    private initController initController = new initController();
    StringUtils stringUtils = new StringUtils();

    public int add(String functionString) {
        Function function = initController.initFunction(functionString);
        String[] numbers = function.getNumbers();
        for (String number : numbers) {
            function.addNumber(stringUtils.parseInt(number));
        }
        return function.getResult();
    }

}