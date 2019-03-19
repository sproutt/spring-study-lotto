package lotto.view;

import lotto.Lotto;
import lotto.Utils;

import java.util.List;

public class OutputView {
    private static Lotto lotto = new Lotto();

    public static void printEveryTickets(int numberOftickets) {
        for (int index = 0; index < numberOftickets; index++) {
            List<Integer> generatedNumber = Utils.generateRandomNumbers();
            lotto.setTickets(index, generatedNumber);
            printTicket(generatedNumber);
        }
    }

    public static void printTicket(List<Integer> generatedNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int number : generatedNumber) {
            stringBuilder.append(number).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("]");
        System.out.println(stringBuilder.toString());
        stringBuilder.setLength(0);
    }

    public static void printResult(List<Integer> winnerNumber) {
        List<Integer> countedNumber = lotto.count(winnerNumber);
        double EarningsRate = lotto.seekEarningsRate(
                lotto.seekIncome(countedNumber));
        System.out.println("3개 일치 (5000원)- " + countedNumber.stream().filter(n -> n == 3).count());
        System.out.println("4개 일치 (50000원)- " + countedNumber.stream().filter(n -> n == 4).count());
        System.out.println("5개 일치 (1500000원)- " + countedNumber.stream().filter(n -> n == 5).count());
        System.out.println("6개 일치 (2000000000원)- " + countedNumber.stream().filter(n -> n == 6).count());
        System.out.printf("촐 수익률은 %.1f%% 입니다.", EarningsRate);
    }
}
