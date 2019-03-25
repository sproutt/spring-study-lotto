package lotto;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.utils.Utils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTest {
    LottoGame lottoGame;
    Integer[] array;
    List<Integer> list;
    Lotto lotto;
    List<Lotto> lottos;

    @Before
    public void setUp() {
        lottoGame = new LottoGame();
        array = new Integer[]{1,2,3,4,5,6};
        list = Arrays.asList(array);
        lotto = new Lotto(list);
        lottos = new ArrayList<>();
    }

    @Test
    public void 단위변환(){
        assertThat(Utils.changeUnit(14000),is(14));
    }

    @Test
    public void 표구매(){
        lottoGame.purchase(14000);
        List lotto = lottoGame.getLottos();
        assertThat(lotto.size() , is(14));
    }

    @Test
    public void 증가(){
        int count = 0;
        lottos.add(lotto);
        lottoGame.setLottos(lottos);
        assertThat(lottoGame.increseCount(3,0,count),is(1));
    }

    @Test
    public void 몇개나_맞았나(){
        lottos.add(lotto);
        lottoGame.setLottos(lottos);
        assertThat(lottoGame.countMatch(list, 0), is(6));
    }

    @Test
    public void 결과_배열(){
        lottos.add(lotto);
        lottoGame.setLottos(lottos);
        int arr[] = new int[]{0,0,0,0,0,0,1};
        assertArrayEquals(lottoGame.saveLottoResult("1,2,3,4,5,6"),arr);
    }

    @Test
    public void 리스트정렬(){
        Integer[] arr = new Integer[]{6,5,4,3,2,1};
        List<Integer> lists = Arrays.asList(arr);

        assertThat(Utils.sortNumber(lists),is(list));
    }

    @Test
    public void 로또출력형식(){
        lottos.add(lotto);
        lottoGame.setLottos(lottos);
        assertThat(lotto.toString(),is("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    public void 비율계산(){
        int[] result = new int[]{0,0,0,1,0,0,0};
        lottos.add(lotto);
        lottoGame.setLottos(lottos);
        assertThat(lottoGame.calculateRate(result,1000),is(500.0));
    }

    @Test
    public void 상금계산(){
        int[] result = new int[]{0,0,0,1,0,0,0};
        assertThat(lottoGame.calculateReward(result),is(5000));
    }

    @Test
    public void 문자나누기(){
        assertThat(Utils.splitNumber("1,2,3,4,5,6"),is(list));
    }

}
