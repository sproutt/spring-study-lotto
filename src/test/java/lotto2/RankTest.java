package lotto2;
import lotto2.domain.Rank;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class RankTest {
    Rank rank;

    @Before
    public void setUp(){
        rank = Rank.SECOND;
    }

    @Test
    public void 몇등(){
        assertThat(Rank.valueOf(4),is(Rank.FOURTH));
    }

    @Test
    public void _2등(){
        assertThat(Rank.setSecond(true),is(Rank.SECOND));
        assertThat(Rank.setSecond(false),is(Rank.THIRD));
    }

    @Test
    public void 문자열로(){
        assertThat(rank.toString(),is("5개 일치, 보너스 볼 일치(30000000)-"));
    }
}
