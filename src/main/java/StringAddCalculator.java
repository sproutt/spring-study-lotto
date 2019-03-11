import utils.CustomSplitter;
import utils.DefaultSplitter;
import utils.Spliter;

import java.util.Arrays;

public class StringAddCalculator {
    Spliter spliter;

    public int add(String expression) {
        if (isNull(expression)) {
            return 0;
        }
        setSpliter(isCustom(expression));
        String[] textNumbers = spliter.split(expression);
        return Arrays.stream(textNumbers)
                .mapToInt(n -> Integer.parseInt(n))
                .sum();
    }

    public boolean isCustom(String expression) {
        return expression.contains("//");
    }

    public void setSpliter(boolean cunstom) {
        if (cunstom) {
            spliter = new CustomSplitter();
            return;
        }
        spliter = new DefaultSplitter();
    }

    public boolean isNull(String expression) {
        return expression == null || expression.isEmpty();
    }
}
