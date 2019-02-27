package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final String CUSTOMCHECKER = "//(.)\n(.*)";
    private final String DEFAULTSPLITTER = ",|:";

    private int result;

    private boolean isNull(String input) {
        if(input == null){
            return true;
        }
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    public String[] splitString(String input) {
        Matcher matcher = Pattern.compile(CUSTOMCHECKER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DEFAULTSPLITTER);
    }

    public int parseInt(String number) {
        int intNumber = Integer.parseInt(number);
        if (intNumber < 0) {
            throw new RuntimeException();
        }
        return intNumber;
    }

    public void addNumbers(String[] numbers) {
        for (String number : numbers) {
            result += parseInt(number);
        }
    }

    public int add(String input) {
        if(isNull(input)){
            return 0;
        }
        addNumbers(splitString(input));
        return this.result;
    }

}
