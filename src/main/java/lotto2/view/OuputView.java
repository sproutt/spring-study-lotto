package lotto2.view;

import lotto2.domain.*;

import java.util.List;

public class OuputView {
    public static void printLottos(List<Lotto> lottos, int numberOfManual) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", numberOfManual, lottos.size() - numberOfManual);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinStats(LottoGame lottoGame) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n당첨통계\n---------\n");
        Rank[] ranks = Rank.values();
        for (int index = ranks.length - 2; index >= 0; index--) {
            stringBuilder.append(ranks[index].toString());
            stringBuilder.append(lottoGame.countSameRank(ranks[index]));
            stringBuilder.append("개\n");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printRate(double rate) {
        System.out.printf("총 수익률은 %.1f%% 입니다.\n", rate);
    }
}
