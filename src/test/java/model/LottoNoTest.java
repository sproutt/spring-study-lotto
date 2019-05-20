package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class LottoNoTest {

    LottoNo lottoNo;

    @Before
    public void setUp(){
        lottoNo = new LottoNo(1);
    }

    @Test
    public void getNumberTest(){
        assertEquals(1, lottoNo.getNumber());
        assertEquals(2, new LottoNo(2).getNumber());
        assertEquals(3, new LottoNo(3).getNumber());
        assertEquals(4, new LottoNo(4).getNumber());
    }

    @Test(expected = RuntimeException)
    public void 로또번호_번위밖(){
        new LottoNo(66);
    }
}