package LottoTDDTest;

import LottoTDD.model.CalculateLotto;
import LottoTDD.model.Lotto;
import LottoTDD.model.MatchLotto;
import LottoTDD.model.SettingLotto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculateLottoTest {
    private CalculateLotto calculateLotto;
    private SettingLotto settingLotto;
    private Lotto lotto;
    private MatchLotto matchLotto;
    @Before
    public void setup() {
        calculateLotto = new CalculateLotto();
        settingLotto = new SettingLotto();
        lotto = new Lotto();
        matchLotto = new MatchLotto();
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

    @Test
    public void 당청번호생성확인(){
        assertEquals(6, matchLotto.generateWinnerNum().size());
    }

}
