package lotto.utils;

import lotto.domain.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    public static List<LottoNo> sort(List<LottoNo> lottoNos) {
        List<Integer> list = new ArrayList<>();
        lottoNos.stream().forEach(lottoNo -> list.add(lottoNo.getNumber()));
        List<LottoNo> lottoNoList = new ArrayList<>();
        Collections.sort(list);
        list.stream().forEach(number -> lottoNoList.add(new LottoNo(number)));
        return lottoNoList;
    }
}
