package lotto.domain;

import lotto.utils.Splitter;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
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
            LottoGenerator lottoGenerator = new LottoGenerator();
            lottos.add(lottoGenerator.manual(continuousNumber));
        }
    }

    public void setWinningLottos(String continuousWinningNumbers, LottoNumber bonusNumber) {
        List<LottoNumber> winningNumbers = Splitter.splitNumber(continuousWinningNumbers);
        winningLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            setWinningLotto(lotto, lotto.countMatch(winningNumbers), bonusNumber);
        }
    }

    public void setWinningLotto(Lotto lotto, int count, LottoNumber bonusNumber) {
        if (Rank.lookUpRank(count, lotto.hasThisNumber(bonusNumber)) != Rank.MISS) {
            winningLottos.add(new WinningLotto(lotto, count, bonusNumber));
        }
    }

    public List<Lotto> purchaseAuto(int money, int numberOfManual) {
        for (int numbers = 0; numbers < numberOfAutoLotto(money, numberOfManual); numbers++) {
            LottoGenerator lottoGenerator = new LottoGenerator();
            lottos.add(lottoGenerator.auto());
        }
        return lottos;
    }

    public int countSameRank(Rank rank) {
        return (int) winningLottos.stream()
                .filter(winningLotto -> winningLotto.findRank().equals(rank))
                .count();
    }

    public double calculateRate(int outcome) {
        return (double) calculateIncome() / outcome * 100.0;
    }

    public int calculateIncome() {
        int income = 0;
        for (WinningLotto winningLotto : winningLottos) {
            income = winningLotto.findRank().plusReward(income);
        }
        return income;
    }

    public int changeUnit(int totalPrice) {
        return totalPrice / LOTTO_PRICE;
    }

    public int numberOfAutoLotto(int money, int numberOfManual) {
        return changeUnit(money) - numberOfManual;
    }
}