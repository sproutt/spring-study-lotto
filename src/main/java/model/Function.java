package model;

import java.util.ArrayList;
import java.util.List;

public class Function {

    final char FIRSTSPLITER = ':';
    final char SECONDSPLITER = ',';
    private String functionString = new String();
    private List<Splitter> splitters = new ArrayList<Splitter>();
    private String[] numbers;
    private int result = 0;

    public Function() {
        splitters.add(new Splitter(FIRSTSPLITER));
        splitters.add(new Splitter(SECONDSPLITER));
    }

    public void addSplitters(Splitter splitter) {
        splitters.add(splitter);
    }

    public String getFunctionString() {
        return functionString;
    }

    public void setFunctionString(String functionString) {
        this.functionString = functionString;
    }

    public List<Splitter> getSplitters() {
        return splitters;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public void setNumbers(String[] numbers) {
        this.numbers = numbers;
    }

    public int getResult() {
        return result;
    }

    public void addNumber(int number) {
        result += number;
    }

}
