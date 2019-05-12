package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoMachineTest {

    LottoMachine lottoMachine;
    private int totalLottoPrice = 14000;

    @Before
    public void setUp(){
        lottoMachine = new LottoMachine();
    }
    @Test
    public void 로또_개수(){
        lottoMachine.buyLottos(totalLottoPrice);
        assertEquals(totalLottoPrice, lottoMachine.showLottoHistory().size());
    }

    @Test
    public void 로또_통계총합(){
        lottoMachine.buyLottos(totalLottoPrice);
        int[] st = lottoMachine.getStatistic(Arrays.asList(new Integer[]{1,2,3}));
        assertEquals(7, Arrays.stream(st).sum());
    }

    @Test
    public void 로또_당첨자없는_통계(){
        lottoMachine = new LottoMachine();
        lottoMachine.buyLottos(totalLottoPrice);
        int[] st = lottoMachine.getStatistic(Arrays.asList(new Integer[]{-1}));
        assertEquals(7, st[0]);
    }

    @Test
    public void 로또_구매(){
        int beforeLottoCount = lottoMachine.showLottoHistory().size();
        lottoMachine.buyLottos(totalLottoPrice);
        assertEquals(beforeLottoCount+ totalLottoPrice, lottoMachine.showLottoHistory().size());
    }

    @Test
    public void 로또_구매개수(){
        lottoMachine.buyLottos(totalLottoPrice);
        assertEquals(14, lottoMachine.showLottoHistory().size());
    }
}