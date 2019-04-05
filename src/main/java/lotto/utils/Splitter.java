package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
    public static List<LottoNumber> splitNumber(String texts) {
        List<LottoNumber> splitedNumber = new ArrayList<LottoNumber>();
        for (String text : texts.split(",")) {
            text = text.trim();
            int number = Integer.parseInt(text);
            splitedNumber.add(new LottoNumber(number));
        }
        return splitedNumber;
    }
}