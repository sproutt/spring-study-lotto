import utils.CustomSplitter;
import utils.DefaultSplitter;
import utils.Splitter;

import java.util.Arrays;

public class StringAddCalculator {
    private Splitter splitter;

    public int add(String expression) {
        if (isNull(expression)) {
            return 0;
        }
        selectSplitter(isCustom(expression));
        String[] textNumbers = splitter.split(expression);
        return Arrays.stream(textNumbers)
                .mapToInt(element -> Integer.parseInt(element))
                .sum();
    }

    public boolean isCustom(String expression) {
        return expression.contains("//");
    }

    public void selectSplitter(boolean cunstom) {
        if (cunstom) {
            splitter = new CustomSplitter();
            return;
        }
        splitter = new DefaultSplitter();
    }

    public boolean isNull(String expression) {
        return expression == null || expression.isEmpty();
    }
}
