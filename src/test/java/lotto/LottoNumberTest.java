package lotto;

import lotto.domain.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoNumberTest {
    LottoNumber lottoNumber;

    @Before
    public void setUp() {
        lottoNumber = new LottoNumber(3);
    }

    @Test
    public void 같은지() {
        assertThat(lottoNumber.equals(new LottoNumber(4)), is(false));
        assertThat(lottoNumber.equals(new LottoNumber(3)), is(true));
    }
}
