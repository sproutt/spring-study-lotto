package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
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
    LottoNo lottoNo;
    LottoNo[] lottoNos;
    List<LottoNo> list;

    @Before
    public void setUp() {
        lottoNo = new LottoNo();
        list = new ArrayList<LottoNo>();
        array = new int[]{1, 2, 3, 4, 5, 6};
        lottoNos = new LottoNo[6];
        for (int index = 0; index < 6; index++) {
            lottoNos[index] = new LottoNo(array[index]);
        }
        list = Arrays.asList(lottoNos);
        lotto = new Lotto(list);
    }

    @Test
    public void 로또출력형식() {
        assertThat(lotto.toString(), is("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    public void 포함되어있나() {
        assertThat(lotto.isContain(new LottoNo(3)), is(true));
        assertThat(lotto.isContain(new LottoNo(7)), is(false));
    }
}