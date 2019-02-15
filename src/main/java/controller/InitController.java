package controller;

import model.Function;
import model.Splitter;
import properties.StringProperties;
import utils.StringUtils;

public class InitController {

    private final int NULLRESULT = 0;
    private Function function = new Function();
    private StringProperties stringProperties = new StringProperties();
    private StringUtils stringUtils = new StringUtils();

    public void checkNULLString(String function) {
        if (stringUtils.isNULLFunction(function)) {
            System.out.println(NULLRESULT);
            System.exit(0);
        }
    }

    public boolean isCustomSetting(String function) {
        if (function.substring(stringProperties.getCUSTOMCHECKERFIRST(), stringProperties.getCUSTOMCHECKERSECOND()).equals(stringProperties.getCUSTOMCHECKERFRONT())
                && function.substring(stringProperties.getCUSTOMCHECKERTHIRD(), stringProperties.getCUSTOMCHECKERFORTH()).equals(stringProperties.getCUSTOMCHECKERREAR())) {
            return true;
        }
        return false;
    }

    public void settingCustomSplitter() {
        if (isCustomSetting(function.getFunctionString())) {
            String functionString = function.getFunctionString();
            char split = functionString.charAt(stringProperties.getCUSTOMPOSITION());
            function.addSplitters(new Splitter(split));
            functionString = functionString.substring(stringProperties.getCUTPOSITION());
            function.setFunctionString(functionString);
        }
    }

    public void settingNumbers() {
        function.setNumbers(stringUtils.stringSplitter(function.getFunctionString(), function.getSplitters()));
    }

    private void checkNumbers() {
        stringUtils.numbersChecker(function.getNumbers());
    }

    public Function initFunction(String input) {
        checkNULLString(input);
        function.setFunctionString(input);
        settingCustomSplitter();
        settingNumbers();
        checkNumbers();
        return function;
    }

}
