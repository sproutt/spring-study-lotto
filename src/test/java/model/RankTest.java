package model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    Rank rank;

    @Before
    public void setUp(){
        rank = Rank.THIRD;
    }

    @Test
    public void enum_CountTest(){
        assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
        assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(5);
        assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(5);
        assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(4);
        assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3);
        assertThat(Rank.MISS.getCountOfMatch()).isEqualTo(0);
    }

    @Test
    public void enum_MoneyTest(){
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2000000000);
        assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(30000000);
        assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(1500000);
        assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(50000);
        assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5000);
        assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
    }

    @Test
    public void valueOfTest_보너스통과(){
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.FIFTH);
     }

    @Test
    public void valueOfTest_보너스통과못함(){
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void valueOFTest_상금없음(){
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }
}