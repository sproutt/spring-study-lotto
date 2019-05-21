package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    LottoMachine lottoMachine;
    private int totalLottoPrice = 14000;

    @Before
    public void setUp() {
        lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(totalLottoPrice, 3); //buyDirectly
    }

    @Test
    public void 로또_구매후개수() {
        int firstBuyCount = lottoMachine.getRankHistory().size;//가격, 수동구매 개수
        assertThat(lottoMachine.getRankHistory().size).isNotEqualTo(firstBuyCount);
    }

    @Test
    public void 로또_구매개수(){
        int firstBuyCount = lottoMachine.getRankHistory().size;
        assertThat(lottoMachine.getRankHistory().size-firstBuyCount).isEqualTo(14);
    }

    @Test
    public void 로또_랭크개수(){
        assertEquals(14, lottoMachine.getRankHistory().size);
    }
}