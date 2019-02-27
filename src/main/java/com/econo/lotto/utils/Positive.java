package com.econo.lotto.utils;

import com.econo.lotto.exception.NagativeNumberException;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Positive {

    @Getter @Setter
    private int number;

    public Positive(int number) {
        if (number < 0) {
            throw new NagativeNumberException(number);
        }
        this.number = number;
    }

    public Positive(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) {
            throw new NagativeNumberException(number);
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
