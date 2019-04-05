package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator;
    List<LottoNumber> lottoNumbers;

    @Before
    public void setUp() {
        lottoGenerator = new LottoGenerator();
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
    }

    @Test
    public void 수동발권() {
        Lotto lotto = lottoGenerator.manual("1,2,3,4,5,6");
        assertThat(lottoNumbers.get(0).equals(lotto.getLotto().get(0)), is(true));
        assertThat(lottoNumbers.get(1).equals(lotto.getLotto().get(1)), is(true));
        assertThat(lottoNumbers.get(2).equals(lotto.getLotto().get(2)), is(true));
        assertThat(lottoNumbers.get(3).equals(lotto.getLotto().get(3)), is(true));
        assertThat(lottoNumbers.get(4).equals(lotto.getLotto().get(4)), is(true));
        assertThat(lottoNumbers.get(5).equals(lotto.getLotto().get(5)), is(true));
        assertThat(lottoNumbers.get(5).equals(lotto.getLotto().get(4)), is(false));
    }

    @Test
    public void 자동발권() {
        Lotto lotto = lottoGenerator.auto();
        assertThat(lotto.getLotto().size(), is(6));
    }

    @Test
    public void generateRandomNumbers() {
        assertThat(lottoGenerator.generateRandomNumbers().size(), is(6));
    }
}