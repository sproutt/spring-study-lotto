package lotto.domain;

import lotto.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private final static int[] WINNER_REWARDS = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> purchase(int money) {
        for (int numbers = 0; numbers < Utils.changeUnit(money); numbers++) {
            Lotto lotto = new Lotto(Utils.sortNumber(generateRandomNumbers()));
            lottos.add(lotto);
        }
        return lottos;
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<Integer>();
        for (int number = 1; number <= 45; number++) {
            randomNumbers.add(number);
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, 6);
    }

    public int[] saveLottoResult(String text) {
        List<Integer> winnerNumber = Utils.splitNumber(text);
        int[] result = new int[7];
        for (int index = 0; index < lottos.size(); index++) {
            result[countMatch(winnerNumber, index)]++;
        }
        return result;
    }

    public int countMatch(List<Integer> winnerNumber, int index) {
        int count = 0;
        for (int number : winnerNumber) {
            count = increseCount(number, index, count);
        }
        return count;
    }

    public int increseCount(int number, int index, int count) {
        if (lottos.get(index).isContain(number)) {
            return ++count;
        }
        return count;
    }

    public double calculateRate(int[] result, int outcome) {
        int income = calculateReward(result);
        return Math.round(income / outcome * 10.0) * 10.0;
    }

    public int calculateReward(int[] result) {
        int total = 0;
        for (int index = 0; index < result.length; index++) {
            total += result[index] * WINNER_REWARDS[index];
        }
        return total;
    }
}
