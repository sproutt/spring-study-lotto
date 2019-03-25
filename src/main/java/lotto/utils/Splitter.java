package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Splitter {
    public static List<Integer> splitNumber(String texts) {
        List<Integer> winnerNumbers = new ArrayList<Integer>();
        for (String text : texts.split(",")) {
            winnerNumbers.add(Integer.parseInt(text));
        }
        return winnerNumbers;
    }
}
