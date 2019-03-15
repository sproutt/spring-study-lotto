package com.econo.lotto.domain;

import com.econo.lotto.utils.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMatcher {
    private static final int[] rewards = {0, 0, 0, 5000, 500000, 1500000, 2000000000};

    private List<Integer> winNumbers;
    private int[] winCounts;

    public LottoMatcher() {
        winCounts = new int[LottoGenerator.LOTTO_COUNT + 1];
    }

    public String[] getResults(List<Lotto> lottos) {
        this.countMatches(lottos);
        String[] results = {this.getWinCounts(lottos), this.getProfitRate(lottos)};

        return results;
    }

    public String getProfitRate(List<Lotto> lottos) {
        return String.format("%.1f", (this.getProfit() / (lottos.size() * LottoGame.LOTTO_PRICE)) * 100);
    }

    public double getProfit() {
        return IntStream.range(0, 7).map(number -> rewards[number] * winCounts[number]).sum();
    }

    public String getWinCounts(List<Lotto> lottos) {
        return Stream.of(3, 4, 5, 6)
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
        this.winNumbers = toWinNumberList(readWinNumbers);
    }

    public List<Integer> toWinNumberList(String readWinNumbers) {
        return Stream.of(readWinNumbers.split(", "))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }


}
