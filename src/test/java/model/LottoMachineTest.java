package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @Before
    public void setUp(){
        List<Integer> answers = new ArrayList<>();
        for (int i=1; i<=6; i++){
            answers.add(i);
        }
        lottoMachine = new LottoMachine(answers, 7);
    }
    @Test
    public void 로또_개수(){
        assertEquals(7, lottoMachine.showLottos().size());
    }

    @Test
    public void 로또_통계총합(){
        int count = 0;
        int[] st = lottoMachine.getStatisics();
        for (int i : st)
            count+=i;
        assertEquals(7, count);
    }
}