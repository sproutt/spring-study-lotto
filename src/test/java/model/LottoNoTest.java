package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class LottoNoTest {

    @Test
    public void getNumberTest(){
        assertEquals(1, new LottoNo(1).getNumber());
        assertEquals(2, new LottoNo(2).getNumber());
        assertEquals(3, new LottoNo(3).getNumber());
        assertEquals(4, new LottoNo(4).getNumber());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void 로또번호_범위밖(){
        new LottoNo(66);
    }
}