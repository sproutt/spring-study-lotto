package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public static List<LottoNumber> sort(List<LottoNumber> lottoNumbers) {
        List<Integer> list = new ArrayList<>();
        lottoNumbers.stream().forEach(lottoNo -> list.add(lottoNo.getNumber()));
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        Collections.sort(list);
        list.stream().forEach(number -> lottoNumberList.add(new LottoNumber(number)));
        return lottoNumberList;
    }
}