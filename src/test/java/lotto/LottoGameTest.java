package lotto;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {
    LottoGame lottoGame;
    int[] numbers;
    LottoNumber[] lottoNumbers;
    Lotto lotto;
    List<Lotto> lottos;

    @Before
    public void setUp() {
        lottos = new ArrayList<>();
        numbers = new int[]{1, 2, 3, 4, 5, 6};
        int index = 0;
        lottoNumbers = new LottoNumber[6];
        for (int number : numbers) {
            lottoNumbers[index++] = new LottoNumber(number);
        }
        lotto = new Lotto(Arrays.asList(lottoNumbers));
        lottoGame = new LottoGame();
    }

    @Test
    public void 단위변환() {
        assertThat(lottoGame.changeUnit(14000), is(14));
    }

    @Test
    public void 로또_수동구매() {
        String[] text = new String[]{"1,2,3,4,5,6"};
        lottoGame.purchaseManual(text);
        lottos.add(lotto);
        assertThat(lottoGame.getLottos().size(), is(1));
        assertThat(lottoGame.getLottos().get(0).toString(), is("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    public void 로또_자동구매() {
        lottoGame.purchaseAuto(14000, 0);
        List lotto = lottoGame.getLottos();
        assertThat(lotto.size(), is(14));
    }

    @Test
    public void 몇등이몇개인가요() {
        lottoGame.setWinningLotto(lotto, 5, new LottoNumber(6));
        assertThat(lottoGame.countSameRank(Rank.SECOND), is(1));
    }

    @Test
    public void 수익률을_계산() {
        lottoGame.setWinningLotto(lotto, 5, new LottoNumber(6));
        assertThat(lottoGame.calculateRate(14000), is((double) 30000000 / 14000 * 100.0));
    }

    @Test
    public void 총상금을_계산() {
        lottoGame.setWinningLotto(lotto, 5, new LottoNumber(6));
        assertThat(lottoGame.calculateIncome(), is(30000000));
    }
}