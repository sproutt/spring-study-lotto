package model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LottoTest {

    private Lotto lottoTest;

    @Before
    public void setUp() {
        List<LottoNo> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++)
            numbers.add(new LottoNo(i));
        lottoTest = new Lotto(numbers);
    }

    @Test
    public void 로또번호_문자열_list생성자() {
        List<LottoNo> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++)
            numbers.add(new LottoNo(i));

        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.showLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또번호_문자열_String생성자() {
        Lotto lotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
        assertThat(lotto.showLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void isContainTest() {
        assertThat(lottoTest.isContain("1")).isTrue();
        assertThat(lottoTest.isContain("2")).isTrue();
        assertThat(lottoTest.isContain("3")).isTrue();
        assertThat(lottoTest.isContain("4")).isTrue();
        assertThat(lottoTest.isContain("5")).isTrue();
        assertThat(lottoTest.isContain("6")).isTrue();
    }

    @Test
    public void isNotContainTest() {
        assertThat(lottoTest.isContain("11")).isFalse();
        assertThat(lottoTest.isContain("22")).isFalse();
        assertThat(lottoTest.isContain("33")).isFalse();
        assertThat(lottoTest.isContain("44")).isFalse();
        assertThat(lottoTest.isContain("55")).isFalse();
        assertThat(lottoTest.isContain("66")).isFalse();
    }

    @Test
    public void getCorrectCountTest_포함() {
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"1", "2"}))).isEqualTo(2);
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"3", "2"}))).isEqualTo(2);
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"1", "2", "3"}))).isEqualTo(3);
    }

    @Test
    public void getCorrectCountTest_불포함() {
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"8", "9"}))).isEqualTo(0);
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"11", "22"}))).isEqualTo(0);
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"14", "22", "53"}))).isEqualTo(0);
    }

    @Test
    public void getCorrectCountTest_섞어서() {
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"1", "8", "9"}))).isEqualTo(1);
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"2", "3", "11", "22"}))).isEqualTo(2);
        assertThat(lottoTest.getCorrectCount(Arrays.asList(new String[]{"5", "6", "14", "22", "53"}))).isEqualTo(2);
    }
}