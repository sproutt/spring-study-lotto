package model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNoTest {

    @Test
    public void getNumberTest(){
        assertThat(new LottoNo(1).getStringNumber()).isEqualTo("1");
        assertThat(new LottoNo(2).getStringNumber()).isEqualTo("2");
        assertThat(new LottoNo(3).getStringNumber()).isEqualTo("3");
        assertThat(new LottoNo(4).getStringNumber()).isEqualTo("4");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void 로또번호_범위밖(){
        new LottoNo(66);
    }
}