package com.econo.lotto.domain;

import com.econo.lotto.domain.LottoGame;
import com.econo.lotto.domain.WinType;
import com.econo.lotto.domain.lotto.Lotto;
import com.econo.lotto.domain.lotto.LottoGenerator;
import com.econo.lotto.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMatcher {

    private List<LottoNumber> winNumbers;
    private int[] winCounts;

    public LottoMatcher() {
        winCounts = new int[LottoGenerator.LOTTO_COUNT + 1];
    }

    public String[] getResults(List<Lotto> lottos) {
        this.countMatches(lottos);

        return new String[]{getWinCounts(), getProfitRate(lottos)};
    }

    public String getProfitRate(List<Lotto> lottos) {
        return String.format("%.1f", (this.getTotalProfit() / (lottos.size() * LottoGame.LOTTO_PRICE)) * 100);
    }

    public double getTotalProfit() {
        return IntStream.range(1, winCounts.length).map(matchCount -> WinType.checkWinType(matchCount).getPrize() * winCounts[matchCount]).sum();
    }

    public String getWinCounts() {
        return Arrays.stream(WinType.values())
                .filter(winType -> winType.getPrize()!=0)
                .map(winType -> winType.getMatchCount()+" "+winType.getPrize()+" "+winCounts[winType.getMatchCount()])
                .collect(Collectors.joining(","));
    }

    public void countMatches(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> winCounts[getWinCount(lotto)]++);
    }

    public int getWinCount(Lotto lotto) {
        System.out.println(lotto);
        return (int) winNumbers.stream().filter(winNumber -> lotto.contains(winNumber)).count();
    }

    public void setWinNumbers(String readWinNumbers) {
        this.winNumbers = toWinNumberList(readWinNumbers);
    }

    public List<LottoNumber> toWinNumberList(String readWinNumbers) {
        return Stream.of(readWinNumbers.split(", "))
                .map(number -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }


}
