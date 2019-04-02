package lotto.domain;

import lotto.utils.Sorter;
import lotto.utils.Splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    private List<WinningLotto> winningLottos;

    public LottoGame() {
        lottos = new ArrayList<Lotto>();
        winningLottos = new ArrayList<WinningLotto>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<WinningLotto> getWinningLottos() {
        return winningLottos;
    }

    public void purchaseMenual(String[] texts) {
        for (String text : texts) {
            List<LottoNo> contrivedNumber = Splitter.splitNumber(text);
            Lotto lotto = new Lotto(Sorter.sort(contrivedNumber));
            lottos.add(lotto);
        }
    }

    public List<Lotto> purchaseAuto(int money, int numberOfManual) {
        for (int numbers = 0; numbers < numberOfAutoLotto(money, numberOfManual); numbers++) {
            List<LottoNo> randomNumber = generateRandomNumbers();
            Lotto lotto = new Lotto(Sorter.sort(randomNumber));
            lottos.add(lotto);
        }
        return lottos;
    }

    public static List<LottoNo> generateRandomNumbers() {
        List<LottoNo> randomNumbers = new ArrayList<LottoNo>();
        for (int number = 1; number <= 45; number++) {
            randomNumbers.add(new LottoNo(number));
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, 6);
    }

    public void setWinningLottos(String winningNumbertext) {
        List<LottoNo> lottoNos = Splitter.splitNumber(winningNumbertext);
        winningLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            setWinningLotto(lotto, countMatch(lotto, lottoNos));
        }
    }

    public void setWinningLotto(Lotto lotto, int count) {
        if (Rank.valueOf(count) != Rank.MISS) {
            winningLottos.add(new WinningLotto(lotto, Rank.valueOf(count)));
        }
    }

    public int countMatch(Lotto lotto, List<LottoNo> winningNumber) {
        int count = 0;
        for (LottoNo lottoNo : winningNumber) {
            count = increaseCount(lotto, lottoNo, count);
        }
        return count;
    }

    public int increaseCount(Lotto lotto, LottoNo lottoNo, int count) {
        if (lotto.isContain(lottoNo)) {
            count++;
        }
        return count;
    }

    public void correctBonus(int bonusNumber) {
        winningLottos.stream()
                .filter(winningLotto ->
                        winningLotto.getReward() == Rank.SECOND.getWinningMoney())
                .forEach(winningLotto ->
                        winningLotto.setRank(Rank.setSecond(winningLotto.isContain(new LottoNo(bonusNumber)))));
    }

    public int countSameRank(Rank rank) {
        return (int) winningLottos.stream().filter(winningLotto -> winningLotto.isSameRank(rank)).count();
    }

    public double calculateRate(int outcome) {
        return (double) calculatIncome() / outcome * 100.0;
    }

    public int calculatIncome() {
        int income = 0;
        for (WinningLotto winningLotto : winningLottos) {
            income += winningLotto.getReward();
        }
        return income;
    }

    public int changeUnit(int totalPrice) {
        return totalPrice / 1000;
    }

    public int numberOfAutoLotto(int money, int numberOfManual) {
        return changeUnit(money) - numberOfManual;
    }
}