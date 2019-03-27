package com.econo.lotto.domain;

import com.econo.lotto.domain.lotto.Lotto;
import com.econo.lotto.domain.lotto.LottoNumber;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LottoTest {

    private Lotto lotto;

    public LottoTest() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    @Test
    public void containsTest() {
        assertThat(lotto.contains(new LottoNumber(1)), is(true));
    }

    @Test
    public void toStringTest() {
        assertThat(lotto.toString(), is("[1, 2, 3, 4, 5, 6]"));
    }
}