package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WinningLottoTest {
    WinningLotto winningLotto;
    int[] numbers;
    LottoNumber[] lottoNumbers;
    Lotto lotto;

    @Before
    public void setUp() {
        numbers = new int[]{1, 2, 3, 4, 5, 6};
        int index = 0;
        lottoNumbers = new LottoNumber[6];
        for (int number : numbers) {
            lottoNumbers[index++] = new LottoNumber(number);
        }
        lotto = new Lotto(Arrays.asList(lottoNumbers));
        winningLotto = new WinningLotto(lotto, 5, new LottoNumber(6));
    }

    @Test
    public void 이_당첨로또는_몇_등당첨인가() {
        assertThat(winningLotto.findRank(), is(Rank.SECOND));
    }
}