package com.econo.lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LottoTest {

    private Lotto lotto;

    public LottoTest(){
        lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    public void containsTest() {
        assertThat(lotto.contains(1), is(true));
    }

    @Test
    public void toStringTest(){
        assertThat(lotto.toString(), is("[1, 2, 3, 4, 5, 6]"));
    }
}