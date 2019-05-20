package LottoTDD.view;

import java.util.List;

public class ResultView {
    public void showLottoNums(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public void showLottossList(List<List<Integer>> lottoss) {
        for (List<Integer> lotto : lottoss) {
            showLottoNumberList(lotto);
        }
    }

    private void showLottoNumberList(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print("  " + lotto.get(i));
        }
        System.out.println("  ]");
    }

    public void showLottoStatistics(int[] rankArray, int prizeMoney, int inputMoney) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int i = 3; i < rankArray.length + 3; i++) {
            System.out.print(i + "개 일치  ");
            checkRank(i);
            System.out.println(rankArray[i - 3] + "개");
        }
        double incomeRate = prizeMoney / (double) inputMoney;
        System.out.println("총 수익률은 " + incomeRate + "% 입니다.");
    }

    private void checkRank(int rank) {
        if (rank == 3) {
            System.out.print("(5000원)- ");
        }
        if (rank == 4) {
            System.out.print("(50000원)- ");
        }
        if (rank == 5) {
            System.out.print("(1500000원)- ");
        }
        if (rank == 6) {
            System.out.print("(2000000000원)- ");
        }
    }
}
