package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoTest {
    Lotto lotto;
    int[] array;
    LottoNumber lottoNumber;
    LottoNumber[] lottoNumbers;
    List<LottoNumber> list;

    @Before
    public void setUp() {
        lottoNumber = new LottoNumber();
        list = new ArrayList<LottoNumber>();
        array = new int[]{1, 2, 3, 4, 5, 6};
        lottoNumbers = new LottoNumber[6];
        for (int index = 0; index < 6; index++) {
            lottoNumbers[index] = new LottoNumber(array[index]);
        }
        list = Arrays.asList(lottoNumbers);
        lotto = new Lotto(list);
    }

    @Test
    public void 이_로또는_몇_개나_맞았나요(){
        assertThat(lotto.countMatch(list),is(6));
    }

    @Test
    public void 이_번호가_포함되어_있다면_카운트를_1_증가시킵니다(){
        assertThat(lotto.increaseCount(new LottoNumber(3),1),is(2));
    }

    @Test
    public void 이_번호가_포함되어_있나요(){
        assertThat(lotto.hasThisNumber(new LottoNumber(5)),is(true));
        assertThat(lotto.hasThisNumber(new LottoNumber(7)),is(false));
    }
    @Test
    public void 로또를_문자열로_바꿔본다() {
        assertThat(lotto.toString(), is("[1, 2, 3, 4, 5, 6]"));
    }
}