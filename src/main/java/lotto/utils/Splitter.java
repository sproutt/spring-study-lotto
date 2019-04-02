package lotto.utils;

import lotto.domain.LottoNo;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
    public static List<LottoNo> splitNumber(String texts) {
        List<LottoNo> splitedNumber = new ArrayList<LottoNo>();
        for (String text : texts.split(",")) {
            text = text.trim();
            int number = Integer.parseInt(text);
            splitedNumber.add(new LottoNo(number));
        }
        return splitedNumber;
    }
}
