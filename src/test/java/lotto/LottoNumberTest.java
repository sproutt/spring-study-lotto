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
    public void 이_숫자와_저_숫자가_같습니까() {
        assertThat(lottoNumber.equals(new LottoNumber(4)), is(false));
        assertThat(lottoNumber.equals(new LottoNumber(3)), is(true));
    }

    @Test
    public void 이_숫자를_문자열로_바꿉시다() {
        assertThat(lottoNumber.toString(), is("3"));
    }

    @Test
    public void 이_숫자와_비교_숫자의_차이() {
        assertThat(lottoNumber.compareTo(new LottoNumber(2)), is(1));
    }
}