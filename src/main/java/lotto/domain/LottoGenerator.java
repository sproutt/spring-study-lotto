package lotto.domain;

import lotto.utils.Splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    List<LottoNumber> randomNumbers = new ArrayList<>();

    public Lotto manual(String continuousNumber) {
        randomNumbers = Splitter.splitNumber(continuousNumber);
        return new Lotto(randomNumbers);
    }

    public Lotto auto() {
        return new Lotto(generateRandomNumbers());
    }

    public List<LottoNumber> generateRandomNumbers() {
        for (int number = 1; number <= 45; number++) {
            randomNumbers.add(new LottoNumber(number));
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, 6);
    }
}