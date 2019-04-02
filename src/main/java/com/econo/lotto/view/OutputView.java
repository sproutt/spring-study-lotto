package com.econo.lotto.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputView {
    private static final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void printLottoNumber(int lottoNumber) throws IOException {
        bufferedWriter.write("" + lottoNumber);
        bufferedWriter.write("개를 구매했습니다.\n");
        bufferedWriter.flush();
    }

    public static void printLottos(String lottosPrintFormat) throws IOException {
        bufferedWriter.write(lottosPrintFormat);
        bufferedWriter.flush();
    }

    public static void printResults(String[] results) throws IOException {
        printResult(results[0]);
        printProfit(results[1]);
    }

    public static void printResult(String result) throws IOException {
        bufferedWriter.write("\n당첨 통계\n---------\n");
        String[] results = result.split(",");

        for (String winInformation : results) {
            String[] winInformations = winInformation.split(" ");
            bufferedWriter.write(String.format("%s개 일치 (%s원)- %s\n", winInformations));
        }
        bufferedWriter.flush();
    }

    public static void printProfit(String profit) throws IOException {
        bufferedWriter.write("총 수익률은 ");
        bufferedWriter.write(profit);
        bufferedWriter.write("%입니다.");
        bufferedWriter.flush();
    }
}
