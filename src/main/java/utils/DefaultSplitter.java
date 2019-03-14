package utils;

public class DefaultSplitter implements Splitter {
    @Override
    public String[] split(String expression) {
        if (isPossible(expression)) {
            return expression.split(",|:");
        }
        throw new RuntimeException();
    }

    @Override
    public boolean isPossible(String expression) {
        if (expression.matches("^[0-9,:]*$")) {
            return true;
        }
        return false;
    }
}
