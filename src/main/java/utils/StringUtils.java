package utils;

import model.Splitter;
import properties.StringProperties;

import java.util.List;

public class StringUtils {

    private StringProperties stringProperties = new StringProperties();
    private final String OR = "|";

    public boolean isNULLFunction(String function) {
        if (function == null) {
            return true;
        }
        if (function.equals("")) {
            return true;
        }
        return false;
    }

    public boolean isCustomSetting(String function) {
        if (function.charAt(stringProperties.getCUSTOMSTARTPOSITION()) == stringProperties.getCUSTOMSTARTER() && function.charAt(stringProperties.getCUSTOMFINISHPOSITION()) == stringProperties.getCUSTOMFINISHER()) {
            return true;
        }
        return false;
    }

    public String stringCutter(String function) {
        return function.substring(stringProperties.getFUNCTIONSTARTPOSITION());
    }

    public String makeSplitString(List<Splitter> splitters) {
        String splitString = splitters.get(0).getSplitString();
        for (int i = 1; i < splitters.size(); i++) {
            splitString += (OR + splitters.get(i).getSplitString());
        }
        return splitString;
    }

    public String[] stringSplitter(String function, List<Splitter> splitters) {
        String splitString = makeSplitString(splitters);
        return function.split(splitString);
    }

    public int parseInt(String number) {
        return Integer.parseInt(number);
    }

}
