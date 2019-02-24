package com.econo.lotto.domain;

import com.econo.lotto.utils.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoGameTest {

    private LottoGame lottoGame;

    public LottoGameTest(){
        lottoGame = new LottoGame();

}
    @Test
    public void getLottoCountTest() {
        String testExpenditure ="14000";
        Assertions.assertThat(lottoGame.getLottoCount(testExpenditure)).isEqualTo(14);
    }

    @Test
    public void setLottosTest(){
        lottoGame.setLottos(3);
        lottoGame.getLottos().forEach(lotto-> System.out.println(lotto));
    }
}