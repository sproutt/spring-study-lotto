package com.econo.lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_MAX = 45;
    public static final int LOTTO_COUNT = 6;

    private static List<Integer> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.range(1, LOTTO_MAX + 1).forEach(number -> lottoNumbers.add(number));
    }

    public static List<Integer> getLotto() {
        List<Integer> lotto = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        IntStream.range(0, LOTTO_COUNT).forEach(i -> lotto.add(lottoNumbers.get(i)));

        return lotto;
    }
}
