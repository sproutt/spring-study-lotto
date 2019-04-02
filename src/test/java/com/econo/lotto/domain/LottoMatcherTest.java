package com.econo.lotto.domain;

import com.econo.lotto.domain.lotto.Lotto;
import com.econo.lotto.domain.lotto.LottoNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LottoMatcherTest {
    private LottoMatcher lottoMatcher;

    public LottoMatcherTest() {
        lottoMatcher = new LottoMatcher();
    }

    @Test
    public void toWinNumberListTest() {
        String winNumbers = "1, 2, 3, 4, 5, 6";

        assertThat(lottoMatcher.toWinNumberList(winNumbers), is(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toList())));
    }

    @Test
    public void getWinCountTest() {
        lottoMatcher.setWinNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(new int[]{1, 2, 33, 45, 3, 41});

        assertThat(lottoMatcher.getWinCount(lotto), is(3));
    }

    @Test
    public void getWinCountsTest() {
        lottoMatcher.setWinNumbers("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 33, 43, 45, 41).stream().map(LottoNumber::new).collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 43, 4, 41).stream().map(LottoNumber::new).collect(Collectors.toList()));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 4, 5, 6, 3, 2).stream().map(LottoNumber::new).collect(Collectors.toList()));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottoMatcher.countMatches(lottos);

        assertThat(lottoMatcher.getWinCounts(lottos), is("0,1,0,1"));
    }

    @Test
    public void getProfitTest() {
        lottoMatcher.setWinNumbers("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 33, 43, 45, 41).stream().map(LottoNumber::new).collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 42, 4, 41).stream().map(LottoNumber::new).collect(Collectors.toList()));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 4, 5, 6, 3, 2).stream().map(LottoNumber::new).collect(Collectors.toList()));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottoMatcher.countMatches(lottos);

        assertThat(String.format("%.0f", lottoMatcher.getTotalProfit()), is("2000500000"));
    }

    @Test
    public void getProfitRateTest() {
        lottoMatcher.setWinNumbers("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 33, 42, 45, 41).stream().map(LottoNumber::new).collect(Collectors.toList()));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 10, 11, 12, 3, 2).stream().map(LottoNumber::new).collect(Collectors.toList()));
        lottos.add(lotto1);
        lottos.add(lotto3);
        lottoMatcher.countMatches(lottos);

        assertThat(lottoMatcher.getProfitRate(lottos), is("250.0"));
    }

    @Test
    public void getResultsTest() {
        lottoMatcher.setWinNumbers("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 33, 42, 45, 41).stream().map(LottoNumber::new).collect(Collectors.toList()));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 10, 11, 12, 3, 2).stream().map(LottoNumber::new).collect(Collectors.toList()));
        lottos.add(lotto1);
        lottos.add(lotto3);
        String[] results = {"1,0,0,0", "250.0"};

        assertThat(lottoMatcher.getResults(lottos), is(results));
    }


}