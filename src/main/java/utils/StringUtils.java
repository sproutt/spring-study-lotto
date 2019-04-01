package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private final static String CUSTOMCHECKER = "//(.)\n(.*)";
    private final static String DEFAULTSPLITTER = ",|:";
    private final static Pattern pattern = Pattern.compile(CUSTOMCHECKER);

    public static String[] splitString(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DEFAULTSPLITTER);
    }

    public static int parseInt(String number) {
        int intNumber = Integer.parseInt(number);
        if (intNumber < 0) {
            throw new RuntimeException();
        }
        return intNumber;
    }

}
