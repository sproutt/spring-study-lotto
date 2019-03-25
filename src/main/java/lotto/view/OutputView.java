package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 입력받았습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printStatistics(int[] result){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개일치 (5000원)-%d개\n",result[3]);
        System.out.printf("4개일치 (50000원)-%d개\n",result[4]);
        System.out.printf("5개일치 (1500000원)-%d개\n",result[5]);
        System.out.printf("6개일치 (2000000000원)-%d개\n",result[6]);
    }

    public static void printBenefitRate(double benefitRate){
        System.out.printf("총 수익률은 %.1f%%입니다.",benefitRate);
    }
}
