package com.econo.lotto.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(Integer number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
