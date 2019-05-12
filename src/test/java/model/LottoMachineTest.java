package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoMachineTest {

    LottoMachine lottoMachine;
    private int lottoCount = 7;

    @Before
    public void setUp(){
        lottoMachine = new LottoMachine();
    }
    @Test
    public void 로또_개수(){
        lottoMachine.buyLottos(lottoCount);
        assertEquals(lottoCount, lottoMachine.showLottos().size());
    }

    @Test
    public void 로또_통계총합(){
        int[] st = lottoMachine.getStatisics(Arrays.asList(new Integer[]{1,2,3}));
        assertEquals(7, Arrays.stream(st).sum());
    }

    @Test
    public void 로또_당첨자없는_통계(){
        int[] st = lottoMachine.getStatisics(Arrays.asList(new Integer[]{-1}));
        assertEquals(7, st[0]);
    }

    @Test
    public void 로또_구매(){
        int beforeLottoCount = lottoMachine.showLottos().size();
        lottoMachine.buyLottos(lottoCount);
        assertEquals(beforeLottoCount+lottoCount, lottoMachine.showLottos().size());
    }
}