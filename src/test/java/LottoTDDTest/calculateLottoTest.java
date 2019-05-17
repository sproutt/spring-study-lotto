package LottoTDDTest;

import LottoTDD.model.calculateLotto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculateLottoTest {
    private calculateLotto calculateLotto;

    @Before
    public void setup() {
        calculateLotto = new calculateLotto();
    }

    @Test
    public void 구입금액확인 () {
        assertEquals(14, calculateLotto.calculateLotto(14000));
    }
}
