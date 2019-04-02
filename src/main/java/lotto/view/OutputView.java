package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 입력받았습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printStatistics(int[] result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values())
                .filter(Rank::hasReward)
                .forEach(n -> System.out.println(n.toString()+result[n.ordinal()]+"개"));
    }

    public static void printBenefitRate(double benefitRate) {
        System.out.println(benefitRate);
        System.out.printf("총 수익률은 %.1f%%입니다.", benefitRate);
    }
}
