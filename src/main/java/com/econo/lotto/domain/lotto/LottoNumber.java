package com.econo.lotto.domain.lotto;

import com.econo.lotto.exception.LottoNumberNotMatchException;
import com.econo.lotto.exception.NagativeNumberException;
import lombok.Getter;

@Getter
public class LottoNumber {
    protected static final int LOTTO_MAX = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber > LOTTO_MAX) {
            throw new LottoNumberNotMatchException(lottoNumber);
        }
        if (lottoNumber < 1) {
            throw new NagativeNumberException(lottoNumber);
        }
        this.lottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object object) {
        LottoNumber lottoNumber = (LottoNumber) object;
        if (this.lottoNumber == lottoNumber.lottoNumber) {
            return true;
        }
        return false;
    }
}
