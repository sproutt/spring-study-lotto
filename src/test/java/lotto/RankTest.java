package lotto;

import lotto.domain.Rank;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RankTest {
    Rank rank;

    @Before
    public void setUp() {
        rank = Rank.SECOND;
    }

    @Test
    public void 등수를_매겨보자() {
        assertThat(Rank.lookUpRank(5, true), is(Rank.SECOND));
        assertThat(Rank.lookUpRank(5, false), is(Rank.THIRD));
        assertThat(Rank.lookUpRank(4, true), is(Rank.FOURTH));
        assertThat(Rank.lookUpRank(2, true), is(Rank.MISS));
    }

    @Test
    public void 맞은개수가_서로일치하는가() {
        assertThat(rank.isRightCount(5), is(true));
        assertThat(rank.isRightCount(4), is(false));
    }

    @Test
    public void 상금을_더해주다() {
        assertThat(rank.plusReward(0), is(30000000));
    }

    @Test
    public void 문자_변환() {
        assertThat(rank.toString(), is("5개 일치, 보너스 볼 일치(30000000)-"));
    }
}