package lotto.domain;

import lotto.utils.Splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> purchase(int money) {
        for (int numbers = 0; numbers < changeUnit(money); numbers++) {
            List<Integer> randomNumber = generateRandomNumbers();
            Collections.sort(randomNumber);
            Lotto lotto = new Lotto(randomNumber);
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
        List<Integer> winnerNumber = Splitter.splitNumber(text);
        int[] result = new int[NumberOfHits.values().length];
        for (int index = 0; index < lottos.size(); index++) {
            result[countMatch(winnerNumber, index)]++;
        }
        return result;
    }

    public int countMatch(List<Integer> winnerNumber, int index) {
        int count = 0;
        for (int number : winnerNumber) {
            count = increaseCount(number, index, count);
        }
        return count;
    }

    public int increaseCount(int number, int index, int count) {
        if (lottos.get(index).isContain(number)) {
            count++;
        }
        return count;
    }

    public double calculateRate(int[] result, int outcome) {
        int income = calculateReward(result);
        return Math.round((double)income / outcome * 1000.0) / 10.0 ;
    }

    public int calculateReward(int[] result) {
        int total = 0;
        for (int index = 0; index < result.length; index++) {
            total += result[index] * NumberOfHits.values()[index].getReward();
        }
        return total;
    }

    public int changeUnit(int totalPrice) {
        return totalPrice / 1000;
    }
}
