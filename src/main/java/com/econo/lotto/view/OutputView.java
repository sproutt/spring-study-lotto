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
        String[] results = result.split(",");
        bufferedWriter.write("\n당첨 통계\n---------\n");
        bufferedWriter.write(new StringBuffer("3개 일치 (5000원)- ")
                .append(results[0])
                .append("개\n").toString());
        bufferedWriter.write(new StringBuffer("4개 일치 (50000원)- ")
                .append(results[1])
                .append("개\n").toString());
        bufferedWriter.write(new StringBuffer("5개 일치 (1500000원)- ")
                .append(results[2])
                .append("개\n").toString());
        bufferedWriter.write(new StringBuffer("6개 일치 (2000000000원)- ")
                .append(results[3])
                .append("개\n").toString());
        bufferedWriter.flush();
    }

    public static void printProfit(String profit) throws IOException {
        bufferedWriter.write("총 수익률은 ");
        bufferedWriter.write(profit);
        bufferedWriter.write("%입니다.");
        bufferedWriter.flush();
    }
}
