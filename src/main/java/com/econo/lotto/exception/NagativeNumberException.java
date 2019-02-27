package com.econo.lotto.exception;

public class NagativeNumberException extends RuntimeException {

    public NagativeNumberException(String number) {
        super("에러 : " + number + "음수가 포함되어 있음");
    }

    public NagativeNumberException(int number) {
        super("에러 : " + number + "음수가 포함되어 있음");
    }
}
