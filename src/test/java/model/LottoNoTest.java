package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class LottoNoTest {

    @Test
    public void getNumberTest(){
        assertEquals("1", new LottoNo(1).getStringNumber());
        assertEquals("2", new LottoNo(2).getStringNumber());
        assertEquals("3", new LottoNo(3).getStringNumber());
        assertEquals("4", new LottoNo(4).getStringNumber());
    }
//
//    @Test(expected = java.lang.AssertionError.class)
//    public void 로또번호_범위밖(){
//        new LottoNo(66);
//    }
}