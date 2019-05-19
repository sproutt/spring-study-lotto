package LottoTDD.controller;


import LottoTDD.model.CalculateLotto;
import LottoTDD.model.MatchLotto;
import LottoTDD.model.SettingLotto;
import LottoTDD.view.InputView;
import LottoTDD.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        SettingLotto settingLotto = new SettingLotto();
        CalculateLotto calculateLotto = new CalculateLotto();
        MatchLotto matchLotto = new MatchLotto();

        int numberOfLottos = calculateLotto.calculateLotto(inputView.InputPurchaseMoney());
        resultView.showLottoNums(numberOfLottos);
        List<List<Integer>> lottoss = settingLotto.lottoGenerator(numberOfLottos);
        resultView.showLottossList(lottoss);

        matchLotto.generateWinnerNum(inputView.InputWinnerNum());
        int[] rankArray = matchLotto.calculateResult(lottoss);
        resultView.showLottoStatistics(rankArray, matchLotto.getPrizeMoney(), calculateLotto.getInputMoney());
    }
}
