package model;

import util.SplitGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static int LOTTO_NUMBER_RANGE = 45;
    private static int LOTTO_NUMBER_COUNT = 6;
    private static int LOTTO_PRICE = 1000;

    private int tryCount = 0;

    public Lotto getAutoLotto() {
        decreaseCount();
        return new Lotto(getRandomNumbers(getNumbersInRange(LOTTO_NUMBER_RANGE)));
    }

    public void inputMoney(int money) {
        tryCount += money / LOTTO_PRICE;
    }

    public boolean canLotto() {
        return tryCount > 0;
    }

    private void decreaseCount() {
        if (canLotto() == false)
            throw new RuntimeException("돈 넣어!!");
        tryCount--;
    }

    private List<LottoNo> getNumbersInRange(int range) {
        List<LottoNo> numbersInRange = new ArrayList<>();

        for (int i = 1; i <= range; i++)
            numbersInRange.add(new LottoNo(i));

        return numbersInRange;
    }

    private List<LottoNo> getRandomNumbers(List<LottoNo> numbersInRange) {
        Collections.shuffle(numbersInRange);
        return numbersInRange.subList(0, LOTTO_NUMBER_COUNT);
    }

    public Lotto getDirectLotto(String numbers) {
        decreaseCount();
        return new Lotto(SplitGenerator.splitWithSign(numbers, ", "));
    }
}
