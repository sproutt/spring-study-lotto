package view;

import model.StringAddCalculator;

import java.util.List;

public class ResultView {
    public static void resultView(StringAddCalculator stringAddCalculator, String expression) {
        System.out.println(stringAddCalculator.calculate(expression));
    }

    public static void lottoHistoryView(List<String> lottoHistory) {
        System.out.println(lottoHistory.size() + "개 구매하였습니다.");
        for (String lotto : lottoHistory) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void lottoStatisticView(int[] statistic) {
        int[] winnerMoney = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
        System.out.println("당첨 통계");
        System.out.println("--------------------");
        for (int i = 0; i < winnerMoney.length; i++) {
            System.out.println(i + "개 일치 (" + winnerMoney[i] + "원)- " + statistic[i] + "개");
        }
    }
}
