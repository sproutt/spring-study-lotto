package lotto;

import lotto.domain.LottoNo;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoNoTest {
    LottoNo lottoNo;

    @Before
    public void setUp() {
        lottoNo = new LottoNo(3);
    }

    @Test
    public void 같은지() {
        assertThat(lottoNo.equals(new LottoNo(4)), is(false));
        assertThat(lottoNo.equals(new LottoNo(3)), is(true));
    }
}
