package LottoTDDTest;

import LottoTDD.model.Lotto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto();
    }

    @Test
    public void 구입금액확인 () {
        assertEquals(14, lotto.playLotto(14000));
    }
}
