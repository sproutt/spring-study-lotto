package model;

import util.SplitGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static int LOTTO_NUMBER_RANGE = 45;
    private static int LOTTO_NUMBER_COUNT = 6;
    private static int LOTTO_PRICE = 1000;
    List<Lotto> lottos = new ArrayList<>();

    public Lotto getAutoLotto(){
        return new Lotto(getRandomNumbers(getNumbersInRange(LOTTO_NUMBER_RANGE)));
    }

    private List<LottoNo> getNumbersInRange(int range){
        List<LottoNo> numbersInRange = new ArrayList<>();
        for (int i=0; i<range; i++){
            numbersInRange.add(new LottoNo(i));
        }
        return numbersInRange;
    }

    private List<LottoNo> getRandomNumbers(List<LottoNo> numbersInRange) {
        Collections.shuffle(numbersInRange);
        return numbersInRange.subList(0, LOTTO_NUMBER_COUNT);
    }

    public Lotto buyDirectLotto(String numbers){
        return new Lotto(SplitGenerator.splitWithSign(numbers, ", "));
    }
}
