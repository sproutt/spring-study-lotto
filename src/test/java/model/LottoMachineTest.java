package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @Before
    public void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    public void 로또_직접주문() {
        lottoMachine.inputMoney(1000);
        assertThat(lottoMachine.getDirectLotto("1, 2, 3, 4, 5, 6").showLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test(expected = RuntimeException.class)
    public void 로또_머니투입없시_직접주문() {
        assertEquals("[1, 2, 3, 4, 5, 6]", lottoMachine.getDirectLotto("1, 2, 3, 4, 5, 6").showLotto());
    }
}