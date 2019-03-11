public class StringAddCalculator {
    Spliter spliter;
    public int add(String expression) {
        if(expression.isEmpty() || expression == null){
            return 0;
        }
        setSpliter(isCustom(expression));
        String[] textNumbers = spliter.split(expression);
        int sum = 0;
        for(String textNumber : textNumbers){
            sum += Integer.parseInt(textNumber);
        }
        return sum;
    }

    public boolean isCustom(String expression){
        if(expression.contains("//")){
            return true;
        }
        return false;
    }

    public void setSpliter(boolean cunstom) {
        if(cunstom){
            spliter = new CustomSplitter();
            return;
        }
        spliter = new DefaultSplitter();
    }
}
