package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LottoTest {

    Lotto lotto;

    @Before
    public void setUp(){
        List<Integer> tmpLotto = new ArrayList<>();
        for (int i=1; i<7; i++){
            tmpLotto.add(i);
        }
        lotto = new Lotto(tmpLotto);
    }
    @Test
    public void 로또_정답수(){
        List<Integer> answers = new ArrayList<>();
        answers.add(3); answers.add(5); answers.add(9);
        assertEquals(2, lotto.getCountOk(answers));
    }
}