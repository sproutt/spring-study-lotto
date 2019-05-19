package LottoTDD.controller;


import LottoTDD.model.*;
import LottoTDD.view.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        SettingLotto settingLotto = new SettingLotto();
        CalculateLotto calculateLotto = new CalculateLotto();

        int numberOfLottos = calculateLotto.calculateLotto(inputView.InputPurchaseMoney());
        resultView.showLottoNums(numberOfLottos);
        List<Lotto> lottoss = settingLotto.settingLotto(numberOfLottos);
        resultView.showLottossList(lottoss);
        MatchLotto matchLotto = new MatchLotto();
        matchLotto.generateWinnerNum(inputView.InputWinnerNum());
        int[] rankArray = matchLotto.calculateResult(lottoss);
        resultView.showLottoStatistics(rankArray, matchLotto.getPrizeMoney(), calculateLotto.getInputMoney());
    }
}
