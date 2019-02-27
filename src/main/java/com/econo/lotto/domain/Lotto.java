package com.econo.lotto.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    public boolean contains(Integer number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }
}
