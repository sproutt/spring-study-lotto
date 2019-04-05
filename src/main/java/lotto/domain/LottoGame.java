package lotto.domain;

import lotto.utils.Splitter;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    private List<WinningLotto> winningLottos;
    private LottoGenerator lottoGenerator = new LottoGenerator();

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
            lottos.add(new Lotto(lottoGenerator.manual(continuousNumber)));
        }
    }

    public List<Lotto> purchaseAuto(int money, int numberOfManual) {
        for (int numbers = 0; numbers < numberOfAutoLotto(money, numberOfManual); numbers++) {
            lottos.add(new Lotto(lottoGenerator.auto()));
        }
        return lottos;
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

    public int countSameRank(Rank rank) {
        return (int) winningLottos.stream()
                .filter(winningLotto -> winningLotto.findRank().equals(rank))
                .count();
    }

    public double calculateRate(int outcome) {
        return (double) calculatIncome() / outcome * 100.0;
    }

    public int calculatIncome() {
        int income = 0;
        for (WinningLotto winningLotto : winningLottos) {
            income = winningLotto.findRank().plusReward(income);
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