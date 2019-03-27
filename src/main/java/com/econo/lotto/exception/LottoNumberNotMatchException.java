package com.econo.lotto.exception;

public class LottoNumberNotMatchException extends RuntimeException {

    public LottoNumberNotMatchException(int number) {
        super("에러 : " + number + "로또 번호가 될 수 없는 숫자입니다.");
    }
}
