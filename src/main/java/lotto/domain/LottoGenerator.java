package lotto.domain;

import lotto.utils.Sorter;
import lotto.utils.Splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private List<LottoNumber> randomNumbers;

    public List<LottoNumber> manual(String continuousNumber) {
        randomNumbers = Splitter.splitNumber(continuousNumber);
        return Sorter.sort(randomNumbers);
    }

    public List<LottoNumber> auto() {
        return Sorter.sort(generateRandomNumbers());
    }

    public List<LottoNumber> generateRandomNumbers() {
        for (int number = 1; number <= 45; number++) {
            randomNumbers.add(new LottoNumber(number));
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, 6);
    }
}
