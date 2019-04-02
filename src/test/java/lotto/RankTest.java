package lotto;

import lotto.domain.Rank;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RankTest {
    Rank rank;

    @Before
    public void setUp(){
        rank = Rank.SECOND;
    }
    @Test
    public void _2등() {
        assertThat(Rank.setSecond(true), is(Rank.SECOND));
        assertThat(Rank.setSecond(false), is(Rank.THIRD));
    }

    @Test
    public void 문자_변환() {
        assertThat(rank.toString(), is("5개 일치, 보너스 볼 일치(30000000)-"));
    }
}