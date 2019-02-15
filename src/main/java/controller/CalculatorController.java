package controller;

import model.Function;
import utils.StringUtils;

public class CalculatorController {

    private initController initController = new initController();
    StringUtils stringUtils = new StringUtils();
    Function function = new Function();

    private int getResult() {
        return this.function.getResult();
    }

    public void addNumbers() {
        String[] numbers = function.getNumbers();
        for (String number : numbers) {
            function.addNumber(stringUtils.parseInt(number));
        }
    }

    public int add(String function) {
        this.function = initController.initFunction(function);
        addNumbers();
        return getResult();
    }

}