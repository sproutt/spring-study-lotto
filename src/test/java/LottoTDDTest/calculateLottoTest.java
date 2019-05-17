package LottoTDDTest;

import LottoTDD.model.CalculateLotto;
import LottoTDD.model.SettingLotto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculateLottoTest {
    private CalculateLotto calculateLotto;
    private SettingLotto settingLotto;


    @Before
    public void setup() {
        calculateLotto = new CalculateLotto();
        settingLotto = new SettingLotto();
    }

    @Test
    public void 구입금액확인 () {
        assertEquals(14, calculateLotto.calculateLotto(14000));
    }

    public void 랜덤게임생성(){
        assertEquals(64 , settingLotto.settingLotto(14));
    }
}
