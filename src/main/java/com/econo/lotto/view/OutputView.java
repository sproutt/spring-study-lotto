package com.econo.lotto.view;

import java.io.*;
import java.sql.SQLOutput;

public class OutputView {
    private static final BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void printLottoNumber(int lottoNumber) throws IOException {
        bufferedWriter.write(lottoNumber);
        bufferedWriter.write("개를 구매했습니다.");
        bufferedWriter.flush();
    }
}
