package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {

    Rank rank;

    @Before
    public void setUp(){
        rank = Rank.THIRD;
    }

    @Test
    public void getCountOfMatchTest(){
        assertEquals(5, rank.getCountOfMatch());
    }

    @Test
    public void getWinningMoneyTest(){
        assertEquals(1500000, rank.getWinningMoney);
    }

    @Test
    public void valueOfTest_보너스통과(){
        assertEquals(Rank.SECOND, Rank.valueOf(4, true)); //countOfMatch, matchBonus
     }

    @Test
    public void valueOfTest_보너스통과못함(){
        assertEquals(Rank.THIRD, Rank.valueOf(4, false)); //countOfMatch, matchBonus
    }
}