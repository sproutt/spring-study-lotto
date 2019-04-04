package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoTest {
    Lotto lotto;
    int[] array;
    LottoNumber lottoNumber;
    LottoNumber[] lottoNumbers;
    List<LottoNumber> list;

    @Before
    public void setUp() {
        lottoNumber = new LottoNumber();
        list = new ArrayList<LottoNumber>();
        array = new int[]{1, 2, 3, 4, 5, 6};
        lottoNumbers = new LottoNumber[6];
        for (int index = 0; index < 6; index++) {
            lottoNumbers[index] = new LottoNumber(array[index]);
        }
        list = Arrays.asList(lottoNumbers);
        lotto = new Lotto(list);
    }

    @Test
    public void 로또출력형식() {
        assertThat(lotto.toString(), is("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    public void 포함되어있나() {
        assertThat(lotto.hasThisNumber(new LottoNumber(3)), is(true));
        assertThat(lotto.hasThisNumber(new LottoNumber(7)), is(false));
    }
}