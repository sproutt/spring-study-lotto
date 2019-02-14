package controller;

import model.Result;

public class CalculatorController {

    private initController initController = new initController();
    private Result result = new Result();

    private int getResult() {
        return this.result.getResult();
    }

    public void addNumbers(String[] numbers) {
        for (String number : numbers) {
            result.addResult(Integer.parseInt(number));
        }
    }

    public int add(String function) {
        addNumbers(initController.initFunction(function));
        return getResult();
    }

}
