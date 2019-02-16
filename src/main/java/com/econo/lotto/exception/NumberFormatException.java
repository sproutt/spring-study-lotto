package com.econo.lotto.exception;

public class NumberFormatException extends RuntimeException {

    public NumberFormatException(String errorString) {
        super("숫자 형식오류 : " + errorString);
    }
}
