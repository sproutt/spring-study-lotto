package com.econo.lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMatcher {
    private Lotto winNumbers;
    private int[] winCounts;

    public LottoMatcher() {
        winCounts = new int[7];
    }

    public String[] getResult(List<Lotto> lottos, int expenditure) {
        this.countMatches(lottos);
        String[] results = {this.getWinCounts(lottos), this.getProfitRate(lottos, expenditure)};
        return results;
    }

    public String getProfitRate(List<Lotto> lottos, int expenditure) {
        return String.format("%.1f", lottos.size()/this.getProfit());
    }

    public String getWinCounts(List<Lotto> lottos) {
        return Stream.of(3,4,5,6)
                .map(i -> Integer.toString(winCounts[i]))
                .collect(Collectors.joining(","));
    }

    public void countMatches(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> winCounts[this.getWinCount(lotto)]++);
    }

    public int getWinCount(Lotto lotto) {
        return (int) winNumbers.stream().filter(lotto::contains).count();
    }

    public void setWinNumbers(String readWinNumbers) {
        winNumbers = toWinNumberList(readWinNumbers);
    }

    public Lotto toWinNumberList(String readWinNumbers) {
        return new Lotto(
                Stream.of(readWinNumbers.split(", "))
                        .map(number -> Integer.parseInt(number))
                        .collect(Collectors.toList())
        );
    }


}
