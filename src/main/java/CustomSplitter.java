public class CustomSplitter implements Spliter {

    @Override
    public String[] split(String expression) {
        return new String[0];
    }

    @Override
    public boolean support(String expression) {
        return false;
    }
}
