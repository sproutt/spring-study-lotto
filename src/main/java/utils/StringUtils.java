package utils;

import model.Splitter;
import properties.StringProperties;

import java.util.List;

public class StringUtils {

    private final int FIRSTSPLITTER = 0;
    private final int SECONDSPLITTER = 1;
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

    public String makeSplitString(List<Splitter> splitters) {
        String splitString = splitters.get(FIRSTSPLITTER).getSplitString();
        for (int i = SECONDSPLITTER; i < splitters.size(); i++) {
            splitString += (OR + splitters.get(i).getSplitString());
        }
        return splitString;
    }

    public String[] stringSplitter(String function, List<Splitter> splitters) {
        String splitString = makeSplitString(splitters);
        return function.split(splitString);
    }

    public int parseInt(String string) {
        int number = Integer.parseInt(string);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    public void numberChecker(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void numbersChecker(String[] numbers) {
        for (String number : numbers) {
            numberChecker(number);
        }
    }

}
