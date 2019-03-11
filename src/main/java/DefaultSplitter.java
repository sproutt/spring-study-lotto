public class DefaultSplitter implements Spliter {

    @Override
    public String[] split(String expression) {
        return expression.split(",|:");
    }

    @Override
    public boolean support(String expression) {
        return false;
    }
}
