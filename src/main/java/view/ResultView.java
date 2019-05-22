package view;

import model.Rank;
import model.Statistic;
import model.StringAddCalculator;

import java.util.HashMap;
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

    public static void lottoResultView(Statistic statistic) {
        System.out.println("당첨 통계\n---------------------------");
        lottoStatisticView(statistic);
        lottoPercentView(statistic);
    }

    public static void lottoStatisticView(Statistic statistic) {
        statistic.getStatistic().forEach((key, value) -> {
            System.out.printf("%d개 일치 (%d원) - %d개\n", key.getCountOfMatch(), key.getWinningMoney(), value);
        });
    }

    public static float lottoPercentView(Statistic statistic) {

        int totalCount = 0;
        for (HashMap.Entry<Rank, Integer> elem : statistic.getStatistic().entrySet())
            totalCount += elem.getValue();

        return (float) (totalCount - statistic.getStatistic().get(Rank.MISS)) / totalCount;
    }
}
