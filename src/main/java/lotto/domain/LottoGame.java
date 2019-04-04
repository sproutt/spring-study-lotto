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

    public void purchaseManual(String[] continuousNumbers) {
        for (String continuousNumber : continuousNumbers) {
            List<LottoNumber> numberSplit = Splitter.splitNumber(continuousNumber);
            lottos.add(new Lotto(Sorter.sort(numberSplit)));
        }
    }

    public List<Lotto> purchaseAuto(int money, int numberOfManual) {
        for (int numbers = 0; numbers < numberOfAutoLotto(money, numberOfManual); numbers++) {
            List<LottoNumber> randomNumber = generateRandomNumbers();
            Lotto lotto = new Lotto(Sorter.sort(randomNumber));
            lottos.add(lotto);
        }
        return lottos;
    }

    public static List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> randomNumbers = new ArrayList<LottoNumber>();
        for (int number = 1; number <= 45; number++) {
            randomNumbers.add(new LottoNumber(number));
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, 6);
    }

    public void setWinningLottos(String winningNumbertext, LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumbers = Splitter.splitNumber(winningNumbertext);
        winningLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            setWinningLotto(lotto, lotto.countMatch(lottoNumbers), bonusNumber);
        }
    }

    public void setWinningLotto(Lotto lotto, int count, LottoNumber bonusNumber) {
        if (Rank.lookUpRank(count, lotto.hasThisNumber(bonusNumber)) != Rank.MISS) {
            winningLottos.add(new WinningLotto(lotto, count, bonusNumber));
        }
    }

    public int countSameRank(Rank rank) {
        return (int) winningLottos.stream().filter(winningLotto -> winningLotto.findRank().equals(rank)).count();
    }

    public double calculateRate(int outcome) {
        return (double) calculatIncome() / outcome * 100.0;
    }

    public int calculatIncome() {
        int income = 0;
        for (WinningLotto winningLotto : winningLottos) {
            income += winningLotto.findRank().getWinningPrice();
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