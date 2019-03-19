package lotto.view;

import lotto.domain.Lotto;
import lotto.utils.Utils;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private static Lotto lotto = new Lotto();

    public static void printEveryTickets(int numberOfTickets) {
        System.out.printf("%d개를 구매했습니다.\n",numberOfTickets);
        for (int index = 0; index < numberOfTickets; index++) {
            List<Integer> generatedNumber = Utils.generateRandomNumbers();
            lotto.setTickets(index, generatedNumber);
            printTicket(generatedNumber);
        }
    }

    public static void printTicket(List<Integer> generatedNumber) {
        Collections.sort(generatedNumber);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int number : generatedNumber) {
            stringBuilder.append(number).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("]");
        System.out.println(stringBuilder.toString());
    }

    public static void printResult(List<Integer> winnerNumber) {
        List<Integer> countedNumber = lotto.count(winnerNumber);
        double EarningsRate = lotto.seekEarningsRate(
                lotto.seekIncome(countedNumber));
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + countedNumber.stream().filter(n -> n == 3).count());
        System.out.println("4개 일치 (50000원)- " + countedNumber.stream().filter(n -> n == 4).count());
        System.out.println("5개 일치 (1500000원)- " + countedNumber.stream().filter(n -> n == 5).count());
        System.out.println("6개 일치 (2000000000원)- " + countedNumber.stream().filter(n -> n == 6).count());
        System.out.printf("촐 수익률은 %.1f%% 입니다.", EarningsRate);
    }
}
