package util;

public class SplitGenerator {
    public static String[] splitWithSign(String expression, String sign) {
        return expression.split(sign);
    }
}
