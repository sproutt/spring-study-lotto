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
    }

    @Test
    public void 로또_자동주문(){

    }

    @Test
    public void 로또_직접주문(){
        assertEquals("[1, 2, 3, 4, 5, 6}", lottoMachine.buyDirectLotto("1, 2, 3, 4, 5, 6").showLotto());
    }
}