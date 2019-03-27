package com.econo.lotto.domain;

import com.econo.lotto.domain.lotto.Lotto;
import com.econo.lotto.domain.lotto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LottoGameTest {

    private LottoGame lottoGame;

    public LottoGameTest() {
        lottoGame = new LottoGame();
    }

    @Test
    public void getLottoCountTest() {
        String testExpenditure = "14000";

        Assertions.assertThat(lottoGame.toLottoCount(testExpenditure)).isEqualTo(14);
    }

    @Test
    public void setLottosTest() throws IOException {
        lottoGame.setLottos("3000");
        lottoGame.getLottos().forEach(lotto -> System.out.println(lotto));
    }

    @Test
    public void getLottoPrintFormatTest() {
        Lotto lotto = new Lotto(Arrays.asList(7, 2, 4, 45, 22, 6).stream().map(LottoNumber::new).collect(Collectors.toList()));
        String lottoPrintFormat = "[7, 2, 4, 45, 22, 6]";

        assertThat(lotto.toString(), is(lottoPrintFormat));
    }

}