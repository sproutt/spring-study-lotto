package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {
    private String symbol;

    @Override
    public String[] split(String expression) {
        Pattern pattern = Pattern.compile("^//(.)\\n(.*)$");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            symbol = matcher.group(1);
            expression = matcher.group(2);
        }
        return selectResult(expression);
    }

    @Override
    public boolean isPossible(String expression) {
        if (expression.matches("^[0-9,|" + symbol + "]*$")) {
            return true;
        }
        return false;
    }

    private String[] selectResult(String expression){
        if (isPossible(expression)) {
            return expression.split(symbol);
        }
        throw new RuntimeException();
    }
}
