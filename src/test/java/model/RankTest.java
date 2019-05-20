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
    public void enumTest(){
        assertEquals(6, Rank.FIRST.getCountOfMatch());
        assertEquals(5, Rank.SECOND.getCountOfMatch());
        assertEquals(5, Rank.THIRD.getCountOfMatch());
        assertEquals(4, Rank.FOURTH.getCountOfMatch());
        assertEquals(3, Rank.FIFTH.getCountOfMatch());
        assertEquals(0, Rank.MISS.getCountOFMatch());

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
        assertEquals(Rank.FOURTH, Rank.valueOf(3, true));
        assertEquals(Rank.FIFTH, Rank.valueOf(2, true));
     }

    @Test
    public void valueOfTest_보너스통과못함(){
        assertEquals(Rank.THIRD, Rank.valueOf(5, false)); //countOfMatch, matchBonus
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
    }

    @Test
    public void valueOFTest_상금없음(){
        assertEquals(Rank.MISS, Rank.valueOf(1, true));
        assertEquals(Rank.MISS, Rank.valueOf(1, false));
        assertEquals(Rank.MISS, Rank.valueOf(2, true));
        assertEquals(Rank.MISS, Rank.valueOf(2, false));
        assertEquals(Rank.MISS, Rank.valueOf(0, true));
        assertEquals(Rank.MISS, Rank.valueOf(0, false));
    }
}