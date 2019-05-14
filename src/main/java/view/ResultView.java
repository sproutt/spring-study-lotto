package view;

import model.StringAddCalculator;

import java.util.Arrays;
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

    public static void lottoResultView(int[] statistic) {
        System.out.println("당첨 통계\n---------------------------");
        lottoStatisticView(statistic);
        lottoPercentView(statistic);
    }

    public static void lottoStatisticView(int[] statistic) {
        int[] winnerMoney = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
        for (int i = 0; i < winnerMoney.length; i++) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", i, winnerMoney[i], statistic[i]);
        }
    }

    public static void lottoPercentView(int[] statistic) {
        int count = 0;
        for (int i = 3; i < statistic.length; i++) {
            count += statistic[i];
        }
        System.out.println("총 수익률은 " + (float) count / Arrays.stream(statistic).sum() + "% 입니다.");
    }
}
