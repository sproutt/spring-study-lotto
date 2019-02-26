package model;

public class Function {

    private int result;

    public Function() {
        result = 0;
    }

    public int parseInt(String number) {
        int intNumber = Integer.parseInt(number);
        if (intNumber < 0) {
            throw new RuntimeException();
        }
        return intNumber;
    }

    public void addNumbers(String[] numbers) {
        for (String number : numbers) {
            result += parseInt(number);
        }
    }

    public int getResult() {
        return result;
    }

}
