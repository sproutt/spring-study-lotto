package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoTest {

    Lotto lotto;

    @Before
    public void setUp(){
        List<Integer> lottoNumbers = Arrays.asList(new Integer[]{1,2,3,4,5,6});
        lotto = new Lotto(lottoNumbers);
    }

    @Test
    public void 로또_정답수(){
        List<Integer> answers = Arrays.asList(new Integer[]{1,2,3});
        assertEquals(3, lotto.getCountOk(answers));
    }

    @Test
    public void 로또번호_문자열(){
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.showLotto());
    }

}