package LottoTDDTest;

import LottoTDD.model.CalculateLotto;
import LottoTDD.model.Lotto;
import LottoTDD.model.SettingLotto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculateLottoTest {
    private CalculateLotto calculateLotto;
    private SettingLotto settingLotto;
    private Lotto lotto;
    @Before
    public void setup() {
        calculateLotto = new CalculateLotto();
        settingLotto = new SettingLotto();
        lotto = new Lotto();
    }

    @Test
    public void 구입금액확인 () {
        assertEquals(14, calculateLotto.calculateLotto(14000));
    }

    @Test
    public void 랜덤게임생성(){
        assertEquals(6, lotto.lottoGenerator().size());
    }

    @Test
    public void 로또여러장생성확인(){
        assertEquals(14, settingLotto.settingLotto(14).size());
    }

}
