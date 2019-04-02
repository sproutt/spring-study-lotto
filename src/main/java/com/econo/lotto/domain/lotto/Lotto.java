package com.econo.lotto.domain.lotto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
public class Lotto {
    private List<LottoNumber> LottoNumbers;

    public Lotto(int[] numbers) {
        this.LottoNumbers = Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    public Lotto(List<LottoNumber> numbers) {
        this.LottoNumbers = numbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        if (LottoNumbers.contains(lottoNumber)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String middle = LottoNumbers.stream().map(lottoNumber -> Integer.toString(lottoNumber.getLottoNumber())).collect(Collectors.joining(", "));
        return stringBuilder.append(middle).append("]").toString();
    }

}
