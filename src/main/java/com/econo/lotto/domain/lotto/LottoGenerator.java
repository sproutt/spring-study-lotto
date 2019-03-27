package com.econo.lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static com.econo.lotto.domain.lotto.LottoNumber.LOTTO_MAX;

public class LottoGenerator {
    public static final int LOTTO_COUNT = 6;

    private static List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.range(1, LOTTO_MAX + 1).forEach(number -> lottoNumbers.add(new LottoNumber(number)));
    }

    public static Lotto getLotto() {
        List<LottoNumber> lotto = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        IntStream.range(0, LOTTO_COUNT).forEach(i -> lotto.add(lottoNumbers.get(i)));
        return new Lotto(lotto);
    }
}
