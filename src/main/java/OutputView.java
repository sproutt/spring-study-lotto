import java.util.Map;

public class OutputView {

    private static final String LOTTO_PURCHASE_COMPLETE_MESSAGE= "%d개를 구매했습니다.";
    private static final String RESULT_STATISTICS_MESSAGE = "당첨 통계";
    private static final String BOUNDARY_LINE = "---------";
    private static final String TOTAL_EARNING_RATIO_MESSAGE = "총 수익률은 %s 입니다.";
    private static final int SECOND_RANK_COUNT = 5;
    private static final int MINIMUM_PRIZE_COUNT = 3;

    public static void printLottoCount(int lottoCount) {
        System.out.printf((LOTTO_PURCHASE_COMPLETE_MESSAGE) + "%n", lottoCount);
    }

    public static void printLottoTicket(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            System.out.println(lotto);
        }
    }

    public static void printStatistics(Map<Rank, Integer> statistics) {
        System.out.println(RESULT_STATISTICS_MESSAGE);
        System.out.println(BOUNDARY_LINE);

        for (Rank rank : statistics.keySet()) {
            printResult(rank, statistics);
        }
    }

    public static void printEarningRate(String earningRate) {
        System.out.printf((TOTAL_EARNING_RATIO_MESSAGE) + "%n", earningRate);
    }

    private static void printResult(Rank rank, Map<Rank, Integer> statistics) {
        if (validateMatchCountIs5(rank)) {
            System.out.print(String.format("%d 개 일치, 보너스 볼 일치 (%d원)", rank.getMatchCount(), rank.getReward()));
            System.out.println(" - " + statistics.get(rank) + "개");
        } else if (validateMatchCountOver3(rank)) {
            System.out.print(String.format("%d 개 일치 (%d원)", rank.getMatchCount(), rank.getReward()));
            System.out.println(" - " + statistics.get(rank) + "개");
        }
    }

    private static boolean validateMatchCountIs5(Rank rank) {
        return rank.getMatchCount() == SECOND_RANK_COUNT && rank.isBonusMatch();
    }

    private static boolean validateMatchCountOver3(Rank rank) {
        return rank.getMatchCount() >= MINIMUM_PRIZE_COUNT;
    }
}