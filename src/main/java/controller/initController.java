package controller;

import model.Result;
import model.Splitter;
import properties.StringProperties;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class initController {

    private final int NULLRESULT = 0;
    private StringProperties stringProperties = new StringProperties();
    private StringUtils stringUtils = new StringUtils();
    private String functionString = new String();

    public void checkNULLString(String function) {
        if (stringUtils.isNULLFunction(function)) {
            System.out.println(NULLRESULT);
            System.exit(0);
        }
    }

    public List<Splitter> settingSplitter(String function) {
        List<Splitter> splitters = new ArrayList<Splitter>();
        if (stringUtils.isCustomSetting(function)) {
            splitters.add(new Splitter(function.charAt(stringProperties.getCUSTOMPOSITION())));
            functionString = stringUtils.stringCutter(function);
        }
        splitters.add(new Splitter(stringProperties.getINITADDERFIRST()));
        splitters.add(new Splitter(stringProperties.getINITADDERSECOND()));
        return splitters;
    }

    public String[] settingNumbers(String function, List<Splitter> splitters) {
        return stringUtils.stringSplitter(function, splitters);
    }

    public String[] initFunction(String function) {
        checkNULLString(function);
        functionString = function;
        List<Splitter> splitters = settingSplitter(function);
        return settingNumbers(functionString, splitters);
    }

}
