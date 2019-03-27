package lotto;

import lotto.domain.NumberOfHits;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberOfHitsTest {
    NumberOfHits numberOfHits;

    @Test
    public void 상금_존재(){
        assertThat(numberOfHits.ONE.hasReward(), is(false));
    }

    @Test
    public void 문자_변환(){
        assertThat(numberOfHits.ONE.toString(), is("1개 일치 (0)- "));
    }
}
