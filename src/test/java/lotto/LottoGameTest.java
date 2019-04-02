package lotto;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNo;
import lotto.domain.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {
    LottoGame lottoGame;
    int[] numbers;
    LottoNo[] lottoNos;
    Lotto lotto;
    List<Lotto> lottos;

    @Before
    public void setUp() {
        lottos = new ArrayList<>();
        numbers = new int[]{1, 2, 3, 4, 5, 6};
        int index = 0;
        lottoNos = new LottoNo[6];
        for (int number : numbers) {
            lottoNos[index++] = new LottoNo(number);
        }
        lotto = new Lotto(Arrays.asList(lottoNos));
        lottoGame = new LottoGame();
    }

    @Test
    public void 단위변환() {
        assertThat(lottoGame.changeUnit(14000), is(14));
    }

    @Test
    public void 수동구매() {
        String[] text = new String[]{"1,2,3,4,5,6"};
        lottoGame.purchaseMenual(text);
        lottos.add(lotto);
        assertThat(lottoGame.getLottos().size(), is(1));
        assertThat(lottoGame.getLottos().get(0).toString(), is("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    public void 자동구매() {
        lottoGame.purchaseAuto(14000,0);
        List lotto = lottoGame.getLottos();
        assertThat(lotto.size(), is(14));
    }

    @Test
    public void 번호_생성기() {
        assertThat(lottoGame.generateRandomNumbers().size(), is(6));
    }

    @Test
    public void 증가() {
        LottoNo number = new LottoNo(1);
        assertThat(lottoGame.increaseCount(lotto, number, 1), is(2));
    }

    @Test
    public void 몇개나_맞았나() {
        List<LottoNo> winningLotto = new ArrayList<>();
        winningLotto = Arrays.asList(lottoNos);
        assertThat(lottoGame.countMatch(lotto, winningLotto), is(6));
    }

    @Test
    public void 보너스설정() {
        lottoGame.setWinningLotto(lotto, 5);
        lottoGame.correctBonus(1);
        assertThat(lottoGame.getWinningLottos().get(0).getReward(), is(30000000));
    }

    @Test
    public void 몇등이몇개() {
        lottoGame.setWinningLotto(lotto, 5);
        assertThat(lottoGame.countSameRank(Rank.SECOND), is(1));
    }

    @Test
    public void 비율계산() {
        lottoGame.setWinningLotto(lotto, 5);
        assertThat(lottoGame.calculateRate(14000), is((double) 30000000 / 14000 * 100.0));
    }

    @Test
    public void 상금계산() {
        lottoGame.setWinningLotto(lotto, 5);
        assertThat(lottoGame.calculatIncome(), is(30000000));
    }
}
