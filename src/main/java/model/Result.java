package model;

public class Result {

    private int result;
    private boolean resultZero;

    final int ZERO = 0;

    public Result() {
        this.result = 0;
        this.resultZero = false;
    }

    public int getResult() {
        return result;
    }

    public void addResult(int number) {
        if (number < ZERO) {
            makeZero();
        }
        if (!resultZero) {
            this.result += number;
        }
    }

    public void makeZero() {
        this.resultZero = true;
        this.result = ZERO;
    }


}
