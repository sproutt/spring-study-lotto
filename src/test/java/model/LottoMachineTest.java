package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    LottoMachine lottoMachine;
    private int totalLottoPrice = 14000;

    @Before
    public void setUp(){
        lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(totalLottoPrice);
    }
    @Test
    public void 로또_개수(){
        assertThat(lottoMachine.buyLotto(totalLottoPrice).size()).isEqualTo(14);
    }

    @Test
    public void 로또_통계총합(){
        int[] statistic = lottoMachine.getStatistic("1, 2, 3");
        assertThat(Arrays.stream(statistic).sum()).isEqualTo(14);
    }

    @Test
    public void 로또_당첨자없는_통계(){
        int[] statistic = lottoMachine.getStatistic("-1");
        assertThat(statistic[0]).isEqualTo(14);
    }

    @Test
    public void 로또_구매후개수(){
        int firstBuyCount = lottoMachine.buyLotto(totalLottoPrice).size();
        assertThat(lottoMachine.buyLotto(totalLottoPrice).size()).isNotEqualTo(firstBuyCount);
    }
//
//    @Test
//    public void 로또_구매개수(){
//        int beforeLottoCount = lottoMachine.showLottoHistory().size();
//        lottoMachine.buyLotto(totalLottoPrice);
//        assertThat(beforeLottoCount-lottoMachine.showLottoHistory().size()).isNotEqualTo(14);
//    }
}